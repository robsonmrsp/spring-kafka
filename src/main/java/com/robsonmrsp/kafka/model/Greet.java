package com.robsonmrsp.kafka.model;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@Entity
@ToString
@Table(name = "GREET")
@AllArgsConstructor
@NoArgsConstructor
public class Greet {
	@Id
	private UUID id;

	@Column
	private String message;

	@Column
	private String toWhom;

}
