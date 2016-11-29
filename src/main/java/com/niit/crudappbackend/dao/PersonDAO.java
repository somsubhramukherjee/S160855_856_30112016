package com.niit.crudappbackend.dao;

import java.util.List;

import com.niit.crudappbackend.model.Person;

public interface PersonDAO {

	public void addPerson(Person p);
	public void updatePerson(Person p);
	public List<Person> listPersons();
	public Person getPersonById(int id);
	public void removePerson(int id);
	
}
