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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import edu.ucentral.commons.service.controller.CommonController;
import edu.ucentral.servicio.beds.model.Bed;
import edu.ucentral.servicio.beds.model.Unit;
import edu.ucentral.servicio.beds.service.UnidadService;

@RestController
@RequestMapping("/units")
public class UnidadController extends CommonController<Unit, UnidadService> {

	@PutMapping("/{id}")
	public ResponseEntity<?> editar(@Valid @RequestBody Unit unit, @PathVariable Long id, BindingResult result) {

		if (result.hasErrors()) {
			return this.validar(result);
		}

		Optional<Unit> optional = service.findById(id);

		if (!optional.isPresent()) {
			return ResponseEntity.notFound().build();
		}

		Unit dbUnidad = optional.get();
		dbUnidad.setId(unit.getId());
		dbUnidad.setTipo(unit.getTipo());

		return ResponseEntity.status(HttpStatus.CREATED).body(service.save(dbUnidad));

	}

	// Metodo que retorna el grupo del camas
	@PutMapping("/{id}/adicionar-camas")
	public ResponseEntity<?> adicionarCamas(@RequestBody List<Bed> beds, @PathVariable Long id) {
		Optional<Unit> optional = service.findById(id);
		if (!optional.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		Unit dbUnidad = optional.get();
		beds.forEach(bed -> {
			dbUnidad.addBed(bed);
		});
		return ResponseEntity.status(HttpStatus.CREATED).body(service.save(dbUnidad));
	}

	@PutMapping("/{id}/eliminar-camas")
	public ResponseEntity<?> eliminarCamas(@RequestBody Bed bed, @PathVariable Long id) {

		Optional<Unit> optional = service.findById(id);

		if (!optional.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		Unit dbUnidad = optional.get();
		dbUnidad.removeBed(bed);

		return ResponseEntity.status(HttpStatus.CREATED).body(service.save(dbUnidad));
	}
}
