package com.robsonmrsp.kafka.async;

import java.time.LocalDate;
import java.util.Date;
import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.kafka.support.SendResult;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;

import com.robsonmrsp.kafka.avro.GreetEvent;
import com.robsonmrsp.kafka.model.Greet;

@Component
public class GreetingProducer {

	private static final Logger LOGGER = LoggerFactory.getLogger(GreetingProducer.class);

	@Autowired
	KafkaTemplate<Integer, GreetEvent> kafkaTemplate;

	public void send(Greet g) {
		Integer key = new Random(new Date().getTime()).nextInt();
		GreetEvent event = new GreetEvent(g.getId().toString(), g.getMessage(), g.getToWhom());

		String message = String.format("Bom dia %s-id[%s] %s!", g.getMessage(), g.getId().toString(), g.getToWhom());
		LOGGER.info("Sending-> {}", message);

		ListenableFuture<SendResult<Integer, GreetEvent>> send = kafkaTemplate.send(createMessageWithHeaders(key, event, "greeting-topic-avro"));
		send.addCallback(a -> {
			LOGGER.info("Sent: {}", a.getProducerRecord().topic());
		}, b -> {
			LOGGER.error("Error sending message: {}", b.getLocalizedMessage());
		});
	}

	private Message<GreetEvent> createMessageWithHeaders(Integer messageId, GreetEvent event, String topic) {
		return MessageBuilder.withPayload(event)
				.setHeader("hash", event.hashCode())
				.setHeader("version", "1.0.0")
				.setHeader("endOfLife", LocalDate.now().plusDays(1L))
				.setHeader("type", "fct")
				.setHeader("cid", messageId)
				.setHeader(KafkaHeaders.TOPIC, topic)
				.setHeader(KafkaHeaders.MESSAGE_KEY, messageId)
				.build();
	}
}
