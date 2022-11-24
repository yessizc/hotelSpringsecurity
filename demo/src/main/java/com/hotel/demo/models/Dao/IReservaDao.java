package com.hotel.demo.models.Dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hotel.demo.models.entity.Reserva;


public interface IReservaDao extends JpaRepository<Reserva, Integer>{
	

}
