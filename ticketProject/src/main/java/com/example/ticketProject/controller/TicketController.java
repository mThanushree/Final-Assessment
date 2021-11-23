package com.example.ticketProject.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.ticketProject.dto.TicketDTO;
import com.example.ticketProject.dto.UserDTO;
import com.example.ticketProject.service.TicketService;

public class TicketController {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	TicketService service;
	
	
	@PostMapping("createTicket")
	String save(@RequestBody UserDTO dto) {
	String msg = null;
	try {
		logger.info(""+dto);
		msg = service.validateAndSave(dto);
	   } catch (Exception e) {
		   logger.error(e.getMessage(),e.getClass());
	   }
	return msg;
}
	
	@GetMapping("allTickets")
    List<TicketDTO> allTickets() {
		List<TicketDTO> dto = null;
	try {
		dto = service.getAllTicket();
	   } catch (Exception e) {
		   logger.error(e.getMessage(),e.getClass());
	   }
	return dto;
}
	
	@PostMapping("updateAllUsers")
	String updateTicket(@RequestBody TicketDTO dto) {
		String msg = null;
		try {
			logger.info("" + dto);
			msg = service.validateAndUpdateAllTickets(dto);
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return msg;
	}
}
