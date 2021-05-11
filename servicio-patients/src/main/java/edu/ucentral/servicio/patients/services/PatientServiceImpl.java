package edu.ucentral.servicio.patients.services;

import org.springframework.stereotype.Service;

import edu.ucentral.commons.patients.model.Patient;
import edu.ucentral.commons.service.services.CommonServiceImpl;
import edu.ucentral.servicio.patients.repository.IPatientRepository;

@Service
public class PatientServiceImpl extends CommonServiceImpl<Patient, IPatientRepository> implements PatientService {

}
