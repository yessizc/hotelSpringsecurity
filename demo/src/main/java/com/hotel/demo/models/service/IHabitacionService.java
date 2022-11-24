package com.hotel.demo.models.service;

import java.util.List;
import java.util.Optional;

import com.hotel.demo.models.entity.Habitacion;

public interface IHabitacionService {

    public List<Habitacion> findAll();
    public void save (Habitacion habitacion);
    public Optional<Habitacion> findOne(Long id);
    public void delete (Long id);
    
}
