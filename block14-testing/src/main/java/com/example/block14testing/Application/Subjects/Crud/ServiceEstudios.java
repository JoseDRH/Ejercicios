package com.example.block14testing.Application.Subjects.Crud;


import com.example.block14testing.Application.Exceptions.EntityNotFoundException;
import com.example.block14testing.Application.Subjects.Alumno_Estudios;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
       Optional<Alumno_Estudios> ae=repository.findById(id);
        if (ae.isEmpty()  ){
            throw new EntityNotFoundException();
        }
        else return ae.get();
    }
    public Alumno_Estudios save(Alumno_Estudios object){
        return repository.save(object);
    }
    public void  delete(Integer id) throws EntityNotFoundException {
        if (repository.findById(id).isEmpty()){
            throw new EntityNotFoundException();
        }
        else repository.deleteById(id);
    }
}
