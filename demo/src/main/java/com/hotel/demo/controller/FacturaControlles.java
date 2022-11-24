package com.hotel.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;

import com.hotel.demo.models.entity.Factura;

import com.hotel.demo.models.service.IFacturaService;



@Controller
@RequestMapping("/Factura")
public class FacturaControlles {

    @Autowired // es una inyeccion de dependecioas de servicios
    private IFacturaService facturaService;

    @GetMapping ("/listarfac") //captura los datos
    public String listar(Model model){
        model.addAttribute("titulo", "listado de facturas");
        model.addAttribute("facturas", facturaService.findAll());
        
        return "listar";
    }
    @GetMapping("/formulariofac")
    public String crear (Map<String,Object>model){
        Factura factura =new Factura();
        model.put("factura",factura);
        model.put("titulo","formulario factura");
        return "formulariofac";
    }

    @PostMapping ("/formulariofac")//peticion para guarda los datos en db
    public String guardar (@Valid Factura factura, BindingResult result, Model model){
        if (result.hasErrors()){
            model.addAttribute("titulo", "formulario de facturas");
            return "formulariohab";
        }
        facturaService.save(factura);
        return "redirect:/Factura/listarfac";
    }

    @GetMapping("/formulariofac/{id}")
    public String editar(@PathVariable Long id,Map<String,Object>model){
        Optional<Factura> factura =null;
        if (id >0){
            factura = facturaService.findOne(id);
        }
        else{
            return "redirect:Factura/listarfac";
        }
        model.put("factura",factura);
        model.put("titulo","editar factura");
        return "formulariofac";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar (@PathVariable Long id){
        if(id >0)
        facturaService.delete(id);
        return "redirect:/Factura/listarfac";
    }

    
}
