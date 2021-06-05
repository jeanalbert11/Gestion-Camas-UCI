package edu.ucentral.servicio.beds.clients;

import java.util.List;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import edu.ucentral.commons.nurses.model.Nurse;

@FeignClient(name = "servicio-nurses") // nombre con el microservicio que se va a comunicar
public interface NurseFeignClient {

	// EndPoint con el que se va a comunicar
	@GetMapping("/enfermeras")
	public List<Nurse> findAllNurses();

}
