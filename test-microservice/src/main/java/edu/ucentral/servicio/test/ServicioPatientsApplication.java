package edu.ucentral.servicio.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
//@EntityScan({"edu.ucentral.servicio.test.model" ,"edu.ucentral.servicio.beds.model"})
@EntityScan({"edu.ucentral.servicio.test.model"})
@EnableEurekaClient
@SpringBootApplication
public class ServicioPatientsApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServicioPatientsApplication.class, args);
	}

}
