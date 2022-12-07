package com.example.block14testing.Application.Profesor.Controller;

import com.example.block14testing.Application.Exceptions.EntityNotFoundException;
import com.example.block14testing.Application.Exceptions.UnprocessableEntityException;
import com.example.block14testing.Application.Profesor.Profesor;
import com.example.block14testing.Application.Profesor.Model.ProfesorDTO;
import com.example.block14testing.Application.Profesor.Crud.ServiceProfesor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/profesor")
public class ControllersProfesor {

    @Autowired
    ServiceProfesor serviceProfesor;



    @GetMapping(path = "/id/{id}")
    public ProfesorDTO searchProfesorById(@PathVariable Integer id) throws EntityNotFoundException {

            Profesor profesor=serviceProfesor.getProfesorbyId(id);


            return profesor.setToDTO();

    }
    @GetMapping(path = "/nombre/{nombre}")
    public String searchProfesorByName(@PathVariable String nombre) throws EntityNotFoundException {
        List<Profesor> profesorado = serviceProfesor.getAllProfesor();
        for (Profesor p :
                profesorado) {
            if (p.getPersona().getName().equals(nombre)) {
                return p.toString();
            }
        }
        return "No se ha encontrado el profesor por nombre";
    }
    @GetMapping(path = "/seeAll")
    public String seeAll(){
        String list="";
        List<Profesor> profesorado = serviceProfesor.getAllProfesor();
        for (Profesor p :
                profesorado) {
            list=list+p.toString();
        }
        return list;
    }
    @DeleteMapping(path = "/delete/{id}")
    public String delete(@PathVariable Integer id) throws EntityNotFoundException{

            serviceProfesor.deleteProfesor(id);
            return "Profesor eliminado: "+id;

    }
    @PostMapping(path = "/addPerson")
    public ProfesorDTO add(@RequestBody Profesor profesor) throws UnprocessableEntityException {

            profesor.validacion();
            serviceProfesor.saveProfesor(profesor);


            return profesor.setToDTO();


    }
    @PutMapping(path = "/updatePerson")
    public ProfesorDTO update(@RequestBody Profesor profesor) throws UnprocessableEntityException {

        profesor.validacion();
        serviceProfesor.saveProfesor(profesor);


        return profesor.setToDTO();

    }

}
