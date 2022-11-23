package com.example.block10docker.entity;


import com.example.block10docker.dto.PersonDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nombre;

    private String ciudad;

    public PersonDTO setToDTO(){
        PersonDTO dto=new PersonDTO();
        dto.setId(this.id);
        dto.setNombre(this.nombre);
        dto.setCiudad(this.ciudad);
        return dto;
    }

}
