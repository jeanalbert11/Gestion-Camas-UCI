package edu.ucentral.servicio.patients;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

@EnableFeignClients
@EntityScan({"edu.ucentral.commons.patients.model"})
@EnableEurekaClient
@SpringBootApplication
public class ServicioPatientsApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServicioPatientsApplication.class, args);
    }

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
}
