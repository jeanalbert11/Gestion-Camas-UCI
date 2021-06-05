package edu.ucentral.microservice.beds.controller;

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
import org.springframework.web.bind.annotation.RestController;
import edu.ucentral.commons.beds.model.Bed;
import edu.ucentral.commons.patients.model.Patient;
import edu.ucentral.commons.service.controller.CommonController;
import edu.ucentral.microservice.beds.service.BedService;

@RestController
public class BedController extends CommonController<Bed, BedService> {

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
		dbBed.setCodigo(bed.getCodigo());
		dbBed.setNurse(bed.getNurse());
		return ResponseEntity.status(HttpStatus.CREATED).body(service.save(dbBed));

	}

	// Cambiar por el que esta abajo
	@PutMapping("/{id}/asignar-paciente")
	public ResponseEntity<?> asignarPaciente(@RequestBody List<Patient> patients, @PathVariable Long id) {
		Optional<Bed> optional = service.findById(id);
		if (!optional.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		Bed dbBed = optional.get();
		patients.forEach(patient -> {
			// dbBed.addPatient(patient);
			// dbBed.setEstado(true);

		});
		return ResponseEntity.status(HttpStatus.CREATED).body(service.save(dbBed));
	}
	
	
	@GetMapping("/filtrarPorCodigo/{codigo}")
	public ResponseEntity<?> filtrarPorCodigo(@PathVariable String codigo) {
		return ResponseEntity.ok(service.findByRoom(codigo));
	}

	/*
	 * @GetMapping("filtrarPorEstado/{estado}") public ResponseEntity<?>
	 * filtrarPorEstado(@PathVariable boolean estado) { return
	 * ResponseEntity.ok(service.findByEstate(estado)); }
	 * 
	 * @GetMapping("/patient/{patientId}/camas-asignadas") public ResponseEntity<?>
	 * obtenerCamasAsignadasAPaciente(@PathVariable Long patientId) { Iterable<Long>
	 * bedIds = service.findBedsIdsAssignedToPaciente(patientId); return
	 * ResponseEntity.ok(bedIds); }
	 */
	@GetMapping("/nurses")
	public ResponseEntity<?> listarEnfermeras() {
		return ResponseEntity.ok(service.findAllNurses());
	}
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

	/*
	 * @GetMapping("/{id}/asignar-enfermeras") public ResponseEntity<?>
	 * asignarEnfermera(@RequestBody List<Nurse> nurses, @PathVariable Long id) {
	 * 
	 * Optional<Bed> optional = service.findById(id);
	 * 
	 * if (!optional.isPresent()) { return ResponseEntity.notFound().build(); }
	 * 
	 * Bed dbBed = optional.get(); nurses.forEach(n -> { dbBed.getNurse().getId();
	 * });
	 * 
	 * return ResponseEntity.status(HttpStatus.CREATED).body(service.save(dbBed)); }
	 */

	// Metodo que retorna el grupo del camas
	@PutMapping("/{id}/asignar-paciente2")
	public ResponseEntity<?> adicionarCamas(@Valid @RequestBody Bed bed, BindingResult result, @PathVariable Long id) {

		if (result.hasErrors()) {
			return this.validar(result);
		}
		Optional<Bed> optional = service.findById(id);
		if (!optional.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		Bed dbBed = optional.get();
		// dbBed.setPatient(bed.getPatient());
		return ResponseEntity.status(HttpStatus.CREATED).body(service.save(dbBed));

	}

}
