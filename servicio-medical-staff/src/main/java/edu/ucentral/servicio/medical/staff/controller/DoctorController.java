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
import edu.ucentral.servicio.medical.staff.model.Doctor;
import edu.ucentral.servicio.medical.staff.service.DoctorService;
import edu.ucentral.servicio.medical.staff.service.PersonService;

@RestController
@RequestMapping("/doctors")
public class DoctorController extends CommonController<Doctor, DoctorService> {
	/*
	 * @Autowired private DoctorService nurseService;
	 */
	@Autowired
	private PersonService personService;

	@PutMapping("/{id}")
	public ResponseEntity<?> editar(@Valid @RequestBody Doctor doctor, @PathVariable Long id, BindingResult result) {

		if (result.hasErrors()) {
			return this.validar(result);
		}

		Optional<Doctor> optional = service.findById(id);

		if (!optional.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		Doctor dbDoctor = optional.get();
		dbDoctor.setNombre(doctor.getNombre());
		dbDoctor.setApellido(doctor.getApellido());

		return ResponseEntity.status(HttpStatus.CREATED).body(service.save(dbDoctor));

	}

	@DeleteMapping("/doctor/{id}")
	public ResponseEntity<?> deleteNurse(@PathVariable Long id) {
		personService.deleteById(id);
		return ResponseEntity.noContent().build();
	}

}
