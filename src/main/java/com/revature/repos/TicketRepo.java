package com.revature.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.revature.models.Ticket;

public interface TicketRepo extends JpaRepository<Ticket, Integer>{

	// JPA or Java Persistence API is the standard for how ORMs should be integrated with Java
	// Has no implementations, but relies on the underlying ORM to fulfill the interfaces that it defines
	// Defines the majority of the annotations used to label entities
}
