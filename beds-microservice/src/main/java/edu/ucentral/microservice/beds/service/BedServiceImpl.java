package edu.ucentral.microservice.beds.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import edu.ucentral.commons.beds.model.Bed;
import edu.ucentral.commons.nurses.model.Nurse;
import edu.ucentral.commons.patients.model.Patient;
import edu.ucentral.commons.service.services.CommonServiceImpl;
import edu.ucentral.microservice.beds.clients.NurseFeignClient;
import edu.ucentral.microservice.beds.clients.PatientFeignClient;
import edu.ucentral.microservice.beds.repository.IBedRepository;

@Service
public class BedServiceImpl extends CommonServiceImpl<Bed, IBedRepository> implements BedService {

	@Autowired
	private NurseFeignClient nurseFeignClient;

	@Autowired
	private PatientFeignClient patientFeignClient;

	/*
	 * @Override
	 * 
	 * @Transactional(readOnly = true) public Iterable<Long>
	 * findBedsIdsAssignedToPaciente(Long pacienteId) { return
	 * repository.findBedsIdsAssignedToPaciente(pacienteId); }
	 */

	@Override
	@Transactional(readOnly = true)
	public List<Bed> findByCode(String code) {
		return repository.findByCode(code);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Bed> findByState(boolean state) {
		return repository.findByState(state);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Nurse> findAllNurses() {
		return nurseFeignClient.findAllNurses();
	}

	@Override
	public Iterable<Patient> findAllPatientsById(List<Long> ids) {
		return patientFeignClient.findAllPatientsById(ids);
	}

	@Override
	@Transactional
	public void deleteHistoryAssignmentById(Long id) {
		deletePatientDistributed(id);
	}

	@Override
	@Transactional
	public void deletePatientByIdFromPatientsMicroservice(Long id) {
		deletePatientDistributed(id);
	}

	@Override
	@Transactional
	public void deletePatientByIdDistributed(Long id) {
		deletePatientDistributed(id);
	}

	@Override
	@Transactional
	public void deletePatientDistributed(Long id) {
		repository.deletePatientDistributed(id);
	}

}
