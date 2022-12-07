package com.example.block14testing.Application.Person.Crud;

import com.example.block14testing.Application.Person.Person;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryPerson extends CrudRepository<Person, Integer> {

}
