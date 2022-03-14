package com.robsonmrsp.kafka.utilities;

import com.robsonmrsp.kafka.controller.data.RequestGreeting;
import com.robsonmrsp.kafka.controller.data.ResponseGreet;
import com.robsonmrsp.kafka.model.Greet;

public class Parser {

	public static Greet toEntity(RequestGreeting request) {

		return new Greet(null, request.getMessage(), request.getToWhom());
	}

	public static ResponseGreet toResponse(Greet g) {
		return new ResponseGreet(String.valueOf(g.getId()), g.getMessage(), g.getToWhom());
	}
}
