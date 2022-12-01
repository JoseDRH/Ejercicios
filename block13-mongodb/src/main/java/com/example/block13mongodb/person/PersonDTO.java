package com.example.block13mongodb.person;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PersonDTO {

    private Integer id;

    private String name;

    private String surname;

    private String user;
}
