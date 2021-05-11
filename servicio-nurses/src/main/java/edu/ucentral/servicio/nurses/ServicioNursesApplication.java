package edu.ucentral.servicio.nurses;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
@EntityScan({"edu.ucentral.commons.nurses.model"})
@EnableEurekaClient
@SpringBootApplication
public class ServicioNursesApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServicioNursesApplication.class, args);
	}

}
