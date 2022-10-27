package com.example.block7crud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ServicePerson {

    @Autowired
    RepositoryPerson repositoryPerson;

    public List<Person> getAllPeople(){
        List<Person> people = new ArrayList<>();
        repositoryPerson.findAll().forEach(person -> people.add(person));
        return people;
    }
    public Person getPersonById(int id){
        return  repositoryPerson.findById(id).get();
    }
    public void savePerson(Person person){
        repositoryPerson.save(person);
    }
    public void deletePerson(int id){
        repositoryPerson.deleteById(id);
    }
    public void updatePerson(Person person,int id){
        Person personFromDb = repositoryPerson.findById(id).get();
        System.out.println(personFromDb);
        personFromDb.setEdad(person.getEdad());
        personFromDb.setCiudad(person.getCiudad());
        personFromDb.setNombre(person.getNombre());
        repositoryPerson.save(personFromDb);
    }



}
