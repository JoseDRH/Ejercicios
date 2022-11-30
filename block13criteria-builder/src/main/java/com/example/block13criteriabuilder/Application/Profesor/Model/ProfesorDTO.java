package com.example.block13criteriabuilder.Application.Profesor.Model;


import com.example.block13criteriabuilder.Application.Person.Model.PersonDTO;
import lombok.Data;

@Data
public class ProfesorDTO    {

    private Integer id_profesor;

    private PersonDTO persona;

    private String coments;

    private String rama;
}
