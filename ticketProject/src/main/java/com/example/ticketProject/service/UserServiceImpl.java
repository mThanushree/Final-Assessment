package com.example.ticketProject.service;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.TypeConstraintException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ticketProject.dto.UserDTO;
import com.example.ticketProject.entity.UserEntity;
import com.example.ticketProject.repository.UserRepo;

@Service
public class UserServiceImpl implements UserService {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	UserRepo repo;
	
	@Override
	public String validateAndSave(UserDTO dto) {
		UserEntity entity = new UserEntity();
		try {
			if(dto!=null) {
				BeanUtils.copyProperties(dto, entity);
				entity = repo.save(entity);
				logger.info("Added User");
				return "Added User";
			} 
		} catch (Exception e) {
			logger.error(e.getMessage(),e.getClass());
		}
		return null;
	}
	
	@Override
	public List<UserDTO> getAllTickets() {
		List<UserDTO>  dtos = new ArrayList<>();
		try {
			List<UserEntity> entityyy = repo.findAll();
			logger.info("find All" + repo.findAll());
			
			for (UserEntity userEntity : entityyy) {
				UserDTO dto = new UserDTO();
				BeanUtils.copyProperties(userEntity, dto);
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
	public String validateAndUpdateAllUsers(UserDTO dto) {
		UserEntity userEntity = new UserEntity();
		userEntity = repo.getByCountry(dto.getCountry());
		logger.info("" + userEntity);
		
		try {
		if(dto != null) {
			if(!dto.getHolderName().equals(null) && !dto.getHolderName().equals("")) {
				userEntity.setHolderName(dto.getHolderName());
			}
					if(!dto.getGender().equals(null) && !dto.getGender().equals("")) {
						userEntity.setGender(dto.getGender());
					}
						if(!dto.getDob().equals(null) && !dto.getHolderName().equals("")) {
							userEntity.setDob(dto.getDob());
						}
							if(!dto.getEmail().equals(null) && !dto.getEmail().equals("")) {
								userEntity.setEmail(dto.getEmail());
							}
								if(!dto.getCurrentAddress().equals(null) && !dto.getCurrentAddress().equals("")) {
									userEntity.setCurrentAddress(dto.getCurrentAddress());
								}
									if(!dto.getPermanentAddress().equals(null) && !dto.getPermanentAddress().equals("")) {
										userEntity.setPermanentAddress(dto.getPermanentAddress());
									}
										if(!dto.getCountry().equals(null) && !dto.getCountry().equals("")) {
											userEntity.setCountry(dto.getCountry());
										}
											if(!dto.getState().equals(null) && !dto.getState().equals("")) {
												userEntity.setState(dto.getState());
											}
												if(!dto.getCity().equals(null) && !dto.getCity().equals("")) {
													userEntity.setCity(dto.getCity());
												}
													if(dto.getPostalCode()!=0) {
														userEntity.setPostalCode(dto.getPostalCode());
													}
														if(dto.getAge()!=0) {
															userEntity.setAge(dto.getAge());
														}
		                                     }
		                                          repo.save(userEntity);
		                                          return "updated";
	                                        	} catch(NullPointerException | TypeConstraintException e) {
													logger.error(e.getMessage(),e.getClass());
												}
		                                       return "hello";
	}

}
