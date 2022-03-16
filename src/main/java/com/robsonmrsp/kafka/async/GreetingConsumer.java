package com.robsonmrsp.kafka.async;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import com.robsonmrsp.kafka.avro.GreetEvent;

@Component
public class GreetingConsumer {

	private static final Logger LOGGER = LoggerFactory.getLogger(GreetingConsumer.class);

	@KafkaListener(topics = "greeting-topic-avro")
	public void consume(@Payload GreetEvent message) {

		LOGGER.info("Receiving-> {}", message);
	}
}