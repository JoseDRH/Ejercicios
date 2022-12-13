package com.example.block15login.Application.Subjects.Crud;


import com.example.block15login.Application.Exceptions.EntityNotFoundException;
import com.example.block15login.Application.Subjects.Alumno_Estudios;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ServiceEstudios {

    @Autowired
    EstudiosRepository repository;

    public List<Alumno_Estudios> getAll(){
        List<Alumno_Estudios> list=new ArrayList<>();
        repository.findAll().forEach(objeto->{list.add(objeto);});
        return list;
    }
    public Alumno_Estudios getById(Integer id) throws EntityNotFoundException {
        if (repository.findById(id).isEmpty()){
            throw new EntityNotFoundException();
        }
        else return repository.findById(id).get();
    }
    public void save(Alumno_Estudios object){
        repository.save(object);
    }
    public void  delete(Integer id) throws EntityNotFoundException {
        if (repository.findById(id).isEmpty()){
            throw new EntityNotFoundException();
        }
        else repository.deleteById(id);
    }
}
