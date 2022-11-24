package com.hotel.demo.models.Dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hotel.demo.models.entity.Usuario;

@Repository
public interface IUsuarioDao extends JpaRepository<Usuario, Long>{
    
    Usuario findOneByUserName(String nombre);
    
}
