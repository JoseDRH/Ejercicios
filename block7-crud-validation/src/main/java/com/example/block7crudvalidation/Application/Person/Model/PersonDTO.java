package com.example.block7crudvalidation.Application.Person.Model;


import com.example.block7crudvalidation.Application.Profesor.Model.ProfesorSimpleDTO;
import com.example.block7crudvalidation.Application.Student.Model.StudentSimpleDTO;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class PersonDTO   {

    private Integer id_persona;

    private String usuario;

    private String name;

    private String surname;

    private String company_email;

    private String personal_email;

    private String city;

    private Boolean active;

    private Date created_date;

    private String imagen_url;

    private Date termination_date;

    private StudentSimpleDTO studentSimpleDTO;

    private ProfesorSimpleDTO profesorSimpleDTO;


}
