package com.robsonmrsp.kafka.controller.data;

import lombok.Data;

@Data
public class RequestGreeting {
	private String message;
	private String toWhom;
}
