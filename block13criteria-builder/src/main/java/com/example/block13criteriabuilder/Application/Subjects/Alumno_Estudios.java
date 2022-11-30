package com.example.block13criteriabuilder.Application.Subjects;


import com.example.block13criteriabuilder.Application.Exceptions.UnprocessableEntityException;
import com.example.block13criteriabuilder.Application.Profesor.Profesor;
import com.example.block13criteriabuilder.Application.Student.Model.StudentSimpleDTO;
import com.example.block13criteriabuilder.Application.Student.Student;
import com.example.block13criteriabuilder.Application.Subjects.Model.Alumno_EstudiosDTO;
import com.example.block13criteriabuilder.Application.Subjects.Model.Alumno_EstudiosSimpleDTO;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;

@Data
@Entity
@Table(name="estudios")
@AllArgsConstructor
@NoArgsConstructor
public class Alumno_Estudios implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id_study;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_profesor")
    private Profesor profesor;

    @ManyToMany(cascade = CascadeType.MERGE,fetch = FetchType.LAZY)
    @JoinTable(
            name = "Asignaturas",
            joinColumns = { @JoinColumn(name = "id_study", referencedColumnName = "id_study") },
            inverseJoinColumns = { @JoinColumn(name = "id_estudiante",  referencedColumnName = "id_estudiante") }
    )
    private List<Student> students=new ArrayList<>();

    @Column(name = "asignatura")
    private String asignatura;
    @Column(name = "comentarios")
    String comment;
    @Column(name = "initial_date")
    @NotNull
    private Date initial_date;              //not null
    @Column(name = "finish_date")
    private Date finish_date;

    public List<StudentSimpleDTO> listStudentsdto(){
        List<StudentSimpleDTO> lista=new ArrayList<>();
        students.forEach(student -> lista.add(student.setToSimpleDTO()));
        return lista;
    }
    public void validacion() throws UnprocessableEntityException {
        if(initial_date==null) throw new UnprocessableEntityException("Initial_date no puede ser nulo");
    }

    public Alumno_EstudiosDTO setToDTO(){
        Alumno_EstudiosDTO dto=new Alumno_EstudiosDTO();
        dto.setId_study(this.id_study);
        dto.setProfesor(this.profesor.setToSimpleDTO());
        dto.setStudents(listStudentsdto());
        dto.setAsignatura(this.asignatura);
        dto.setComment(this.comment);
        dto.setInitial_date(this.initial_date);
        dto.setFinish_date(this.finish_date);

        return dto;
    }
    public Alumno_EstudiosSimpleDTO setToSimpleDTO(){
        Alumno_EstudiosSimpleDTO dto=new Alumno_EstudiosSimpleDTO();
        dto.setId_study(this.id_study);
        dto.setProfesor(this.profesor.setToSimpleDTO());
        dto.setAsignatura(this.asignatura);
        dto.setComment(this.comment);
        dto.setInitial_date(this.initial_date);
        dto.setFinish_date(this.finish_date);

        return dto;
    }
}
