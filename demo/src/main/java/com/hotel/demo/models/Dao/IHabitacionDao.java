package com.hotel.demo.models.Dao;


import org.springframework.data.jpa.repository.JpaRepository;

import com.hotel.demo.models.entity.Habitacion;

public interface IHabitacionDao extends JpaRepository<Habitacion, Long>{
    
}
