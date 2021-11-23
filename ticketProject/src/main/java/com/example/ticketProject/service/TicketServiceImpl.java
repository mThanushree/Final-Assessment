package com.example.ticketProject.service;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.TypeConstraintException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ticketProject.dto.TicketDTO;
import com.example.ticketProject.dto.UserDTO;
import com.example.ticketProject.entity.TicketEntity;
import com.example.ticketProject.repository.TicketRepo;

@Service
public class TicketServiceImpl implements TicketService {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	TicketRepo repo;
	
	@Override
	public String validateAndSave(UserDTO dto) {
		TicketEntity entity = new TicketEntity();
		try {
			if(dto!=null) {
				logger.info("" + dto);
				BeanUtils.copyProperties(dto, entity);
				entity = repo.save(entity);
				logger.info("Added Tickets");
				return "Added Tickets";
			} 
		} catch (Exception e) {
			logger.error(e.getMessage(),e.getClass());
		}
		return null;
	}
	@Override
	public List<TicketDTO> getAllTicket() {
		List<TicketDTO>  dtos = new ArrayList<>();
		try {
			List<TicketEntity> entityyy = repo.findAll();
			logger.info("find All" + repo.findAll());
			
			for (TicketEntity ticketEntity : entityyy) {
				TicketDTO dto = new TicketDTO();
				BeanUtils.copyProperties(ticketEntity, dto);
				logger.info(""+ dtos);
				dtos.add(dto);
				logger.info("Mapping" + dtos);
				
			}
	} catch ( Exception e) {
		logger.error(e.getMessage(),e.getClass());
	}
		return dtos;
	}
	@Override
	public String validateAndUpdateAllTickets(TicketDTO dto) {
		TicketEntity ticketEntity = new TicketEntity();
		ticketEntity = repo.getByExpire(dto.getExpire());
		logger.info("" + ticketEntity);
		
		try {
		if(dto != null) {
			if(dto.getTicketName()!=(null) && !dto.getTicketName().equals("")) {
				ticketEntity.setTicketName(dto.getTicketName());
			}
					if((dto.getTicketRaisedBy()!=(null)) && !dto.getTicketRaisedBy().equals("")) {
						ticketEntity.setTicketRaisedBy(dto.getTicketRaisedBy());
					}
						if((dto.getContactNumber() != 0)) {
							ticketEntity.setContactNumber(dto.getContactNumber());
						}
							if((dto.getEmail() != (null)) && !dto.getEmail().equals("")) {
								ticketEntity.setEmail(dto.getEmail());
							}
								if((dto.getDescription() != (null)) && !dto.getDescription().equals("")) {
									ticketEntity.setDescription(dto.getDescription());
								}
									if((dto.getType() != (null)) && !dto.getType().equals("")) {
										ticketEntity.setType(dto.getType());
									}
										if((dto.getPrice() != 0)) {
											ticketEntity.setPrice(dto.getPrice());
										}
											if((dto.getTicketOwner() != (null)) && !dto.getTicketOwner().equals("")) {
											    ticketEntity.setTicketOwner(dto.getTicketOwner());
											}
												if((dto.getStarted() != (null)) && !dto.getStarted().equals("")) {
													ticketEntity.setStarted(dto.getStarted());
												}
													if(dto.getExpire() != (null) && !dto.getExpire().equals("")) {
														ticketEntity.setExpire(dto.getExpire());
													}
													if(dto.isStatus() != true) {
														ticketEntity.setStatus(dto.isStatus());
													}
		                                     }
		                                          repo.save(ticketEntity);
		                                          return "Successfully Updated Ticket";
		                                          
	                                        	} catch(NullPointerException | TypeConstraintException e) {
													logger.error(e.getMessage(),e.getClass());
												}
		                                       return "hello";
	}
}
