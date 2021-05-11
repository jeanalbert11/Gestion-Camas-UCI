package edu.ucentral.servicio.beds.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.ucentral.commons.service.controller.CommonController;
import edu.ucentral.servicio.beds.model.Bed;
import edu.ucentral.servicio.beds.service.BedService;
import edu.ucentral.servicio.nurses.model.Nurse;

@RestController

public class BedController /* extends CommonController<Bed, BedService> */{
	
	@Autowired
	private BedService bedService;
	
	@GetMapping
	public ResponseEntity<?> listar() {
		return ResponseEntity.ok().body(bedService.findAll());
	}

	
	/*

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

		return ResponseEntity.status(HttpStatus.CREATED).body(service.save(dbBed));

	}
	
	@GetMapping("/nurses")
	public ResponseEntity<?> listarEnfermeras() {
		return ResponseEntity.ok(service.findAllNurses());
	}
	
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
