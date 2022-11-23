package com.example.block10docker.controller;

import com.example.block10docker.dto.PersonDTO;
import com.example.block10docker.entity.Person;
import com.example.block10docker.service.ServicePerson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ControllerPG {

    @Autowired
    ServicePerson servicePerson;

    @GetMapping("/all")
    public List<PersonDTO> seeAll(){
        return  servicePerson.getAll();
    }

    @GetMapping("/id/{id}")
    public PersonDTO get(@PathVariable Integer id){
        return servicePerson.searchById(id);
    }
    @PostMapping("/save")
    public PersonDTO save(@RequestBody Person p){
        servicePerson.save(p);
        return p.setToDTO();
    }
    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable Integer id){
        try{
            servicePerson.delete(id);
            return "Se ha borrado el usuario con id "+id;
        }
        catch (Exception e) {
            return "No existe usuario con id "+id;
        }
    }
}
