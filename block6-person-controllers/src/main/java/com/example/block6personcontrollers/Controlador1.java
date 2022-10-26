package com.example.block6personcontrollers;

import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/controlador1")
public class Controlador1 {

    @GetMapping("/addPersona")
    public String controlador1Persona(@RequestParam(value="nombre")String nombre,
                               @RequestParam(value="poblacion")String ciudad,
                               @RequestParam(value="edad")int edad){

        return Servicio.controlador1Persona(nombre,ciudad,edad);
    }
    @GetMapping("/addCiudad")
    public String controlador1Ciudad(@RequestParam(value = "nombre")String nombre,
                                     @RequestParam(value="numHabitantes")int numHab){
        return Servicio.controlador1Ciudad(nombre,numHab);
    }


}
