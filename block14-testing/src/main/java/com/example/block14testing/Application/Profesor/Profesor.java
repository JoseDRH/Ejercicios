package com.example.block14testing.Application.Profesor;

import com.example.block14testing.Application.Exceptions.UnprocessableEntityException;
import com.example.block14testing.Application.Person.Person;
import com.example.block14testing.Application.Profesor.Model.ProfesorDTO;
import com.example.block14testing.Application.Profesor.Model.ProfesorSimpleDTO;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Builder
@Table
@AllArgsConstructor
@NoArgsConstructor
public class Profesor implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private Integer id_profesor;
    @OneToOne
    @JoinColumn(name = "id_persona")
    private Person persona;
    @Column(name = "comentarios")
    private String coments;
    @Column
    @NotNull
    private String rama;              //not null


    public void validacion() throws UnprocessableEntityException {
        if (rama==null) {
            throw new UnprocessableEntityException("Rama no puede ser nulo");
        }
    }

    public ProfesorDTO setToDTO(){
        ProfesorDTO dto=new ProfesorDTO();
        dto.setId_profesor(this.id_profesor);
        dto.setComents(this.coments);
        dto.setRama(this.rama);
        dto.setPersona(this.persona.setToDTO());
        return dto;
    }
    public ProfesorSimpleDTO setToSimpleDTO(){
        ProfesorSimpleDTO dto=new ProfesorSimpleDTO();
        dto.setId_profesor(this.id_profesor);
        dto.setComents(this.coments);
        dto.setRama(this.rama);
        return dto;
    }

}
