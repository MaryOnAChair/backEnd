package com.java.backEnd;

import com.java.backEnd.dao.CustomerRepository;
import com.java.backEnd.entities.Customer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

@SpringBootApplication
public class BackEndApplication {

	public static void main(String[] args) {
		System.out.println("Hello World");
		SpringApplication.run(BackEndApplication.class, args);

	}

}
