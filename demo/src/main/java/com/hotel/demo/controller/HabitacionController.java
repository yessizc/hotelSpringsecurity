package com.hotel.demo.controller;

import com.hotel.demo.models.entity.Habitacion;
import com.hotel.demo.models.service.HabitacionServiceImp;
import com.hotel.demo.models.service.IHabitacionService;

import java.util.Map;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;



@Controller
@RequestMapping("/Habitacion")
public class HabitacionController {

    @Autowired
    private IHabitacionService habitacionService;

    @GetMapping("/listarhab")
    public String listar(Model model){
        model.addAttribute("titulo", "listado de habitaciones");
        model.addAttribute("habitaciones", habitacionService.findAll());
        return "listarhab";
    }
   
    @GetMapping("/formulariohab")
    public String crear (Map<String,Object>model){
        Habitacion habitacion =new Habitacion();
        model.put("Habitacion",habitacion);
        model.put("titulo","formulario Habitacion");
        return "formulariohab";
    }

    @PostMapping ("/formulariohab")//peticion para guarda los datos en db
    public String guardar (@Valid Habitacion habitacion, BindingResult result, Model model){
        if (result.hasErrors()){
            model.addAttribute("titulo", "formulario de habitaciones");
            return "formulariohab";
        }
        habitacionService.save(habitacion);
        return "redirect:/Habitacion/listarhab";
    }
    @GetMapping("/formulariohab/{id}")
    public String editar(@PathVariable Long id,Map<String,Object>model){
        Optional<Habitacion> habitacion =null;
        if (id >0){
            habitacion = habitacionService.findOne(id);
        }
        else{
            return "redirect:usuario/listar";
        }
        model.put("habitacion",habitacion);
        model.put("titulo","editar habitacion");
        return "formulariohab";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar (@PathVariable Long id){
        if(id >0)
        habitacionService.delete(id);
        return "redirect:/Habitacion/listarhab";
    }
}

