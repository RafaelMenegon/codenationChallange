package com.desafio.codenation.codenation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class CodenationApplication {

	public static void main(String[] args) {
		SpringApplication.run(CodenationApplication.class, args);
	}

}
