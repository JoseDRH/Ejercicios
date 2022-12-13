package com.example.block15login.Application.Student.Crud;

import com.example.block15login.Application.Student.Student;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryStudent extends CrudRepository<Student,Integer> {
}
