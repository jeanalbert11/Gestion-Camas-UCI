package edu.ucentral.servicio.nurses.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.ucentral.servicio.nurses.model.Person;

@Repository
public interface IPersonRepository extends JpaRepository<Person, Long> {

}
