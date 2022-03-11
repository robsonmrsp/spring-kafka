package com.robsonmrsp.kafka.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class GreetingProducer {

	private static final Logger LOGGER = LoggerFactory.getLogger(GreetingProducer.class);

	@Autowired
	KafkaTemplate<String, String> kafkaTemplate;

	public void send(Greet g) {
		LOGGER.info("GreetingProducer.send()" + g);
		kafkaTemplate.send("spring-kafka-topic", g.getId().toString(), String.format("Bom dia %s, %s!", g.getMessage(), g.getToWhom())).addCallback(null);
	}
}
