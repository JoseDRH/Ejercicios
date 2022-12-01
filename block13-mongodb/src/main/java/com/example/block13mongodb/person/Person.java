package com.example.block13mongodb.person;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "Person")
public class Person {

    @Id
    private Integer id;

    private String name;

    private String surname;

    private String user;

    public PersonDTO setToDTO(){
        return new PersonDTO(this.id,this.name,this.surname,this.user);
    }

}
