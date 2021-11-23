package com.example.ticketProject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan("com.example.ticketProject")
@SpringBootApplication
public class TicketProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(TicketProjectApplication.class, args);
		System.out.println("=========================tttttt==============================");
	}

}
