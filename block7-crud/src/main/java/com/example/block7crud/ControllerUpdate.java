package com.example.block7crud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping()
public class ControllerUpdate {

    @Autowired
    ServicePerson servicePerson;

    @RequestMapping(path="/persona/{id}", method = RequestMethod.POST)
    public String metodo( @RequestBody Person input,@PathVariable(name="id")int id){
        servicePerson.updatePerson(input,id);
        return "Persona actualizada "+id;
    }
}
