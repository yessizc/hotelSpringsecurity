package com.hotel.demo.models.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.hotel.demo.models.entity.Servicio;

public interface IServicioDao extends JpaRepository<Servicio, Long>{
    
}
