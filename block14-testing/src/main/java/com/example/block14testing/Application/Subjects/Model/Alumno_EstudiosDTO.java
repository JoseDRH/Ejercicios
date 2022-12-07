package com.example.block14testing.Application.Subjects.Model;


import com.example.block14testing.Application.Profesor.Model.ProfesorSimpleDTO;
import com.example.block14testing.Application.Student.Model.StudentSimpleDTO;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class Alumno_EstudiosDTO {

    private Integer id_study;

    private ProfesorSimpleDTO profesor;


    private List<StudentSimpleDTO> students;

    private String asignatura;

    private String comment;

    private Date initial_date;

    private Date finish_date;
}
