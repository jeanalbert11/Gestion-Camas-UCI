package edu.ucentral.servicio.patients.services;


import java.util.List;

import edu.ucentral.commons.patients.model.Patient;
import edu.ucentral.commons.service.services.CommonService;
import edu.ucentral.servicio.patients.dto.PatientDto;

public interface PatientService extends CommonService<Patient> {

	
	public Iterable<Patient> findAllById(Iterable<Long> ids);

	public void deletePatientDistributed(Long id);

	public PatientDto findPatientDtoById(Long id);

	List<Patient> findByNameOrSurname(String nameOrSurname);

}
