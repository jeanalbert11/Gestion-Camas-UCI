package edu.ucentral.servicio.nurses.controller;

import java.io.IOException;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import edu.ucentral.commons.service.controller.CommonController;
import edu.ucentral.commons.nurses.model.Nurse;
import edu.ucentral.servicio.nurses.service.NurseService;

@RestController
public class NurseController extends CommonController<Nurse, NurseService> {

	@PutMapping("/{id}")
	public ResponseEntity<?> editar(@Valid @RequestBody Nurse nurse, @PathVariable Long id, BindingResult result) {

		if (result.hasErrors()) {
			return this.validar(result);
		}

		Optional<Nurse> optional = service.findById(id);

		if (!optional.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		Nurse personDB = optional.get();
		personDB.setNombre(nurse.getNombre());
		personDB.setApellido(nurse.getApellido());

		return ResponseEntity.status(HttpStatus.CREATED).body(service.save(personDB));

	}
	
	/*

	@PostMapping("/crear-con-imagen")
	public ResponseEntity<?> crearConImagen(@Valid Nurse nurse, BindingResult result,
			@RequestParam MultipartFile archivo) throws IOException {
		// Validamos que el obj cumpla con las validaciones de las entitys
		if (!archivo.isEmpty()) {
			nurse.setImagen(archivo.getBytes());
		}

		return super.crear(nurse, result);
	}

	@PutMapping("/editar-con-imagen/{id}")
	public ResponseEntity<?> editarConImagen(@Valid Nurse nurse, @PathVariable Long id, BindingResult result,
			@RequestParam MultipartFile archivo) throws IOException {

		if (result.hasErrors()) {
			return this.validar(result);
		}

		Optional<Nurse> optional = service.findById(id);

		if (!optional.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		Nurse personDB = optional.get();
		personDB.setNombre(nurse.getNombre());
		personDB.setApellido(nurse.getApellido());
		personDB.setTarjetaProfesional(nurse.getTarjetaProfesional());

		// Validamos que el archivo no este vacio
		if (!archivo.isEmpty()) {
			nurse.setImagen(archivo.getBytes());
		}

		return ResponseEntity.status(HttpStatus.CREATED).body(service.save(personDB));

	}

	@GetMapping("/upload/img/{id}")
	public ResponseEntity<?> verImagen(@PathVariable Long id) {
		Optional<Nurse> optional = service.findById(id);
		if (!optional.isPresent() || optional.get().getImagen() == null) {
			return ResponseEntity.notFound().build();
		}
		Resource img = new ByteArrayResource(optional.get().getImagen());
		return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG).body(img);

	}
	
	*/
}
