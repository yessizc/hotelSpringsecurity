package com.hotel.demo.models.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hotel.demo.models.Dao.IHabitacionDao;
import com.hotel.demo.models.entity.Habitacion;


@Service
public class HabitacionServiceImp implements IHabitacionService{

    @Autowired
    private IHabitacionDao habitacionDao;

    @Transactional(readOnly = true)
    @Override
    public List<Habitacion> findAll() {
        return habitacionDao.findAll();
    }

    @Transactional
    @Override
    public void save(Habitacion habitacion) {
        habitacionDao.save(habitacion);
        
    }

    @Transactional (readOnly = true)
    @Override
    public Optional<Habitacion> findOne(Long id) {
        
        return habitacionDao.findById(id);
    }

    @Override
    public void delete(Long id) {
        habitacionDao.deleteById(id);
        
    }
    
}
