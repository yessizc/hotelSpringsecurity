package com.hotel.demo.models.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hotel.demo.models.Dao.IFacturaDao;
import com.hotel.demo.models.entity.Factura;

@Service
public class FacturaServiceImp implements IFacturaService{

    @Autowired
    private IFacturaDao facturaDao;

    @Transactional(readOnly = true)
    @Override
    public List<Factura> findAll() {
        return facturaDao.findAll();
    }

    @Transactional
    @Override
    public void save(Factura factura) {
        facturaDao.save(factura);
        
    }

    @Transactional (readOnly = true)
    @Override
    public Optional<Factura> findOne(Long id) {
        return facturaDao.findById(id);
    }

    @Override
    public void delete(Long id) {
        facturaDao.deleteById(id);
        
    }
    
}
