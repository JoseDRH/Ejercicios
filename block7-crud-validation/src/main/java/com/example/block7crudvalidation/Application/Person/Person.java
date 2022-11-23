package com.example.block7crudvalidation.Application.Person;

import com.example.block7crudvalidation.Application.Exceptions.UnprocessableEntityException;
import com.example.block7crudvalidation.Application.Generador;
import com.example.block7crudvalidation.Application.Person.Model.PersonDTO;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
@Entity
@Table
@AllArgsConstructor
@NoArgsConstructor
public class Person implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
  /*  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "persona_seq" )
    @GenericGenerator(
            name = "persona_seq",
            strategy = "com.example.block7crudvalidation.Application.Generador",
            parameters = {
                    @Parameter(name = Generador.INCREMENT_PARAM, value="1"),
                    @Parameter(name= Generador.VALUE_PREFIX_PARAMETER, value="Persona_")
            }
    )*/
    private Integer id_persona;         //[PK, AUTO-INCREMENTAL
    @Column
    @NotNull
    private String usuario;         //[not null, max-lenght:10,min-lenght:6]
    @Column
    @NotNull
    private String name;            //[not null]
    @Column
    private String surname;
    @Column
    @NotNull
    private String company_email;   //[not null]
    @Column
    @NotNull
    private String personal_email;  //[not null]
    @Column
    @NotNull
    private String city;            //[not null]
    @Column
    @NotNull
    private Boolean active;         //[not null]
    @Column
    @NotNull
    private Date created_date;      //[not null]
    @Column
    private String imagen_url;
    @Column
    private Date termination_date;


    public void validacionJava() throws UnprocessableEntityException {
        if(usuario==null)throw new UnprocessableEntityException("Usuario no puede ser nulo");

        if (usuario.length()>10) throw  new UnprocessableEntityException("Longitud de usuario no puede ser superior a 10 caracteres");

        if(usuario.length()<6)throw new UnprocessableEntityException("Longitud de usuario no pueder ser menor a 6 caracteres");

        if(name==null)throw new UnprocessableEntityException("Name no pueder ser nulo");

        if(company_email==null)throw new UnprocessableEntityException("Company_email no puede ser nulo");

        if(personal_email==null)throw new UnprocessableEntityException("Personal_email no pueder ser nulo");

        if(city==null)throw new UnprocessableEntityException("City no puede ser nulo");

        if(active==null)throw new UnprocessableEntityException("Active no pueder ser nulo");

        if(created_date==null)throw new UnprocessableEntityException("Created_date no pueder ser nulo");
    }

    public PersonDTO setToDTO(){
        PersonDTO dto=new PersonDTO();
        dto.setId_persona(this.id_persona);
        dto.setUsuario( this.usuario);
        dto.setName( this.name);
        dto.setSurname(this.surname);
        dto.setPersonal_email(this.personal_email);
        dto.setCity(this.city);
        dto.setActive(this.active);
        dto.setCreated_date(this.created_date);
        dto.setImagen_url(this.imagen_url);
        dto.setTermination_date(this.termination_date);

        return dto;
    }

}
