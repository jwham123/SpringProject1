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
import com.revature.services.PersonService;

@RestController
@RequestMapping(value="/person")
@CrossOrigin
public class PersonController {

	private PersonService ps;
	
	@GetMapping
	public ResponseEntity<List<Person>> getAll() {
		return ResponseEntity.status(HttpStatus.OK).body(ps.showPeople());
	}
	
	@GetMapping(value="/{id}")
	public ResponseEntity<Person> getTicket(@PathVariable("id") int id) {
		return ResponseEntity.status(HttpStatus.OK).body(ps.findPersonById(id));
	}

	@PostMapping
	public ResponseEntity<List<Person>> newPerson(@RequestBody Person p) {
		ps.register(p);
		return ResponseEntity.status(HttpStatus.OK).body(ps.showPeople());
	}
	
	@Autowired
	public PersonController(PersonService ps) {
		super();
		this.ps = ps;
	}
}
