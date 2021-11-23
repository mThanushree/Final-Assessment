package com.example.ticketProject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ticketProject.entity.UserEntity;

public interface UserRepo extends JpaRepository<UserEntity, Integer> {

	UserEntity getByCountry(String country);


}
