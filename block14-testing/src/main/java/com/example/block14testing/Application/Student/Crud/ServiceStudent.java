package com.example.block14testing.Application.Student.Crud;

import com.example.block14testing.Application.Exceptions.EntityNotFoundException;
import com.example.block14testing.Application.Student.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ServiceStudent {

    @Autowired
    RepositoryStudent repositoryStudent;



    public List<Student> getAllStudents(){
        List<Student> studients=new ArrayList<>();
        repositoryStudent.findAll().forEach(student -> studients.add(student));
        return studients;
    }
    public Student getStudentById(Integer id) throws EntityNotFoundException {
        if (repositoryStudent.findById(id).isEmpty()){
            throw new EntityNotFoundException();
        }
        else return repositoryStudent.findById(id).get();
    }



    public Student saveStudent(Student student){
        return repositoryStudent.save(student);
    }
    public void deleteStudent(Integer id) throws EntityNotFoundException {
        if (repositoryStudent.findById(id).isEmpty()){
            throw new EntityNotFoundException();
        }
        else repositoryStudent.deleteById(id);
    }


}
