package edu.ucentral.servicio.test.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import edu.ucentral.servicio.test.model.Person;
import edu.ucentral.servicio.test.repository.IPersonRepository;

@Service
public class PersonServiceImpl implements PersonService{

	@Autowired
	private IPersonRepository personRepository;

	@Override
	@Transactional(readOnly = true)
	public Iterable<Person> findAll() {
		return personRepository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Person> findById(Long id) {
		return personRepository.findById(id);
	}

	@Override
	@Transactional
	public Person save(Person person) {
		return personRepository.save(person);
	}

	@Override
	@Transactional
	public void deleteById(Long id) {
		personRepository.deleteById(id);
	}

}
