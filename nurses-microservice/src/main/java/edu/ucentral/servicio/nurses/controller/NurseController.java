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
	public ResponseEntity<?> editar(@Valid @RequestBody Nurse nurse, BindingResult result, @PathVariable Long id) {

		if (result.hasErrors()) {
			return this.validar(result);
		}
		Optional<Nurse> optional = service.findById(id);
		if (!optional.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		Nurse nurseDB = optional.get();
		nurseDB.setIdentityCard(nurse.getIdentityCard());
		nurseDB.setProfessionalCard(nurse.getProfessionalCard());
		nurseDB.setName(nurse.getName());
		nurseDB.setSurname(nurse.getSurname());
		nurseDB.setEmail(nurse.getEmail());
		return ResponseEntity.status(HttpStatus.CREATED).body(service.save(nurseDB));
	}

	@PostMapping("/crear-con-foto")
	public ResponseEntity<?> crearConImagen(@Valid Nurse nurse, BindingResult result,
			@RequestParam MultipartFile archivo) throws IOException {
		// Validamos que el obj cumpla con las validaciones de las entitys
		if (!archivo.isEmpty()) {
			nurse.setFoto(archivo.getBytes());
		}
		return super.crear(nurse, result);
	}

	@PutMapping("/editar-con-foto/{id}")
	public ResponseEntity<?> editarConImagen(@Valid Nurse nurse, BindingResult result, @PathVariable Long id,
			@RequestParam MultipartFile archivo) throws IOException {
		if (result.hasErrors()) {
			return this.validar(result);
		}
		Optional<Nurse> optional = service.findById(id);
		if (!optional.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		Nurse nurseDB = optional.get();
		nurseDB.setId(nurse.getId());
		nurseDB.setIdentityCard(nurse.getIdentityCard());
		nurseDB.setProfessionalCard(nurse.getProfessionalCard());
		nurseDB.setName(nurse.getName());
		nurseDB.setSurname(nurse.getSurname());
		nurseDB.setEmail(nurse.getEmail());

		// Validamos que el archivo no este vacio
		if (!archivo.isEmpty()) {
			nurseDB.setFoto(archivo.getBytes());
		}
		return ResponseEntity.status(HttpStatus.CREATED).body(service.save(nurseDB));
	}

	@GetMapping("/upload/img/{id}")
	public ResponseEntity<?> verImagen(@PathVariable Long id) {
		Optional<Nurse> optional = service.findById(id);
		if (!optional.isPresent() || optional.get().getFoto() == null) {
			return ResponseEntity.notFound().build();
		}
		Resource img = new ByteArrayResource(optional.get().getFoto());
//		return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG).body(img);
		return ResponseEntity.ok().contentType(MediaType.parseMediaType("audio/mp3")).body(img);

	}

	@GetMapping("/nurses")
	public ResponseEntity<?> listarEnfermeras() {
		return ResponseEntity.ok().body(service.findAll());
	}

}
