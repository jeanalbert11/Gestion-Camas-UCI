package edu.ucentral.servicio.medical.staff.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.ucentral.servicio.medical.staff.model.Person;

@Repository
public interface IPersonRepository extends JpaRepository<Person, Long> {

}
