package com.music;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class applicationmusic {

	public static void main(String[] args) {
		SpringApplication.run(applicationmusic.class, args);
	}
}
