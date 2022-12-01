package com.example.block13mongodb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Block13MongodbApplication {

	public static void main(String[] args) {
		SpringApplication.run(Block13MongodbApplication.class, args);
	}
	//Open Terminal and run this comands
	//docker pull mongo
	//docker build -t mongoapp
	//docker run -d --name MongoDB --network mynetwork -p 27017:27107 mongo
	//docker run -d --name MongoAPP --network mynetwork -p 8080:8080 -e spring.data.mongodb.host=MongoDB mongoapp
	// Then you can do the requests in localhost:8080


}
