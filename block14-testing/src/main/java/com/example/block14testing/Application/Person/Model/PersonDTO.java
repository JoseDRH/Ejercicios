package com.example.block14testing.Application.Person.Model;


import com.example.block14testing.Application.Person.Person;
import com.example.block14testing.Application.Profesor.Model.ProfesorSimpleDTO;
import com.example.block14testing.Application.Student.Model.StudentSimpleDTO;
import lombok.Data;

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

    public Person setToEntity(){
        Person p =new Person();
        p.setId_persona(this.id_persona);
        p.setUsuario(this.usuario);
        p.setName(this.name);
        p.setSurname(this.surname);
        p.setCompany_email(this.company_email);
        p.setPersonal_email(this.personal_email);
        p.setCity(this.city);
        p.setActive(this.active);
        p.setCreated_date(this.created_date);
        p.setTermination_date(this.termination_date);
        return p;
    }

}
