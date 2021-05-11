package edu.ucentral.servicio.beds.controller;

import java.util.List;
import java.util.Optional;
import javax.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import edu.ucentral.commons.patients.model.Patient;
import edu.ucentral.commons.service.controller.CommonController;
import edu.ucentral.servicio.beds.model.Bed;
import edu.ucentral.servicio.beds.model.Unit;
import edu.ucentral.servicio.beds.service.BedService;

@RestController
public class BedController extends CommonController<Bed, BedService> {

	@PutMapping("/{id}")
	public ResponseEntity<?> editar(@Valid @RequestBody Bed bed, @PathVariable Long id, BindingResult result) {

		if (result.hasErrors()) {
			return this.validar(result);
		}

		Optional<Bed> optional = service.findById(id);

		if (!optional.isPresent()) {
			return ResponseEntity.notFound().build();
		}

		Bed dbBed = optional.get();
		dbBed.setCodigo(bed.getCodigo());
		dbBed.setEstado(bed.getEstado());
		dbBed.setPatient(bed.getPatient());

		return ResponseEntity.status(HttpStatus.CREATED).body(service.save(dbBed));

	}

	// Metodo que retorna el grupo del camas
	@PutMapping("/{id}/asignar-paciente2")
	public ResponseEntity<?> adicionarCamas(@Valid @RequestBody Bed bed, @PathVariable Long id, BindingResult result) {

		if (result.hasErrors()) {
			return this.validar(result);
		}

		Optional<Bed> optional = service.findById(id);

		if (!optional.isPresent()) {
			return ResponseEntity.notFound().build();
		}

		Bed dbBed = optional.get();
		
		dbBed.setPatient(bed.getPatient());

		return ResponseEntity.status(HttpStatus.CREATED).body(service.save(dbBed));

	}
	
	@PutMapping("/{id}/asignar-paciente")
	public ResponseEntity<?> asignarPaciente(@RequestBody List<Patient> patients, @PathVariable Long id) {
		Optional<Bed> optional = service.findById(id);
		if (!optional.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		Bed dbBed = optional.get();
		patients.forEach(patient -> {
			dbBed.addPatient(patient);
		});
		return ResponseEntity.status(HttpStatus.CREATED).body(service.save(dbBed));
	}

	/*
	 * 
	 * 
	 * 
	 * @GetMapping("/nurses") public ResponseEntity<?> listarEnfermeras() { return
	 * ResponseEntity.ok(service.findAllNurses()); }
	 * 
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

}
