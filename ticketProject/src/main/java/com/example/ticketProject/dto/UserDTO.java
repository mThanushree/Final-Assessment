package com.example.ticketProject.dto;

import java.util.List;

import com.example.ticketProject.entity.TicketEntity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString

public class UserDTO {

	private String holderName;
	private int age;
	private String dob;
	private String gender;
	private String email;
	private String currentAddress;
	private String permanentAddress;
	private String country;
	private String state;
	private String city;
	private long postalCode;
	private List<TicketEntity> ticket;
	
}
