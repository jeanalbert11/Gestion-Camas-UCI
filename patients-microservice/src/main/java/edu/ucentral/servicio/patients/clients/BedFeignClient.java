package edu.ucentral.servicio.patients.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "beds-microservice") // nombre con el microservicio que se va a comunicar
public interface BedFeignClient {

	@GetMapping("delete-patient-distributed/{id}")
	public void deletePatientDistributed(Long id);

	// EndPoint con el que se va a comunicar
	// @GetMapping("/patient/{patientId}/camas-asignadas")
	// public Iterable<Long> obtenerCamasAsignadasAPaciente(@PathVariable Long
	// patientId);

}
