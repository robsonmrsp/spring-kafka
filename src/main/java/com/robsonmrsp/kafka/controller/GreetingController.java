package com.robsonmrsp.kafka.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.robsonmrsp.kafka.controller.data.RequestGreeting;
import com.robsonmrsp.kafka.controller.data.ResponseGreet;
import com.robsonmrsp.kafka.model.Greet;
import com.robsonmrsp.kafka.service.GreetingService;
import com.robsonmrsp.kafka.utilities.Parser;

@RestController
@RequestMapping("/greetings")
public class GreetingController {

	@Autowired
	GreetingService greetingService;

	@GetMapping("/ping")
	public String ping() {
		return "pong";
		
	}

	@PostMapping
	public ResponseEntity<ResponseGreet> greet(@RequestBody RequestGreeting request) {

		Greet g = greetingService.greet(Parser.toEntity(request));

		return ResponseEntity.ok(Parser.toResponse(g));
	}
}
