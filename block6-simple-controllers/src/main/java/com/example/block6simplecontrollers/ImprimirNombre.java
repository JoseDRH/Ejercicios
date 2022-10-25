package com.example.block6simplecontrollers;


import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class ImprimirNombre {


    @RequestMapping("/user/{nombre}")
        public String nombre( @PathVariable String nombre){
        return "Hola "+nombre;
    }
}
