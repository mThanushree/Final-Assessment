package com.example.ticketProject.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString

public class TicketDTO {

	private int ticketId;
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
