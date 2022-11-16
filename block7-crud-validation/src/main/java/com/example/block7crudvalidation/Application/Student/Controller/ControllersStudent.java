package com.example.block7crudvalidation.Application.Student.Controller;


import com.example.block7crudvalidation.Application.Exceptions.EntityNotFoundException;
import com.example.block7crudvalidation.Application.Exceptions.UnprocessableEntityException;
import com.example.block7crudvalidation.Application.Person.Person;
import com.example.block7crudvalidation.Application.Profesor.Profesor;
import com.example.block7crudvalidation.Application.Student.Crud.ServiceStudent;
import com.example.block7crudvalidation.Application.Student.Student;
import com.example.block7crudvalidation.Application.Student.Model.StudentDTO;
import com.example.block7crudvalidation.Application.Subjects.Alumno_Estudios;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/estudiante")
public class ControllersStudent {

    @Autowired
    ServiceStudent serviceStudent;



    @RequestMapping(path = "/id/{id}",method = RequestMethod.GET)
    public StudentDTO searchByStudentId(@PathVariable Integer id, @RequestParam(defaultValue = "simple")String outputType) throws EntityNotFoundException{
        try{
            Student student=serviceStudent.getStudentById(id);

            Integer id_stu= student.getId_estudiante();
            String coment=(student.getComents());
            String rama=(student.getRama());
            Person p=(student.getPersona());
            Integer num_hours=(student.getNum_hours_week());
            Profesor pro=(student.getProfesor());
           StudentDTO dto = new StudentDTO();


            if (outputType.equals("full")){
                dto.setRama(rama);
                dto.setComents(coment);
                dto.setNum_hours_week(num_hours);
                dto.setId_estudiante(id_stu);
                dto.setPersona(p.setToDTO());
                dto.setProfesor(pro.setToDTO());

            }
            else {
                dto.setRama(rama);
                dto.setComents(coment);
                dto.setNum_hours_week(num_hours);
                dto.setId_estudiante(id_stu);
                dto.setProfesor(pro.setToDTO());
              //  dto.setEstudios(list);
            }
            return  dto;
        }
        catch (EntityNotFoundException e){
            throw new RuntimeException(e);
        }
    }
    @GetMapping(path="/nombre/{nombre}")
    public String searchByName(@PathVariable String nombre){
        List<Student> list=serviceStudent.getAllStudents();
        for (Student s :
                list) {
            if (s.getPersona().getName().equals(nombre)) {
                return s.toString();
            }
        }
        return "No se ha encontrado el estudiante por nombre";
    }
    @GetMapping(path = "/seeAll")
    public String seeAll(){
        String list="";
        List<Student> people=serviceStudent.getAllStudents();
        for (Student p :
                people) {
            list=list+p.toString()+"\n";
        }
        return list;
    }
    @DeleteMapping(path="/delete/{id}")
    public String delete(@PathVariable Integer id) throws EntityNotFoundException {
        try {
            serviceStudent.deleteStudent(id);
            return "Estudiante eliminado " + id;
        }
        catch (EntityNotFoundException e){
            return e.toString();
        }
    }
    @PostMapping(path="/addPerson")
    public StudentDTO add(@RequestBody Student student) throws UnprocessableEntityException {
        try{
            student.validacion();
            serviceStudent.saveStudent(student);

            return student.setToDTO();
        }
        catch (UnprocessableEntityException e){
            System.out.println(e);
            throw new RuntimeException(e);
        }
    }
    @PutMapping(path="/updatePerson")
    public StudentDTO update(@RequestBody Student student) throws UnprocessableEntityException {
        try{
            student.validacion();
            serviceStudent.saveStudent(student);


            return student.setToDTO();
        }
        catch (UnprocessableEntityException e){
            System.out.println(e);
            throw new RuntimeException(e);
        }
    }

}
