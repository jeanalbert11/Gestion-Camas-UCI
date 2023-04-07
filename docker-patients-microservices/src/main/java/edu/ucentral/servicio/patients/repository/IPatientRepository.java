package edu.ucentral.servicio.patients.repository;

import org.springframework.data.repository.CrudRepository;
import edu.ucentral.servicio.patients.model.Patient;


public interface IPatientRepository extends CrudRepository<Patient, Long> {

}
