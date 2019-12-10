package com.music;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.embedded.tomcat.TomcatConnectorCustomizer;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.servlet.server.ConfigurableServletWebServerFactory;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
@SpringBootApplication
@EnableFeignClients
@EnableCircuitBreaker
@EnableScheduling
@EnableAutoConfiguration
public class aoolicationcomsumer {
     public static void main(String[] args) {
		SpringApplication.run(aoolicationcomsumer.class, args);
	}
     
     @Bean
     public ConfigurableServletWebServerFactory webServerFactory() {
         TomcatServletWebServerFactory factory = new TomcatServletWebServerFactory();
         factory.addConnectorCustomizers((TomcatConnectorCustomizer) connector -> connector.setProperty("relaxedQueryChars", "|{}[]\\"));
         return factory;
     }
}
