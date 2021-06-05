package edu.ucentral.servicio.patients.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import edu.ucentral.commons.patients.model.Patient;


public interface IPatientRepository extends PagingAndSortingRepository<Patient, Long> {

}
