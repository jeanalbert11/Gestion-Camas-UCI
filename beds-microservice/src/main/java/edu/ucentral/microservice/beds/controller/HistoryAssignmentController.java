package edu.ucentral.microservice.beds.controller;

import java.util.Optional;
import javax.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.ucentral.commons.beds.model.HistoryAssignment;
import edu.ucentral.commons.service.controller.CommonController;
import edu.ucentral.microservice.beds.service.HistoryAssignmentService;

@RestController
@RequestMapping("/historyAssignments")
public class HistoryAssignmentController extends CommonController<HistoryAssignment, HistoryAssignmentService> {

	@PutMapping("/{id}")
	public ResponseEntity<?> editar(@Valid @RequestBody HistoryAssignment historyAssignment, BindingResult result,
			@PathVariable Long id) {
		if (result.hasErrors()) {
			return this.validar(result);
		}
		Optional<HistoryAssignment> optional = service.findById(id);

		if (!optional.isPresent()) {
			return ResponseEntity.notFound().build();
		}

		HistoryAssignment historyAssignmentDB = optional.get();
		historyAssignmentDB.setId(historyAssignment.getId());
		historyAssignmentDB.setBed(historyAssignment.getBed());
		historyAssignmentDB.setPatientId(historyAssignment.getPatientId());
		historyAssignmentDB.setStartDate(historyAssignment.getStartDate());
		historyAssignmentDB.setEndDate(historyAssignment.getStartDate());

		return ResponseEntity.status(HttpStatus.CREATED).body(service.save(historyAssignmentDB));

	}
	
	
	/*
	 * @GetMapping("/patient/{id}") public ResponseEntity<?>
	 * findPatientById(@PathVariable Long id){ HistoryAssignment assignment =
	 * service.findBedByPatientId(id); return ResponseEntity.ok(assignment);
	 * 
	 * }
	 */

	@GetMapping("/patients")
	public ResponseEntity<?> listarPacientes() {
		return ResponseEntity.ok(service.findAllPatients());
	}

	@GetMapping("/beds")
	public ResponseEntity<?> listarCamas() {
		return ResponseEntity.ok(service.findAllBeds());
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
