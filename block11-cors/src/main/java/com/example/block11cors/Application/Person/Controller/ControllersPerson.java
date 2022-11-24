package com.example.block11cors.Application.Person.Controller;

import com.example.block11cors.Application.Exceptions.EntityNotFoundException;
import com.example.block11cors.Application.Exceptions.UnprocessableEntityException;
import com.example.block11cors.Application.Person.Crud.ServicePerson;
import com.example.block11cors.Application.Person.Model.PersonDTO;
import com.example.block11cors.Application.Person.Person;
import com.example.block11cors.Application.Profesor.Crud.ServiceProfesor;
import com.example.block11cors.Application.Profesor.Profesor;
import com.example.block11cors.Application.Student.Crud.ServiceStudent;
import com.example.block11cors.Application.Student.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "*", methods = {RequestMethod.DELETE, RequestMethod.GET, RequestMethod.POST})
@RequestMapping("/")
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
           try{
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
           catch (EntityNotFoundException e){
               throw new RuntimeException(e);
           }

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

        @GetMapping(path = "/getall")
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
            try {
                for (Student s:
                     serviceStudent.getAllStudents()) {
                    if (s.getPersona().getId_persona()==id){
                        return "No puede borrar la persona porque tiene asignado un estudiante";
                    }
                }
                for (Profesor p :
                        serviceProfesor.getAllProfesor()) {
                    if (p.getPersona().getId_persona()==id){
                        return "No puede borrar la persona porque tiene asignado un profesor";
                    }
                }
                servicePerson.deletePerson(id);
                return "Persona eliminada " + id;
            }
            catch (EntityNotFoundException e){
                return e.toString();
            }
        }

        @PostMapping(path="/addperson")
        public PersonDTO add(@RequestBody Person person) throws UnprocessableEntityException {
          try{
              person.validacionJava();
              servicePerson.savePerson(person);

              return person.setToDTO();
          }
          catch (UnprocessableEntityException e){
              System.out.println(e);
              throw new RuntimeException(e);
          }
        }
        @PutMapping(path="/updatePerson")
        public PersonDTO update(@RequestBody Person person) throws UnprocessableEntityException {
            try{
                person.validacionJava();
                servicePerson.savePerson(person);

                return person.setToDTO();
            }
            catch (UnprocessableEntityException e){
                System.out.println(e);
                throw new RuntimeException(e);
            }
        }


}
