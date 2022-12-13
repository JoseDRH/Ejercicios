package com.example.block15login.Application.Person.Crud;

import com.example.block15login.Application.Exceptions.EntityNotFoundException;
import com.example.block15login.Application.Person.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ServicePerson  {

    @Autowired
    RepositoryPerson repositoryPerson;

    public Person getByName(String name){
        List<Person> people=new ArrayList<>();
        Person pe = new Person();
        repositoryPerson.findAll().forEach(person -> people.add(person));
        for (Person p :
                people) {
            if (p.getUsuario().equals(name)) {
                pe=p;
            }
            }
        return pe;
    }

    public List<Person> getAllPeople(){
        List<Person> people = new ArrayList<>();
        repositoryPerson.findAll().forEach(person -> people.add(person));
        return people;
    }
    public Person getPersonById(Integer id) throws EntityNotFoundException {
            if(repositoryPerson.findById(id).isEmpty()) {
                throw  new EntityNotFoundException();
            }
            else return  repositoryPerson.findById(id).get();
    }

    public void savePerson(Person person){
        repositoryPerson.save(person);
    }
    public void deletePerson(Integer id) throws EntityNotFoundException {
        if(repositoryPerson.findById(id).isEmpty()) {
            throw  new EntityNotFoundException();
        }
        else repositoryPerson.deleteById(id);
    }
}
