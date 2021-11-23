package com.example.ticketProject.service;

import java.util.List;

import com.example.ticketProject.dto.UserDTO;

public interface UserService {

	String validateAndSave(UserDTO dto);

	List<UserDTO> getAllTickets();

	String validateAndUpdateAllUsers(UserDTO dto);

}
