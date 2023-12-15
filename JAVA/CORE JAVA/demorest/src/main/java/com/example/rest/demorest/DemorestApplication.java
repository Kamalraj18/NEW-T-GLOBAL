package com.example.rest.demorest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy
public class DemorestApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemorestApplication.class, args);
	}

}
