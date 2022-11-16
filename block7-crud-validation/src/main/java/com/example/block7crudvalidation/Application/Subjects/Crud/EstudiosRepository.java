package com.example.block7crudvalidation.Application.Subjects.Crud;

import com.example.block7crudvalidation.Application.Subjects.Alumno_Estudios;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstudiosRepository extends CrudRepository<Alumno_Estudios,Integer> {

}
