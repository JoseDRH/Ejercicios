package com.example.block13criteriabuilder.Application.Person.Crud;

import com.example.block13criteriabuilder.Application.Person.Model.PersonDTO;
import com.example.block13criteriabuilder.Application.Person.Person;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Repository
public interface RepositoryPerson extends CrudRepository<Person, Integer> {



}
