package com.robsonmrsp.kafka.config;

public class Parser {

	public static Greet toEntity(RequestGreeting request) {

		return new Greet(null, request.getMessage(), request.getToWhom());
	}

	public static ResponseGreet toResponse(Greet g) {
		return new ResponseGreet(String.valueOf(g.getId()), g.getMessage(), g.getToWhom());
	}
}
