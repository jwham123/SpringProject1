package com.revature.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.models.Person;
import com.revature.models.Ticket;
import com.revature.services.TicketService;

@RestController // combines the stereotype annotation @Controller and @ResponeBody, body of response will be JSON
@RequestMapping(value="/ticket") // specifies the URL path and HTTP verb that a certain method or class will handle
@CrossOrigin // provides a CORS filter for requests that are coming through to the end points
public class TicketController {

	private TicketService ts;
	
	@GetMapping
	public ResponseEntity<List<Ticket>> getAll() {
		return ResponseEntity.status(HttpStatus.OK).body(ts.showTickets());
	}
	
	@GetMapping(value="/{id}")
	public ResponseEntity<Ticket> getTicket(@PathVariable("id") int id) {
		Ticket person = ts.findTicketById(id);
		if (person == null) {
			return ResponseEntity.status(204).build();
		}
		return ResponseEntity.status(200).body(person);
	}

	@PostMapping
	public ResponseEntity<List<Ticket>> newTicket(@RequestBody Ticket t) {
		ts.addTick(t);
		return ResponseEntity.status(HttpStatus.OK).body(ts.showTickets());
	}
	
	@Autowired
	public TicketController(TicketService ts) {
		super();
		this.ts = ts;
	}
}
