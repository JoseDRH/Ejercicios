package com.example.block14testing.Application.Subjects.Crud;

import com.example.block14testing.Application.Subjects.Alumno_Estudios;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstudiosRepository extends CrudRepository<Alumno_Estudios,Integer> {

}
