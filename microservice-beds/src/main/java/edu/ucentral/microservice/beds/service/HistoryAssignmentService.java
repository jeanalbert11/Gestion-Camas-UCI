package edu.ucentral.microservice.beds.service;

import java.util.List;

import edu.ucentral.commons.beds.model.Bed;
import edu.ucentral.commons.beds.model.HistoryAssignment;
import edu.ucentral.commons.patients.model.Patient;
import edu.ucentral.commons.service.services.CommonService;

public interface HistoryAssignmentService extends CommonService<HistoryAssignment> {

	List<Patient> findAllPatients();

	List<Bed> findAllBeds();
	// HistoryAssignment findBedByPatientId(Long id);

}
