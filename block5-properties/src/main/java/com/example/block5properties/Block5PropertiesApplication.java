package com.example.block5properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class Block5PropertiesApplication implements CommandLineRunner {



	public static void main(String[] args) {SpringApplication.run(Block5PropertiesApplication.class, args);

	}
	@Value("${greeting}")
	private String greeting;

	@Value("${my.number}")
	private String number;

	@Value("${new.property:new.property no tiene valor}")
	private String newproperty;


	@Override
	public void run(String... args) throws Exception {
		System.out.println("El valor de greeting es ("+greeting+")");
		System.out.println("El valor de my.number es ("+number+")");
		System.out.println("El valor de new.property es ("+newproperty+")");

	}
}
