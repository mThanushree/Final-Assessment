package com.example.ticketProject.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Entity
@Table

public class UserEntity {

	@Id
	@GenericGenerator(name="id", strategy="increment")
	@GeneratedValue(generator="id")
	private int userId;
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
	
	@OneToMany(targetEntity = TicketEntity.class, cascade = CascadeType.ALL)
	
	@JoinColumn(name = "user_id", referencedColumnName = "userId")
	private List<TicketEntity> ticket;
	
}
