package com.revature.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.revature.models.Person;

public interface PersonRepo extends JpaRepository<Person, Integer>{

}
