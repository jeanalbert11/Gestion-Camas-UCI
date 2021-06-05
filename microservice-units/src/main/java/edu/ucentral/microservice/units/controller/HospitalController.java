package edu.ucentral.microservice.units.controller;

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
import edu.ucentral.microservice.units.model.Hospital;
import edu.ucentral.microservice.units.service.HospitalService;

@RestController
@RequestMapping("/hospitals")
public class HospitalController extends CommonController<Hospital, HospitalService> {

	@PutMapping("/{id}")
	public ResponseEntity<?> editar(@Valid @RequestBody Hospital hospital, BindingResult result,
			@PathVariable Long id) {

		if (result.hasErrors()) {
			return this.validar(result);
		}

		Optional<Hospital> optional = service.findById(id);

		if (!optional.isPresent()) {
			return ResponseEntity.notFound().build();
		}

		Hospital dbUnidad = optional.get();
		dbUnidad.setId(hospital.getId());
		dbUnidad.setTipo(hospital.getTipo());

		return ResponseEntity.status(HttpStatus.CREATED).body(service.save(dbUnidad));

	}
	/*
	 * @GetMapping("/hospital/{hospitalId}/cama/{camaEstado}") public
	 * ResponseEntity<?> findHospitalByIdByBedEstado(@PathVariable Long hospitalId,
	 * 
	 * @PathVariable boolean camaEstado) { Iterable<Hospital> hospitals =
	 * service.findHospitalByIdByBedEstado(hospitalId, camaEstado); return
	 * ResponseEntity.ok(hospitals);
	 * 
	 * }
	 */

}
