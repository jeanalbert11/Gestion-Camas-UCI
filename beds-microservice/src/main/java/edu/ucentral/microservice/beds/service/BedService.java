package edu.ucentral.microservice.beds.service;

import java.util.List;
import edu.ucentral.commons.beds.model.Bed;
import edu.ucentral.commons.nurses.model.Nurse;
import edu.ucentral.commons.patients.model.Patient;
import edu.ucentral.commons.service.services.CommonService;

public interface BedService extends CommonService<Bed> {

	public List<Bed> findByCode(String code);

	public List<Bed> findByState(boolean estado);

	// public Iterable<Long> findBedsIdsAssignedToPaciente(Long pacienteId);

	public List<Nurse> findAllNurses();

	public Iterable<Patient> findAllPatientsById(List<Long> ids);
	
	public void deleteHistoryAssignmentById(Long id);

	public void deletePatientByIdFromPatientsMicroservice(Long id);

	public void deletePatientByIdDistributed(Long id);

	public void deletePatientDistributed(Long id);


}
