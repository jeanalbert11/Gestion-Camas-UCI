package edu.ucentral.microservice.beds.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.ucentral.commons.beds.model.Bed;
import edu.ucentral.commons.beds.model.HistoryAssignment;
import edu.ucentral.commons.patients.model.Patient;
import edu.ucentral.commons.service.services.CommonServiceImpl;
import edu.ucentral.microservice.beds.clients.PatientFeignClient;
import edu.ucentral.microservice.beds.repository.IHistoryAssignmentRepository;

@Service
public class HistoryAssignmentServiceImpl extends CommonServiceImpl<HistoryAssignment, IHistoryAssignmentRepository>
		implements HistoryAssignmentService {

	@Autowired
	private PatientFeignClient patientFeignClient;

	@Autowired
	private BedService bedService;
	/*
	 * @Override
	 * 
	 * @Transactional(readOnly = true) public HistoryAssignment
	 * findBedByPatientId(Long id) { return repository.findBedByPatientId(id); }
	 */

	@Override
	@Transactional(readOnly = true)
	public List<Patient> findAllPatients() {
		return patientFeignClient.findAllPatients();
	}

	@Override
	@Transactional(readOnly = true)
	public List<Bed> findAllBeds() {
		// TODO Auto-generated method stub
		return (List<Bed>) bedService.findAll();
	}

}
