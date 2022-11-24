package com.hotel.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hotel.demo.models.entity.Reserva;
import com.hotel.demo.models.service.IReservaService;

import java.util.Map;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;



@Controller // puente entre el cliente y el servidor solo recive datos, no lleva logica.
@RequestMapping("/Reserva") // esta es la url
public class ReservaController {

    @Autowired // es una inyeccion de dependecioas de servicios
    private IReservaService reservaService;

    @GetMapping ("/listar") //captura los datos
    public String listar(Model model){
        model.addAttribute("titulo", "listado de reservas");
        model.addAttribute("reservas", reservaService.findAll());
        
        return "listar";
    }

    @GetMapping("/formulario")
    public String crear (Map<String,Object>model){
        Reserva reserva =new Reserva();
        model.put("reserva",reserva);
        model.put("titulo","formulario reserva");
        return "formulario";
    }
    
    @PostMapping ("/formulario")//peticion para guarda los datos en db
    public String guardar (@Valid Reserva reserva, BindingResult result, Model model){
        
        if (result.hasErrors()){
            model.addAttribute("titulo", "formulario de reservas");
            return "formulario";
        }
        reservaService.save(reserva);
        return "redirect:/Reserva/listar";
    }

    @GetMapping("/formulario/{id}")
    public String editar(@PathVariable Long id,Map<String,Object>model){
        Optional<Reserva> reserva =null;
        if (id >0){
            reserva = reservaService.findOne(id);
        }
        else{
            return "redirect:Reserva/listar";
        }
        model.put("reserva",reserva);
        model.put("titulo","editar reserva");
        return "formulario";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar (@PathVariable Long id){
        if(id >0)
        reservaService.delete(id);
        return "redirect:/Reserva/listar";
    }








}
