package com.robsonmrsp.kafka.async;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import com.robsonmrsp.kafka.model.Greet;

@Component
public class GreetingProducer {

	private static final Logger LOGGER = LoggerFactory.getLogger(GreetingProducer.class);

	@Autowired
	KafkaTemplate<String, String> kafkaTemplate;

	public void send(Greet g) {

		String message = String.format("Bom dia %s-id[%s] %s!", g.getMessage(), g.getId().toString(), g.getToWhom());
		LOGGER.info("Sending-> {}", message);
		kafkaTemplate.send("greeting-topic", g.getId().toString(), message);
	}
}
