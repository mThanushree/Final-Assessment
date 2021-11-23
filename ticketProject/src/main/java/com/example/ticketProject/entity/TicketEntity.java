package com.example.ticketProject.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
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
@Table
@Entity

public class TicketEntity {
	
	@Id
	@GenericGenerator(name="id", strategy="increment")
	@GeneratedValue(generator="id")
	private int t_Id;
	private String ticketName;
	private String ticketRaisedBy;
	private long contactNumber;
	private String email;
	private boolean status;
	private String description;
	private String type;
	private float price;
	private String ticketOwner;
	private String started;
    private String expire;

}
