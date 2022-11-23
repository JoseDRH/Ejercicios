package com.example.block10docker.repository;

import com.example.block10docker.entity.Person;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryPerson extends CrudRepository<Person,Integer> {
}
