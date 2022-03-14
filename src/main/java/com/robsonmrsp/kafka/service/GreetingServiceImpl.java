package com.robsonmrsp.kafka.service;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.robsonmrsp.kafka.async.GreetingProducer;
import com.robsonmrsp.kafka.model.Greet;
import com.robsonmrsp.kafka.repository.GreetingRepository;

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
