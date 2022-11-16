package com.example.block7crudvalidation.Application.Student.Crud;

import com.example.block7crudvalidation.Application.Student.Student;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryStudent extends CrudRepository<Student,Integer> {
}
