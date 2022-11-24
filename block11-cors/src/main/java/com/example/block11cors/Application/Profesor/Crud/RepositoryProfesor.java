package com.example.block11cors.Application.Profesor.Crud;

import com.example.block11cors.Application.Profesor.Profesor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryProfesor extends CrudRepository<Profesor,Integer> {
}
