package edu.ucentral.servicio.patients.services;



import edu.ucentral.commons.patients.model.Patient;
import edu.ucentral.commons.service.services.CommonService;

public interface PatientService extends CommonService<Patient> {

	//@Query("SELECT p FROM Patient p WHERE p.nombre LIKE %?1%  or p.apellido LIKE %?1%")
	//public List<Patient> findByNameOrLastName(String nameOrLastname);

}
