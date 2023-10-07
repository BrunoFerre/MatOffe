package com.mattoffe.Eccomerce;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class EccomerceMatOffeApplication {

	public static void main(String[] args) {
		SpringApplication.run(EccomerceMatOffeApplication.class, args);
	}
	@Bean
	public CommandLineRunner run() {
		return (args) -> {
		};
	}

}
