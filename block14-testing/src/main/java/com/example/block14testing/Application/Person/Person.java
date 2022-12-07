package com.example.block14testing.Application.Person;

import com.example.block14testing.Application.Exceptions.UnprocessableEntityException;
import com.example.block14testing.Application.Person.Model.PersonDTO;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
@Entity
@Table
@Builder
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
       boolean error=false;
       String msg="";
        if(usuario==null){
            msg+="\n"+"Usuario no puede ser nulo";
            error=true;
        }
        else if (usuario.length()>10) {
            msg+="\n"+"Longitud de usuario no puede ser superior a 10 caracteres";
            error=true;
        }
        else if(usuario.length()<6){
            msg+="\n"+"Longitud de usuario no pueder ser menor a 6 caracteres";
            error=true;
        }

        if(name==null){
            msg+="\n"+"Name no pueder ser nulo";
            error=true;
        }

        if(company_email==null){
            msg+="\n"+"Company_email no puede ser nulo";
            error=true;
        }

        if(personal_email==null){
            msg+="\n"+"Personal_email no pueder ser nulo";
            error=true;
        }

        if(city==null) {
            msg+="\n"+"City no puede ser nulo";
            error=true;
        }

        if(active==null){
            msg+="\n"+"Active no pueder ser nulo";
            error=true;
        }

        if(created_date==null){
            msg+="\n"+"Created_date no pueder ser nulo";
            error=true;
        }

        if (error){
             throw new UnprocessableEntityException(msg);
         }
    }

    public PersonDTO setToDTO(){
        PersonDTO dto=new PersonDTO();
        dto.setId_persona(this.id_persona);
        dto.setUsuario( this.usuario);
        dto.setName( this.name);
        dto.setSurname(this.surname);
        dto.setCompany_email(this.company_email);
        dto.setPersonal_email(this.personal_email);
        dto.setCity(this.city);
        dto.setActive(this.active);
        dto.setCreated_date(this.created_date);
        dto.setImagen_url(this.imagen_url);
        dto.setTermination_date(this.termination_date);

        return dto;
    }

}
