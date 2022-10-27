package com.example.block7crud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping()
public class ControllerConsult {

    @Autowired
    ServicePerson servicePerson;

    @RequestMapping(path="/persona/{id}",method= RequestMethod.GET)
    public Person metodo(@PathVariable int id){

        return servicePerson.getPersonById(id);
    }
    @RequestMapping(path="/persona/nombre/{nombre}",method= RequestMethod.GET)
    public String metodo2(@PathVariable String nombre){
        List<Person> list=servicePerson.getAllPeople();
        for (Person p :
                list) {
            if (p.getNombre().equals(nombre)) {
                return p.toString();
            }
        }
        return "No se ha encontrado el usuario por nombre";
    }
}
