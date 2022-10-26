package com.example.block6personcontrollers;


import ClasesObjeto.Ciudad;
import ClasesObjeto.Persona;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Block6PersonControllersApplication implements CommandLineRunner {

	public static void main(String[] args) {
		Servicio.ciudades.add(new Ciudad("Santiago",97850));
		Servicio.ciudades.add(new Ciudad("Noia",14760));
		Servicio.ciudades.add(new Ciudad("A Coruña",1120134 ));
		Servicio.ciudades.add(new Ciudad("Vigo",297400 ));
		Servicio.ciudades.add(new Ciudad("Pontevedra",82680));
		SpringApplication.run(Block6PersonControllersApplication.class, args);

	}



	@Override
	public void run(String... args) throws Exception {

	}
}
