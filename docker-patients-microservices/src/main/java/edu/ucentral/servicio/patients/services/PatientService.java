package edu.ucentral.servicio.patients.services;

import java.util.Optional;

import edu.ucentral.servicio.patients.model.Patient;

//contrato de la logica a implementar
public interface PatientService {

	public Iterable<Patient> findAll();

	public Optional<Patient> findById(Long id);

	public Patient save(Patient patient);

	public void deleteById(Long id);

}
