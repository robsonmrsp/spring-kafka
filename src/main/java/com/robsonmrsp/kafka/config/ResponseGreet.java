package com.robsonmrsp.kafka.config;

import java.util.UUID;

import javax.persistence.Column;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
public class ResponseGreet {
	private String id;

	private String message;

	private String toWhom;
}
