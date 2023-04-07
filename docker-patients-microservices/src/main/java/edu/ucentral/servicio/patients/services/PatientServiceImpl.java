package edu.ucentral.servicio.patients.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import edu.ucentral.servicio.patients.model.Patient;
import edu.ucentral.servicio.patients.repository.IPatientRepository;

//implementar la logica del negocio del repository
@Service
public class PatientServiceImpl implements PatientService {

	@Autowired
	private IPatientRepository patientRepository;

	@Override
	@Transactional(readOnly = true)
	public Iterable<Patient> findAll() {
		return patientRepository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Patient> findById(Long id) {
		return patientRepository.findById(id);
	}

	@Override
	@Transactional
	public Patient save(Patient patient) {
		return patientRepository.save(patient);
	}

	@Override
	@Transactional
	public void deleteById(Long id) {
		patientRepository.deleteById(id);
	}

}
