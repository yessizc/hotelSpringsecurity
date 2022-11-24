package com.hotel.demo.controller;

import com.hotel.demo.models.entity.Servicio;

import java.util.Map;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hotel.demo.models.service.IServicioService;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

@Controller
@RequestMapping("/Servicio")
public class ServicioControllers {

    @Autowired
    private IServicioService servicioService;

    @GetMapping("/listarserv")
    public String listar(Model model){
        model.addAttribute("titulo", "listado de servicios");
        model.addAttribute("servicios", servicioService.findAll());
        return "listarserv";
    }

    @GetMapping("/formularioserv")
    public String crear (Map<String,Object>model){
        Servicio servicio =new Servicio();
        model.put("Servicio",servicio);
        model.put("titulo","formulario servicios");
        return "formularioserv";
    }

    @PostMapping ("/formularioserv")//peticion para guarda los datos en db
    public String guardar (@Valid Servicio servicio, BindingResult result, Model model){
        if (result.hasErrors()){
            model.addAttribute("titulo", "formulario de servicios");
            return "formularioserv";
        }
        servicioService.save(servicio);
        return "redirect:/Servicio/listarserv";
    }

    @GetMapping("/formularioserv/{id}")
    public String editar(@PathVariable Long id,Map<String,Object>model){
        Optional<Servicio> servicio =null;
        if (id >0){
            servicio = servicioService.findOne(id);
        }
        else{
            return "redirect:servicio/listarserv";
        }
        model.put("Servicio",servicio);
        model.put("titulo","editar servicio");
        return "formularioserv";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar (@PathVariable Long id){
        if(id >0)
        servicioService.delete(id);
        return "redirect:/Servicio/listarserv";
    }


    
}
