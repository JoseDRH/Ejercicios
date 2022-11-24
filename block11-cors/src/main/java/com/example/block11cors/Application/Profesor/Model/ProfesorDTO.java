package com.example.block11cors.Application.Profesor.Model;


import com.example.block11cors.Application.Person.Model.PersonDTO;
import lombok.Data;

@Data
public class ProfesorDTO    {

    private Integer id_profesor;

    private PersonDTO persona;

    private String coments;

    private String rama;
}
