package com.example.block7crudvalidation.Application.Student.Model;

import com.example.block7crudvalidation.Application.Person.Model.PersonDTO;
import com.example.block7crudvalidation.Application.Profesor.Model.ProfesorDTO;
import com.example.block7crudvalidation.Application.Subjects.Alumno_Estudios;
import com.example.block7crudvalidation.Application.Person.Person;
import com.example.block7crudvalidation.Application.Profesor.Profesor;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Data
public class StudentDTO   {

    private Integer id_estudiante;

    private PersonDTO persona;

    private Integer num_hours_week;

    private String coments;

    private ProfesorDTO profesor;

    private String rama;

  //  private List<Alumno_Estudios>  estudios;



}
