package com.example.block13criteriabuilder.Application.Student.Crud;

import com.example.block13criteriabuilder.Application.Student.Student;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryStudent extends CrudRepository<Student,Integer> {
}
