package com.example.demo.udemy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class DemoUdemyApplication {

	public static void main(String[] args) {
		ApplicationContext a = SpringApplication.run(DemoUdemyApplication.class, args);

		Alien obj= a.getBean(Alien.class);

		obj.show();
	}

}
