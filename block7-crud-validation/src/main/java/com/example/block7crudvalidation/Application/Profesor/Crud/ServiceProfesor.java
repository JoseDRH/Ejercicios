package com.example.block7crudvalidation.Application.Profesor.Crud;

import com.example.block7crudvalidation.Application.Exceptions.EntityNotFoundException;
import com.example.block7crudvalidation.Application.Profesor.Crud.RepositoryProfesor;
import com.example.block7crudvalidation.Application.Profesor.Profesor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ServiceProfesor {

    @Autowired
    RepositoryProfesor repositoryProfesor;

    public List<Profesor> getAllProfesor(){
        List<Profesor> list=new ArrayList<>();
        repositoryProfesor.findAll().forEach(profesor -> list.add(profesor));
        return list;
    }
    public Profesor getProfesorbyId(Integer id) throws EntityNotFoundException {
        if (repositoryProfesor.findById(id).isEmpty()){
            throw new EntityNotFoundException();
        }
        else return repositoryProfesor.findById(id).get();
    }



    public void saveProfesor(Profesor profesor){
        repositoryProfesor.save(profesor);
    }
    public void deleteProfesor(Integer id) throws EntityNotFoundException {
        if (repositoryProfesor.findById(id).isEmpty()){
            throw new EntityNotFoundException();
        }
        else repositoryProfesor.deleteById(id);
    }

}
