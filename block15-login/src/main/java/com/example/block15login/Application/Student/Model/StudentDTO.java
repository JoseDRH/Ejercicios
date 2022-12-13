package com.example.block15login.Application.Student.Model;

import com.example.block15login.Application.Person.Model.PersonDTO;
import com.example.block15login.Application.Profesor.Model.ProfesorDTO;
import lombok.Data;

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
