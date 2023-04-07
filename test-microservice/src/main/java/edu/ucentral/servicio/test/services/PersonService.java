package edu.ucentral.servicio.test.services;

import java.util.Optional;
import edu.ucentral.servicio.test.model.Person;

public interface PersonService {

	public Iterable<Person> findAll();

	public Optional<Person> findById(Long id);

	public Person save(Person person);

	public void deleteById(Long id);
}
