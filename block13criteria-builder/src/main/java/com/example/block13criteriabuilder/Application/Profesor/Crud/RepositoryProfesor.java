package com.example.block13criteriabuilder.Application.Profesor.Crud;

import com.example.block13criteriabuilder.Application.Profesor.Profesor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryProfesor extends CrudRepository<Profesor,Integer> {
}
