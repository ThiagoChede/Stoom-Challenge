package com.stoom.challenge;

import com.stoom.challenge.controller.EnderecoController;
import com.stoom.challenge.service.EnderecoService;
import com.stoom.challenge.util.GeocodingService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackageClasses={EnderecoController.class, EnderecoService.class, GeocodingService.class})
public class ChallengeApplication {

	public static void main(String[] args) {
		SpringApplication.run(ChallengeApplication.class, args);
	}

}
