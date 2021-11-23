package com.example.ticketProject.service;

import java.util.List;

import com.example.ticketProject.dto.TicketDTO;
import com.example.ticketProject.dto.UserDTO;

public interface TicketService {

	String validateAndSave(UserDTO dto);

	List<TicketDTO> getAllTicket();

	String validateAndUpdateAllTickets(TicketDTO dto);


}
