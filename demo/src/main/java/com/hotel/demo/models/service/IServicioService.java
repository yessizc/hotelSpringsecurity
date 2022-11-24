package com.hotel.demo.models.service;

import java.util.List;
import java.util.Optional;

import com.hotel.demo.models.entity.Servicio;

public interface IServicioService  {
   
    
        public List<Servicio> findAll();
    
        public void save(Servicio servicio);
    
        public Optional<Servicio> findOne(Long id);
    
        public void delete(Long id);
}
