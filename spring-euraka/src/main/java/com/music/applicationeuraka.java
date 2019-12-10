package com.music;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class applicationeuraka {
   
	public static void main(String[] args) {
		SpringApplication.run(applicationeuraka.class, args);
	}

}
