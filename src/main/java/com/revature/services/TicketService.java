package com.revature.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.models.Ticket;
import com.revature.repos.TicketRepo;

@Service // stereotype annotation that registers this class as a Spring Bean with the Spring Container
public class TicketService {

	private TicketRepo tdao;
	
	@Autowired // used above a setter, constructor or field in a class that is
	// registered as a bean will indicate that there is a dependency that needs to be 
	// provided and the method of which it should be injected
	public TicketService(TicketRepo tdao) {
		super();
		this.tdao = tdao;
	}
	
	public List<Ticket> showTickets() {
		return tdao.findAll();
	}
	
	public void addTick(Ticket ticket) {
		tdao.save(ticket);
	}
	
	public Ticket findTicketById(int id) {
		Optional<Ticket> opt = tdao.findById(id);
		if(opt.isPresent()) {
			return opt.get();
		} else {
			return null;
		}
		//return tdao.findById(id).get();
	}
}
