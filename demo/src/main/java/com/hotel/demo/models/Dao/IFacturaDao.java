package com.hotel.demo.models.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.hotel.demo.models.entity.Factura;

public interface IFacturaDao extends JpaRepository<Factura, Long>{
    
}
