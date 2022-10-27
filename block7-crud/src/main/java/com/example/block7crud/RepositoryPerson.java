package com.example.block7crud;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RepositoryPerson extends CrudRepository<Person, Integer> {

}
