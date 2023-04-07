package edu.ucentral.microservice.beds.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import edu.ucentral.commons.beds.model.Bed;
import edu.ucentral.commons.beds.model.HistoryAssignment;
import edu.ucentral.commons.patients.model.Patient;
import edu.ucentral.commons.service.controller.CommonController;
import edu.ucentral.microservice.beds.service.BedService;

@RestController
public class BedController extends CommonController<Bed, BedService> {

	@GetMapping(value = "/{id}")
	@Override
	public ResponseEntity<?> ver(@PathVariable Long id) {
		Optional<Bed> optional = service.findById(id);
		if (!optional.isPresent()) {
			// notFound: status 404
			return ResponseEntity.notFound().build();
		}

		Bed bed = optional.get();
		// Valido si hay asignacion de pacientes
		if (bed.getHistoryAssignments().isEmpty() == false) {
			List<Long> ids = bed.getHistoryAssignments().stream().map(ha -> ha.getPatientId())
					.collect(Collectors.toList());

			List<Patient> patients = (List<Patient>) service.findAllPatientsById(ids);

			bed.setPatients(patients);
		}
		return ResponseEntity.ok().body(bed);// enviando Entity como un JSON
	}

	@GetMapping
	@Override
	public ResponseEntity<?> listar() {
		List<Bed> beds = ((List<Bed>) service.findAll()).stream().map(b -> {
			b.getHistoryAssignments().forEach(ha -> {
				Patient patient = new Patient();
				patient.setId(ha.getPatientId());
				b.addPatient(patient);
			});
			return b;
		}).collect(Collectors.toList());
		return ResponseEntity.ok().body(beds);// ok: status 200
	}

	@PutMapping("/{id}")
	public ResponseEntity<?> editar(@Valid @RequestBody Bed bed, BindingResult result, @PathVariable Long id) {
		if (result.hasErrors()) {
			return this.validar(result);
		}
		Optional<Bed> optional = service.findById(id);
		if (!optional.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		Bed dbBed = optional.get();
		dbBed.setCode(bed.getCode());
		dbBed.setNurse(bed.getNurse());
		dbBed.setState(bed.isState());
		return ResponseEntity.status(HttpStatus.CREATED).body(service.save(dbBed));

	}

	// Metodo que retorna el grupo de pacientes
	@PutMapping("/{id}/assign-patient-to-bed")
	public ResponseEntity<?> assignPatientToBed(@Valid @RequestBody List<Patient> patients, BindingResult result,
			@PathVariable Long id) {
		if (result.hasErrors()) {
			return this.validar(result);
		}
		Optional<Bed> optional = service.findById(id);
		if (!optional.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		Bed dbBed = optional.get();

		patients.forEach(p -> {
			HistoryAssignment historyAssignment = new HistoryAssignment();
			historyAssignment.setPatientId(p.getId());
			historyAssignment.setBed(dbBed);
			dbBed.setState(true);
			dbBed.addHistoryAssignments(historyAssignment);// assign-patient-to-bed
		});

		return ResponseEntity.status(HttpStatus.CREATED).body(service.save(dbBed));

	}

	@PutMapping("/{id}/remove-patient-to-bed")
	public ResponseEntity<?> removePatientToBed(@Valid @RequestBody Patient patient, BindingResult result,
			@PathVariable Long id) {
		if (result.hasErrors()) {
			return this.validar(result);
		}
		Optional<Bed> optional = service.findById(id);
		if (!optional.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		Bed dbBed = optional.get();
		HistoryAssignment historyAssignment = new HistoryAssignment();
		historyAssignment.setPatientId(patient.getId());

		dbBed.removeHistoryAssignments(historyAssignment);// remove-patient-to-bed
		return ResponseEntity.status(HttpStatus.CREATED).body(service.save(dbBed));

	}

	@GetMapping("/nurses")
	public ResponseEntity<?> listarEnfermeras() {
		return ResponseEntity.ok(service.findAllNurses());
	}

	@GetMapping("/filtrarPorCodigo/{codigo}")
	public ResponseEntity<?> filtrarPorCodigo(@PathVariable String codigo) {
		return ResponseEntity.ok(service.findByCode(codigo));
	}

	@GetMapping("/filtrarPorEstado/{estado}")
	public ResponseEntity<?> filtrarPorEstado(@PathVariable boolean estado) {
		return ResponseEntity.ok(service.findByState(estado));
	}

	@GetMapping("delete-patient-distributed/{id}")
	public ResponseEntity<?> deleteHistoryAssignmentById(@PathVariable Long id) {
		service.deletePatientDistributed(id);
		return ResponseEntity.noContent().build();
	}

	/*
	 * @GetMapping("/patient/{patientId}/camas-asignadas") public ResponseEntity<?>
	 * obtenerCamasAsignadasAPaciente(@PathVariable Long patientId) { Iterable<Long>
	 * bedIds = service.findBedsIdsAssignedToPaciente(patientId); return
	 * ResponseEntity.ok(bedIds); }
	 */

	/*
	 * @GetMapping(value = "/{id}") public ResponseEntity<?>
	 * buscarPorPacienteId(@PathVariable Long id) { Patient patient =
	 * service.findById(id); if (patient != null) { List<Long> bedsIds =
	 * (List<Long>) service.findBedsIdsAssignedToPaciente(id); List<Bed> beds =
	 * ((Collection<Bed>) service.findAll()).stream().map(bed -> { if
	 * (bedsIds.contains(bed.getId())) { bed.setEstado(true); } return bed;
	 * }).collect(Collectors.toList()); //patient.setBeds(beds); } return
	 * ResponseEntity.ok(patient); }
	 */
	// Metodo que retorna el grupo del estudiante

}
