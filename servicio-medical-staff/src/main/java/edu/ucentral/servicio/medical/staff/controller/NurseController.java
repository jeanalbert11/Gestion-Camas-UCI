package edu.ucentral.servicio.medical.staff.controller;

import java.util.Optional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import edu.ucentral.commons.service.controller.CommonController;
import edu.ucentral.servicio.medical.staff.model.Nurse;
import edu.ucentral.servicio.medical.staff.service.NurseService;
import edu.ucentral.servicio.medical.staff.service.PersonService;

@RestController
@RequestMapping("/nurses")
public class NurseController extends CommonController<Nurse, NurseService> {
	/*
	 * @Autowired private NurseService nurseService;
	 */
	@Autowired
	private PersonService personService;

	@PutMapping("/{id}")
	public ResponseEntity<?> editar(@Valid @RequestBody Nurse nurse, @PathVariable Long id, BindingResult result) {

		if (result.hasErrors()) {
			return this.validar(result);
		}

		Optional<Nurse> optional = service.findById(id);

		if (!optional.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		Nurse nurseDB = optional.get();
		nurseDB.setNombre(nurse.getNombre());
		nurseDB.setApellido(nurse.getApellido());

		return ResponseEntity.status(HttpStatus.CREATED).body(service.save(nurseDB));

	}

	@DeleteMapping("/nurse/{id}")
	public ResponseEntity<?> deleteNurse(@PathVariable Long id) {
		personService.deleteById(id);
		return ResponseEntity.noContent().build();
	}

}
