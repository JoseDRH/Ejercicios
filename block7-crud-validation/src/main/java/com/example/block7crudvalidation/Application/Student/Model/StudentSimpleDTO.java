package com.example.block7crudvalidation.Application.Student.Model;

import com.example.block7crudvalidation.Application.Person.Model.PersonDTO;
import com.example.block7crudvalidation.Application.Person.Person;
import lombok.Data;

@Data
public class StudentSimpleDTO {

    private Integer id_estudiante;



    private Integer num_hours_week;

    private String coments;

    private String rama;

}
