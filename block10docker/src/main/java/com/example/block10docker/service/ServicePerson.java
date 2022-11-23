package com.example.block10docker.service;

import com.example.block10docker.dto.PersonDTO;
import com.example.block10docker.entity.Person;
import com.example.block10docker.repository.RepositoryPerson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ServicePerson {

    @Autowired
    RepositoryPerson repository;

    public void save(Person person){
       repository.save(person);
    }
    public void delete(Integer id){
        repository.deleteById(id);
    }
    public List<PersonDTO> getAll(){
       List<Person> list=new ArrayList<>();
       repository.findAll().forEach(person -> list.add(person));
       List<PersonDTO> dtos=new ArrayList<>();
        for (Person p :
                list) {
            dtos.add(p.setToDTO());
        }
       return dtos;
    }
    public PersonDTO searchById(Integer id){
        return repository.findById(id).get().setToDTO();
    }

}
