package com.robsonmrsp.kafka.async;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class GreetingConsumer {

	private static final Logger LOGGER = LoggerFactory.getLogger(GreetingConsumer.class);

	@KafkaListener(topics = "greeting-topic")
	public void consume(String message) {
		LOGGER.info("Receiving-> {}", message);
	}
}