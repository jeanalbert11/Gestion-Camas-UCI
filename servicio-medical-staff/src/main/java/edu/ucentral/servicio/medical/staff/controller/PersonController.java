package edu.ucentral.servicio.medical.staff.controller;

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
import edu.ucentral.servicio.medical.staff.model.Person;
import edu.ucentral.servicio.medical.staff.service.PersonService;

@RestController
@RequestMapping("/personas")
public class PersonController extends CommonController<Person, PersonService> {

	@PutMapping("/{id}")
	public ResponseEntity<?> editar(@Valid @RequestBody Person person, @PathVariable Long id, BindingResult result) {

		if (result.hasErrors()) {
			return this.validar(result);
		}

		Optional<Person> optional = service.findById(id);

		if (!optional.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		Person personDB = optional.get();
		personDB.setNombre(person.getNombre());
		personDB.setApellido(person.getApellido());

		return ResponseEntity.status(HttpStatus.CREATED).body(service.save(personDB));

	}

}
