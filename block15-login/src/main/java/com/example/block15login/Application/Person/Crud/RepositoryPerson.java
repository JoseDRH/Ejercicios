package com.example.block15login.Application.Person.Crud;

import com.example.block15login.Application.Person.Person;
import org.springframework.data.repository.CrudRepository;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryPerson extends CrudRepository<Person, Integer> {

}
