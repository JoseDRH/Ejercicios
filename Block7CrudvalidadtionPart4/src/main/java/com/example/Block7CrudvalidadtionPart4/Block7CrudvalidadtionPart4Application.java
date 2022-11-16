package com.example.Block7CrudvalidadtionPart4;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableFeignClients
public class Block7CrudvalidadtionPart4Application {

	public static void main(String[] args) {
		SpringApplication.run(Block7CrudvalidadtionPart4Application.class, args);
	}

	@Bean
	public RestTemplate restTemplate(){
		return new RestTemplate();
	}

}
