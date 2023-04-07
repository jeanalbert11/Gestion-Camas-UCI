package edu.ucentral.servicio.test.controllers;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import edu.ucentral.servicio.test.model.Person;
import edu.ucentral.servicio.test.services.PersonService;

@RestController
@CrossOrigin({ "http://localhost:4200" })
public class PersonController {

	@Autowired
	private PersonService service;

	@GetMapping
	public ResponseEntity<?> listar() {
		// ok: status 200
		return ResponseEntity.ok().body(service.findAll());
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<?> ver(@PathVariable Long id) {
		// validamos que exista el obj en la db
		Optional<Person> optional = service.findById(id);
		if (optional.isEmpty()) {
			// notFound: status 404
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(optional.get());// enviando Entity como un JSON
	}

	@PostMapping
	public ResponseEntity<?> crear(@Valid @RequestBody Person person, BindingResult result) {
		// Validamos que el obj cumpla con las validaciones de las entitys
		if (result.hasErrors()) {
			return this.validar(result);
		}
		Person patientDB = service.save(person);
		// status: 201
		return ResponseEntity.status(HttpStatus.CREATED).body(patientDB);
	}

	@PutMapping("/{id}")
	public ResponseEntity<?> editar(@Valid @RequestBody Person person, BindingResult result, @PathVariable Long id) {
		if (result.hasErrors()) {
			return this.validar(result);
		}
		Optional<Person> optional = service.findById(id);
		if (!optional.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		Person patientDB = optional.get();
		patientDB.setNombre(person.getNombre());
		patientDB.setApellido(person.getApellido());
		patientDB.setCelular(person.getCelular());

		return ResponseEntity.status(HttpStatus.CREATED).body(service.save(patientDB));

	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> eliminar(@PathVariable Long id) {
		service.deleteById(id);
		// noContent: status 204
		return ResponseEntity.noContent().build();
	}
	
	

	// Recuperamos los errores de las entitys
	protected ResponseEntity<?> validar(BindingResult result) {
		Map<String, Object> errores = new HashMap<>();
		result.getFieldErrors().forEach(err -> {
			errores.put(err.getField(), "The atribute " + err.getField() + " " + err.getDefaultMessage());
		});
		return ResponseEntity.badRequest().body(errores);
	}

}