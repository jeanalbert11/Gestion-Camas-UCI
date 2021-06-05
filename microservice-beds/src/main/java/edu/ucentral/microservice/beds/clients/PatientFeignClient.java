package edu.ucentral.microservice.beds.clients;

import java.util.List;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import edu.ucentral.commons.patients.model.Patient;

@FeignClient(name = "microservice-patients") // nombre con el microservicio que se va a comunicar
public interface PatientFeignClient {

	// EndPoint con el que se va a comunicar
	@GetMapping("/patients")
	public List<Patient> findAllPatients();
}
