package com.example.block13criteriabuilder.Application.Student.Model;

import com.example.block13criteriabuilder.Application.Person.Model.PersonDTO;
import com.example.block13criteriabuilder.Application.Profesor.Model.ProfesorDTO;
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
