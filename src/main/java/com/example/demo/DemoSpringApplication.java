package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

//for initializing resources or spring container
@ComponentScan("com.example")
//This is used to Enable autoconfiguration, register extra beans and used to exclude any autoconfiguration beans
@SpringBootApplication(exclude = {org.springframework.boot.autoconfigure.gson.GsonAutoConfiguration.class})

public class DemoSpringApplication {
	
	public static void main(String[] args) {
		//it will execute the server tomcat server
		//it will read the annotation of demoSpringApplication class
		SpringApplication.run(DemoSpringApplication.class, args);
		
	}
}
