package com.example.block14testing.Application.Person.Crud;

import com.example.block14testing.Application.Exceptions.EntityNotFoundException;
import com.example.block14testing.Application.Person.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ServicePerson  {

    @Autowired
    RepositoryPerson repositoryPerson;

    public List<Person> getAllPeople(){
        List<Person> people = new ArrayList<>();
        repositoryPerson.findAll().forEach(person -> people.add(person));
        return people;
    }
    public Person getPersonById(Integer id) throws EntityNotFoundException {
            if(!repositoryPerson.findById(id).isPresent()) {
                throw  new EntityNotFoundException();
            }
            else return  repositoryPerson.findById(id).get();
    }
    public Person savePerson(Person person){
        return repositoryPerson.save(person);
    }
    public void deletePerson(Integer id) throws EntityNotFoundException {
        if(repositoryPerson.findById(id).isEmpty()) {
            throw  new EntityNotFoundException();
        }
        else repositoryPerson.deleteById(id);
    }
}
