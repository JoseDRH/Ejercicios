package com.example.block16springcloud2;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
@EnableEurekaServer
public class Block16SpringCloud2Application {

	public static void main(String[] args) {
		SpringApplication.run(Block16SpringCloud2Application.class, args);
	}



}
