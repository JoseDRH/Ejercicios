package com.example.block6simplecontrollers;


import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserAdd {

    @RequestMapping(
            path = "/useradd", method = RequestMethod.POST)
    public String createPersona(@RequestBody Persona person) {
        System.out.println(person);
        return person.toString();
    }



}
