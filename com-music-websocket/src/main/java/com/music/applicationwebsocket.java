package com.music;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.socket.config.annotation.EnableWebSocket;

@EnableScheduling
@EnableWebSocket
@EnableEurekaClient
@SpringBootApplication
public class applicationwebsocket {
	public static void main(String[] args) {
		SpringApplication.run(applicationwebsocket.class, args);
	}
}
