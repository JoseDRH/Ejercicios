package com.example.block7crud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping()
public class ControllerAdd {
    @Autowired
    ServicePerson servicePerson;


    @RequestMapping(path="/persona",method= RequestMethod.POST)
    public String metodo(@RequestBody Person input){

        servicePerson.savePerson(input);
        return "Persona añadida\n"+input;
    }
}
