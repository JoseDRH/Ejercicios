package com.example.block13criteriabuilder.Application.Subjects.Crud;

import com.example.block13criteriabuilder.Application.Subjects.Alumno_Estudios;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstudiosRepository extends CrudRepository<Alumno_Estudios,Integer> {

}
