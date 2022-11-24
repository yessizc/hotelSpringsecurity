package com.hotel.demo.models.service;


import java.util.List;
import java.util.Optional;

import com.hotel.demo.models.entity.Factura;

public interface IFacturaService {
    
    public List<Factura> findAll();
    public void save (Factura factura);
    public Optional<Factura> findOne(Long id);
    public void delete (Long id);
}
