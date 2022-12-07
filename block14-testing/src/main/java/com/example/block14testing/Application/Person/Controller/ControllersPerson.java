package com.example.block14testing.Application.Person.Controller;

import com.example.block14testing.Application.Exceptions.EntityNotFoundException;
import com.example.block14testing.Application.Exceptions.UnprocessableEntityException;
import com.example.block14testing.Application.Person.Crud.ServicePerson;
import com.example.block14testing.Application.Person.Model.PersonDTO;
import com.example.block14testing.Application.Person.Person;
import com.example.block14testing.Application.Profesor.Crud.ServiceProfesor;
import com.example.block14testing.Application.Profesor.Profesor;
import com.example.block14testing.Application.Student.Crud.ServiceStudent;
import com.example.block14testing.Application.Student.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/persona")
public class ControllersPerson {

        @Autowired
        ServicePerson servicePerson;
        @Autowired
        ServiceProfesor serviceProfesor;
        @Autowired
        ServiceStudent serviceStudent;


        private String whoIs(int id){
            for (Student s:
                    serviceStudent.getAllStudents()) {
                if (s.getPersona().getId_persona()==id){
                    return "/s";
                }
            }
            for (Profesor p :
                    serviceProfesor.getAllProfesor()) {
                if (p.getPersona().getId_persona()==id){
                    return "/p";
                }
            }

            return "";
        }
        private Student encontrarS(int idPer){
            for (Student s:
                    serviceStudent.getAllStudents()) {
                if (s.getPersona().getId_persona()==idPer){
                    return s;
                }
            }
            return new Student();
        }
        private Profesor encontrarP(int idPer){
            for (Profesor s:
                    serviceProfesor.getAllProfesor()) {
                if (s.getPersona().getId_persona()==idPer){
                    return s;
                }
            }
            return new Profesor();
        }





        @GetMapping(path="/id/{id}")
        public PersonDTO searchByID(@PathVariable Integer id,@RequestParam (defaultValue = "simple")String outputType ) throws EntityNotFoundException {

               Person person=servicePerson.getPersonById(id);
               PersonDTO dto= person.setToDTO();
               if (outputType.equals("full")){
                String res=whoIs(id);
                if (res.equals("/s")){
                    dto.setStudentSimpleDTO(encontrarS(id).setToSimpleDTO());
                }
               if (res.equals("/p")){
                   dto.setProfesorSimpleDTO(encontrarP(id).setToSimpleDTO());
               }
               }

               return dto;


        }
        @GetMapping(path="/nombre/{nombre}")
        public PersonDTO searchByName(@PathVariable String nombre,@RequestParam (defaultValue = "simple")String outputType){
            List<Person> list=servicePerson.getAllPeople();
            PersonDTO dto=new PersonDTO();
            for (Person p :
                    list) {
                if (p.getName().equals(nombre)) {
                    if (outputType.equals("full")){
                        String res=whoIs(p.getId_persona());
                        if (res.equals("/s")){
                            dto.setStudentSimpleDTO(encontrarS(p.getId_persona()).setToSimpleDTO());
                           return  dto;
                        }
                        if (res.equals("/p")){
                            dto.setProfesorSimpleDTO(encontrarP(p.getId_persona()).setToSimpleDTO());
                            return dto;
                        }
                    }
                    else {
                        return p.setToDTO();
                    }
                }
            }
            return new PersonDTO();
        }
        @GetMapping(path = "/seeAll")
        public List<PersonDTO> seeAll(@RequestParam (defaultValue = "simple")String outputType){
                List<PersonDTO> list=new ArrayList<>();
                List<Person> people=servicePerson.getAllPeople();
                for (Person p :
                        people) {
                    PersonDTO dto=p.setToDTO();
                    if (outputType.equals("full")) {
                        String res = whoIs(p.getId_persona());
                        if (res.equals("/s")) {
                            dto.setStudentSimpleDTO(encontrarS(p.getId_persona()).setToSimpleDTO());
                        }
                        if (res.equals("/p")) {
                            dto.setProfesorSimpleDTO(encontrarP(p.getId_persona()).setToSimpleDTO());
                        }
                    }
                    list.add(dto);
                }
                return list;
            }
        @DeleteMapping(path="/delete/{id}")
        public String delete(@PathVariable Integer id) throws EntityNotFoundException {

                for (Student s:
                     serviceStudent.getAllStudents()) {
                    if (Objects.equals(s.getPersona().getId_persona(), id)){
                        return "No puede borrar la persona porque tiene asignado un estudiante";
                    }
                }
                for (Profesor p :
                        serviceProfesor.getAllProfesor()) {
                    if (Objects.equals(p.getPersona().getId_persona(), id)){
                        return "No puede borrar la persona porque tiene asignado un profesor";
                    }
                }
                servicePerson.deletePerson(id);
                return "Persona eliminada " + id;


        }
        @PostMapping(path="/addPerson")
        public PersonDTO add(@RequestBody Person person) throws UnprocessableEntityException {

              person.validacionJava();
              servicePerson.savePerson(person);

              return person.setToDTO();

        }
        @PutMapping(path="/updatePerson")
        public PersonDTO update(@RequestBody Person person) throws UnprocessableEntityException {

                person.validacionJava();
                servicePerson.savePerson(person);

                return person.setToDTO();

        }


}
