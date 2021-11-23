package com.example.ticketProject.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.ticketProject.dto.UserDTO;
import com.example.ticketProject.service.UserService;

@RestController
public class UserController {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	UserService service;
	
	
	@PostMapping("createUser")
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
	
	@GetMapping("allUserTickets")
    List<UserDTO> allUserTickets() {
		List<UserDTO> dto = null;
	try {
		dto = service.getAllTickets();
	   } catch (Exception e) {
		   logger.error(e.getMessage(),e.getClass());
	   }
	return dto;
}
	
	@PostMapping("updateAllUsers")
	String updateByUser(@RequestBody UserDTO dto) {
		String msg = null;
		try {
			logger.info("" + dto);
			msg = service.validateAndUpdateAllUsers(dto);
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return msg;
	}
}
