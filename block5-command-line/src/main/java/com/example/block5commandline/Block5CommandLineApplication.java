package com.example.block5commandline;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


import javax.annotation.PostConstruct;

@SpringBootApplication
public class Block5CommandLineApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(Block5CommandLineApplication.class, args);
	}
	@PostConstruct
	public void hola(){
		System.out.println("Hola desde clase inicial");
	}
	@Bean
	CommandLineRunner hola2(){
		return p-> System.out.println("Hola desde clase secundaria");
	}
	@Bean
	CommandLineRunner hola3(String[] args){
		return p->{
			for (String a:
				 args) {
				System.out.println(a);
			}
		};
	}

	@Override
	public void run(String... args) throws Exception {

			hola3(args);
	}
}
