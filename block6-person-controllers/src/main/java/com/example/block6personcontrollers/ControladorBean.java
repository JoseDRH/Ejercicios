package com.example.block6personcontrollers;


import ClasesObjeto.Persona;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/controlador/bean")
public class ControladorBean {






    @GetMapping("/{bean}")
    public String bean(@PathVariable String bean){
        String resultado="No se encontro nada";
        for (Persona p: Servicio.personas) {
            if (p.getNombre().equals(bean)){
                resultado=p.toString();
                break;
            }
        }

        return resultado;
    }


}
