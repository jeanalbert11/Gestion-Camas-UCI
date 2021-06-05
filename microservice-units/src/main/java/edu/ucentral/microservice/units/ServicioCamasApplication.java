package edu.ucentral.microservice.units;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@EnableEurekaClient
//Paquetes donde estaran mis entitys o modelos
@EntityScan({ "edu.ucentral.commons.patients.model", "edu.ucentral.commons.nurses.model", "edu.ucentral.commons.beds.model",
"edu.ucentral.microservice.units.model" })
@SpringBootApplication
public class ServicioCamasApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServicioCamasApplication.class, args);
	}

}
