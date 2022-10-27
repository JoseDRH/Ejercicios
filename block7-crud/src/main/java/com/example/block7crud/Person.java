package com.example.block7crud;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Table
@AllArgsConstructor
@NoArgsConstructor
public class Person {
    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY )
    private Integer id;
    @Column
    private String nombre;
    @Column
    private String ciudad;
    @Column
    private int edad;


}
