package com.robsonmrsp.kafka.config;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GreetingServiceImpl implements GreetingService {

	@Autowired
	GreetingProducer producer;

	@Autowired
	GreetingRepository repository;

	@Override
	public Greet greet(Greet greet) {
	
		greet.setId(UUID.randomUUID());

		Greet g = repository.save(greet);

		producer.send(g);
		return g;
	}

}
