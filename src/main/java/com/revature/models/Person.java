package com.revature.models;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="PEOPLE")
public class Person {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column
	private int id;
	
	@Column
	private String email; // variable names must match column names in database
	
	@Column
	private String uname;
	
	@Column
	private String perrole;
	
	@Column
	private String pswd;
		
	public Person(int id, String email, String perrole, String pswd) {
		super();
		this.id = id;
		this.email = email;
		this.perrole = "employee"; // is this the correct way to make the default role employee?
		this.pswd = pswd;
	}

	public Person(int id, String email, String uname, String perrole, String pswd) {
		super();
		this.id = id;
		this.email = email;
		this.uname = uname;
		this.perrole = perrole;
		this.pswd = pswd;
	}

	public Person() {
		super();
	}
	

	public Person(String email, String uname, String perrole, String pswd) {
		super();
		this.email = email;
		this.uname = uname;
		this.perrole = perrole;
		this.pswd = pswd;
	}
	
	public Person(String email, String pswd) {
		this.email = email;
		this.pswd = pswd;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUsername() {
		return uname;
	}

	public void setUsername(String username) {
		this.uname = username;
	}

	public String getRole() {
		return perrole;
	}

	public void setRole(String perrole) {
		this.perrole = perrole;
	}

	public String getPassword() {
		return pswd;
	}

	public void setPassword(String pswd) {
		this.pswd = pswd;
	}

	@Override
	public int hashCode() {
		return Objects.hash(email, id, pswd, perrole, uname);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		return Objects.equals(email, other.email) && id == other.id && Objects.equals(pswd, other.pswd)
				&& Objects.equals(perrole, other.perrole) && Objects.equals(uname, other.uname);
	}

	@Override
	public String toString() {
		return "Person [id=" + id + ", email=" + email + ", username=" + uname + ", role=" + perrole + ", password="
				+ pswd + "]";
	}
		
	
		
}



