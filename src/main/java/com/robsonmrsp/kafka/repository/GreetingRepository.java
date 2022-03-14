package com.robsonmrsp.kafka.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.robsonmrsp.kafka.model.Greet;

public interface GreetingRepository extends JpaRepository<Greet, UUID> {

}
