package edu.ucentral.servicio.patients.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.ucentral.commons.patients.model.Patient;
import edu.ucentral.commons.service.services.CommonServiceImpl;
import edu.ucentral.servicio.patients.clients.BedFeignClient;
import edu.ucentral.servicio.patients.converters.PatientConverter;
import edu.ucentral.servicio.patients.dto.PatientDto;
import edu.ucentral.servicio.patients.repository.IPatientRepository;

@Service
public class PatientServiceImpl extends CommonServiceImpl<Patient, IPatientRepository> implements PatientService {

	@Autowired
	private BedFeignClient bedClient;

	@Override
	public List<Patient> findByNameOrSurname(String nameOrSurname) {
		return repository.findByNameOrSurname(nameOrSurname);
	}

	@Override
	@Transactional(readOnly = true)
	public Iterable<Patient> findAllById(Iterable<Long> ids) {
		return repository.findAllById(ids);
	}

	/*
	 * @Override public Iterable<Long> obtenerCamasAsignadasAPaciente(Long
	 * patientId) {
	 * 
	 * return bedClient.obtenerCamasAsignadasAPaciente(patientId); }
	 */

	@Override
	public void deletePatientDistributed(Long id) {
		bedClient.deletePatientDistributed(id);
	}

	@Override // feing
	@Transactional
	public void deleteById(Long id) {
		super.deleteById(id);
		this.deletePatientDistributed(id);
	}

	@Transactional(readOnly = true)
	public PatientDto findPatientDtoById(Long id) {
		Optional<Patient> optionalPatient = repository.findById(id);
		Patient patient = optionalPatient.get();
		PatientConverter patientConverter = new PatientConverter();
		return patientConverter.convertToDto(patient);
//		PatientDto patientDto = new PatientDto();
//		// data from patient
//		patientDto.setId(patient.getId());
//		patientDto.setFullname(patient.getName() + " " +patient.getSurname());
//		// data from address
//		patientDto.setPostalCode(address.getZipCode());
//		return patientDto;
	}

	public void save(PatientDto patientDto) {
		PatientConverter patientConverter = new PatientConverter();
		Patient patient = patientConverter.convertToEntity(patientDto);
		repository.save(patient);
	}

}
