package edu.ucentral.servicio.patients.controllers;

import java.util.List;
import java.util.Optional;
import javax.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import edu.ucentral.commons.patients.model.Patient;
import edu.ucentral.commons.service.controller.CommonController;
import edu.ucentral.servicio.patients.dto.PatientDto;
import edu.ucentral.servicio.patients.services.PatientService;

@RestController
public class PatientController extends CommonController<Patient, PatientService> {

	@GetMapping("/find-all-patients-by-id")
	public ResponseEntity<?> getPatientsByBed(@RequestParam List<Long> ids) {
		return ResponseEntity.ok(service.findAllById(ids));
	}

	@PutMapping("/{id}")
	public ResponseEntity<?> editar(@Valid @RequestBody Patient patient, BindingResult result, @PathVariable Long id) {
		if (result.hasErrors()) {
			return this.validar(result);
		}
		Optional<Patient> optional = service.findById(id);
		if (!optional.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		Patient patientDB = optional.get();
		patientDB.setName(patient.getName());
		patientDB.setSurname(patient.getSurname());
		patientDB.setIdentityCard(patient.getIdentityCard());
		patientDB.setEmail(patient.getEmail());

		return ResponseEntity.status(HttpStatus.CREATED).body(service.save(patientDB));

	}

	@GetMapping("/patients")
	public ResponseEntity<?> listarPacientes() {
		return ResponseEntity.ok().body(service.findAll());
	}

	
	
	@GetMapping(value = "/findPatientDtoById/{id}")
	public ResponseEntity<PatientDto> findPatientDtoById(@PathVariable Long id) {
		PatientDto patientDto = service.findPatientDtoById(id);
		return ResponseEntity.ok(patientDto);
	}

	/*
	 * @GetMapping(value = "/{id}") public ResponseEntity<?>
	 * buscarPorPacienteId(@PathVariable Long id) { Patient patient =
	 * service.findPatienById(id); if (patient != null) { List<Long> bedsIds =
	 * (List<Long>) service.obtenerCamasAsignadasAPaciente(id); List<Bed> beds =
	 * patient.getPatients().stream().map(bed -> { if
	 * (bedsIds.contains(bed.getId())) { bed.setEstado(true); } return bed;
	 * }).collect(Collectors.toList()); patient.setBeds(beds); } return
	 * ResponseEntity.ok(patient); }
	 */

}
