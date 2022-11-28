package com.example.block12kafka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Block12KafkaApplication {

	public static void main(String[] args) {
		SpringApplication.run(Block12KafkaApplication.class, args);
	}

	//Para que el proyecyo funcione debe ejecutar el siguiente comando en el cmd
	//docker run --name KafkaBroker -p 2181:2181 -p 3030:3030 -p 8081-8083:8081-8083 -p 9581-9585:9581-9585 -p 9092:9092 -e ADV_HOST=localhost landoop/fast-data-dev:latest


}
