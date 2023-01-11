package com.revature.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.models.Person;
import com.revature.repos.PersonRepo;

@Service
public class PersonService {

	private PersonRepo pdao;
	
	@Autowired // used above a setter, constructor or field in a class that is registered as a bean will indicate that there is a dependency that needs to be provided and the method of which it should be injected
	public PersonService(PersonRepo pdao) {
		super();
		this.pdao = pdao;
	}
	
	public List<Person> showPeople() {
		return pdao.findAll();
	}
	
	public void register(Person person) {
		pdao.save(person);
	}
	
	public Person findPersonById(int id) {
		return pdao.findById(id).get();
	}
}
