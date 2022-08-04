package com.egarcia.proyectobackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class ProyectoBackendMsApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProyectoBackendMsApplication.class, args);
	}

}
