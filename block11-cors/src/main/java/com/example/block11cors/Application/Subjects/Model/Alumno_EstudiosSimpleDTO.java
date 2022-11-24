package com.example.block11cors.Application.Subjects.Model;

import com.example.block11cors.Application.Profesor.Model.ProfesorSimpleDTO;
import lombok.Data;

import java.util.Date;

@Data
public class Alumno_EstudiosSimpleDTO {

    private Integer id_study;

    private ProfesorSimpleDTO profesor;

    private String asignatura;

    private String comment;

    private Date initial_date;

    private Date finish_date;
}
