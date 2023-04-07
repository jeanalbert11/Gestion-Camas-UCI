package edu.ucentral.servicio.test.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import edu.ucentral.servicio.test.model.Person;


public interface IPersonRepository extends JpaRepository<Person, Long> {

}
