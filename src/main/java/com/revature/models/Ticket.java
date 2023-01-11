package com.revature.models;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity // class level annotation identifies the class as an entity to be managed by the ORM, mapped to a table in the database
@Table(name="TICKETS")
public class Ticket {

	@Id // declares the field as the primary key for the entity record
	@GeneratedValue(strategy=GenerationType.IDENTITY) // used to generate primary keys
	private int id;
	
	@Column // field level annotation that allows me to set up optional configurations of that column
	private float amount;
	
	@Column
	private String status;
	
	@Column
	private String descript;
	
	//@OneToMany(fetch=FetchType.EAGER, cascade=CascadeType.ALL) // there are many tickets to one person
	@ManyToOne(fetch=FetchType.EAGER)
	private Person person;
	
	
	public Ticket(int id, float amount, String status, String descript, Person person) {
		super();
		this.id = id;
		this.amount = amount;
		this.status = status;
		this.descript = descript;
		this.person = person;
	}

	public Ticket() {
		super();
	}

	public Ticket(float amount, String status, String descript, Person person) {
		super();
		this.amount = amount;
		this.status = status;
		this.descript = descript;
		this.person = person;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public float getAmount() {
		return amount;
	}

	public void setAmount(float amount) {
		this.amount = amount;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getDescription() {
		return descript;
	}

	public void setDescription(String descript) {
		this.descript = descript;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	@Override
	public int hashCode() {
		return Objects.hash(amount, descript, id, person, status);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Ticket other = (Ticket) obj;
		return Float.floatToIntBits(amount) == Float.floatToIntBits(other.amount)
				&& Objects.equals(descript, other.descript) && id == other.id
				&& Objects.equals(person, other.person) && Objects.equals(status, other.status);
	}

	@Override
	public String toString() {
		return "Ticket [id=" + id + ", amount=" + amount + ", status=" + status + ", description=" + descript
				+ ", person=" + person + "]";
	}
	
	
}
