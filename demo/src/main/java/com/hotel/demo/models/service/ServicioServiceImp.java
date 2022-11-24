package com.hotel.demo.models.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hotel.demo.models.Dao.IServicioDao;
import com.hotel.demo.models.entity.Servicio;


@Service
public class ServicioServiceImp  implements IServicioService{

    @Autowired
    private IServicioDao servicioDao;

    @Transactional (readOnly = true)
    @Override
    public List<Servicio> findAll() {
        return servicioDao.findAll();
    }

    @Transactional
    @Override
    public void save(Servicio servicio) {
        servicioDao.save(servicio);
        
    }

    @Transactional (readOnly = true)
    @Override
    public Optional<Servicio> findOne(Long id) {
        
        return servicioDao.findById(id);
    }

    @Override
    public void delete(Long id) {
        servicioDao.deleteById(id);
        
    }

    
}
