package com.actividaddia9.actividad;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class ActividadApplication {

	public static void main(String[] args) {
		SpringApplication.run(ActividadApplication.class, args);
	}

}
