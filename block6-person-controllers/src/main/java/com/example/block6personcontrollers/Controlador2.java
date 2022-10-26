package com.example.block6personcontrollers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/controlador2")
public class Controlador2 {

        @RequestMapping("/getPersona")
        public String controlador2Persona(){
            return Servicio.controlador2Persona();
        }
    @RequestMapping("/getCiudad")
    public String controlador2Ciudad(){
        return Servicio.controlador2Ciudad();
    }

}
