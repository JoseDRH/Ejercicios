package com.example.block7crud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping()
public class ControllerDelete {

    @Autowired
    ServicePerson servicePerson;

    @RequestMapping(path="/persona/{id}",method= RequestMethod.DELETE)
    public String metodo(@PathVariable int id){
        servicePerson.deletePerson(id);
        return "Persona eliminada "+id ;
    }
}
