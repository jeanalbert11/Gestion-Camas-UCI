package edu.ucentral.servicio.patients.controllers;

import java.util.Optional;
import javax.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import edu.ucentral.commons.patients.model.Patient;
import edu.ucentral.commons.service.controller.CommonController;
import edu.ucentral.servicio.patients.services.PatientService;

@RestController
public class PatientController extends CommonController<Patient, PatientService> {

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
		patientDB.setNombre(patient.getNombre());
		patientDB.setApellido(patient.getApellido());
		patientDB.setCedula(patient.getCedula());
		patientDB.setCorreo(patient.getCorreo());

		return ResponseEntity.status(HttpStatus.CREATED).body(service.save(patientDB));

	}

	@GetMapping("/patients")
	public ResponseEntity<?> listarPacientes() {
		return ResponseEntity.ok().body(service.findAll());
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
