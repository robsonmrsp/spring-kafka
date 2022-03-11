package com.robsonmrsp.kafka.config;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

public interface GreetingRepository extends JpaRepository<Greet, UUID> {

}
