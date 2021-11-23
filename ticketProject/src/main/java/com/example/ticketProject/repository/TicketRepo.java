package com.example.ticketProject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ticketProject.entity.TicketEntity;

public interface TicketRepo extends JpaRepository<TicketEntity, Integer>  {

	TicketEntity getByExpire(String expire);


}
