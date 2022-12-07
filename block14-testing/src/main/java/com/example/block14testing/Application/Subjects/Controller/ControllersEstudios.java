package com.example.block14testing.Application.Subjects.Controller;

import com.example.block14testing.Application.Exceptions.EntityNotFoundException;
import com.example.block14testing.Application.Exceptions.UnprocessableEntityException;
import com.example.block14testing.Application.Student.Crud.ServiceStudent;
import com.example.block14testing.Application.Student.Student;
import com.example.block14testing.Application.Subjects.Alumno_Estudios;
import com.example.block14testing.Application.Subjects.Model.Alumno_EstudiosDTO;
import com.example.block14testing.Application.Subjects.Crud.ServiceEstudios;
import com.example.block14testing.Application.Subjects.Model.Alumno_EstudiosSimpleDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/estudios")
public class ControllersEstudios {

    @Autowired
    ServiceEstudios serviceEstudios;

    @Autowired
    ServiceStudent serviceStudent;


   // @Autowired
  //  ModelMapper modelMap;

    @GetMapping("/estudiante/{id}")
    public List<Alumno_EstudiosSimpleDTO> asignaturas(@PathVariable int id) throws EntityNotFoundException {
        List<Alumno_EstudiosSimpleDTO> list= new ArrayList<>();
        Student s=serviceStudent.getStudentById(id);
        for (Alumno_Estudios ae :
                s.getEstudios()) {
            list.add(ae.setToSimpleDTO());
        }

        return list;
    }

    @GetMapping("/getAll")
    public String seeAll(){
        String list="";
        List<Alumno_Estudios>  asignaturas=serviceEstudios.getAll();
        for (Alumno_Estudios ae :
                asignaturas) {
            list=list+ae.toString()+"\n";
        }
        return list;
    }
    @GetMapping("/id/{id}")
    public Alumno_EstudiosDTO getAsignById(@PathVariable Integer id) throws EntityNotFoundException {
        try {
            Alumno_Estudios ae=serviceEstudios.getById(id);

            return ae.setToDTO();
        } catch (EntityNotFoundException e) {
            throw new EntityNotFoundException();
        }
    }
    @DeleteMapping("/delete/{id}")
    public String deleteAsign(@PathVariable Integer id) throws EntityNotFoundException {
        try{
            Alumno_Estudios ae=serviceEstudios.getById(id);
            if (ae.getStudents().isEmpty() || ae.getStudents()!=null){
                serviceEstudios.delete(id);
                return "Se ha eliminado la asginatura: "+id;
            }
            else {
                return "No se ha podida eliminar la asignatura: "+id+" porque tiene estudiantes asignados";
            }

        } catch (EntityNotFoundException e) {
            throw new EntityNotFoundException();
        }
    }
    @PostMapping("/save")
    public Alumno_EstudiosDTO saveAsign(@RequestBody Alumno_Estudios ae) throws UnprocessableEntityException {

            ae.validacion();
            serviceEstudios.save(ae);
          //  Alumno_EstudiosDTO dto=modelMap.map(ae,Alumno_EstudiosDTO.class);

            return ae.setToDTO();

    }
    @PutMapping("/update")
    public Alumno_EstudiosDTO updateAsign(@RequestBody Alumno_Estudios ae) throws UnprocessableEntityException {

            ae.validacion();
            serviceEstudios.save(ae);


            return ae.setToDTO();

    }
}
