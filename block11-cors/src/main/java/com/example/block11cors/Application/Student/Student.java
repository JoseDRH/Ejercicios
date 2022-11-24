package com.example.block11cors.Application.Student;


import com.example.block11cors.Application.Exceptions.UnprocessableEntityException;
import com.example.block11cors.Application.Person.Person;
import com.example.block11cors.Application.Profesor.Profesor;
import com.example.block11cors.Application.Student.Model.StudentDTO;
import com.example.block11cors.Application.Student.Model.StudentSimpleDTO;
import com.example.block11cors.Application.Subjects.Alumno_Estudios;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Data
@Entity
@Table(name="Student")
@AllArgsConstructor
@NoArgsConstructor
public class Student implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private Integer id_estudiante;
    @OneToOne
    @JoinColumn(name = "id_persona")
    private Person persona;
    @Column(name = "horas_por_semana")
    @NotNull
    private  Integer num_hours_week;        //not null
    @Column(name = "comentarios")
    private String coments;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_profesor")
    private Profesor profesor;
    @Column(name = "rama")
    @NotNull
    private String rama;          //not null


    @ManyToMany( mappedBy ="students")
    public List<Alumno_Estudios>  estudios ;



    public void validacion() throws UnprocessableEntityException {
        if (num_hours_week==null) throw new UnprocessableEntityException("Num_hours_week no puede ser nulo");
    }

    public StudentDTO setToDTO(){
        StudentDTO dto=new StudentDTO();
        dto.setId_estudiante(this.id_estudiante);
        dto.setPersona(this.persona.setToDTO());
        dto.setNum_hours_week(this.num_hours_week);
        dto.setComents(this.coments);
        dto.setRama(this.rama);
      //  dto.setProfesor(this.profesor.setToDTO());

        return dto;
    }
    public StudentSimpleDTO setToSimpleDTO(){
        StudentSimpleDTO dto=new StudentSimpleDTO();
        dto.setId_estudiante(this.id_estudiante);
        dto.setNum_hours_week(this.num_hours_week);
        dto.setComents(this.coments);
        dto.setRama(this.rama);

        return dto;
    }
}
