package com.hotel.demo.models.service;

import java.util.List;
import java.util.Optional;

import com.hotel.demo.models.entity.Usuario;

public interface IUsuarioService {

    public List<Usuario> findAll();
    public void save (Usuario usuario);
    public Optional<Usuario> findOne(Long id);
    public void delete (Long id);
    
}
