package edu.ucentral.servicio.patients.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import edu.ucentral.commons.patients.model.Patient;


public interface IPatientRepository extends PagingAndSortingRepository<Patient, Long> {

	@Query("SELECT p FROM Patient p WHERE p.name LIKE %?1%  or p.surname LIKE %?1%")
	public List<Patient> findByNameOrSurname(String nameOrSurname);

}
