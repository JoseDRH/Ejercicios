package com.example.block14testing.alumno_EstudiosTest;

import com.example.block14testing.Application.Exceptions.EntityNotFoundException;
import com.example.block14testing.Application.Person.Person;
import com.example.block14testing.Application.Profesor.Profesor;
import com.example.block14testing.Application.Student.Student;
import com.example.block14testing.Application.Subjects.Alumno_Estudios;
import com.example.block14testing.Application.Subjects.Crud.EstudiosRepository;
import com.example.block14testing.Application.Subjects.Crud.ServiceEstudios;
import org.junit.jupiter.api.*;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Arrays;
import java.util.Date;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@DataJpaTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class EstudiosServiceTest {

    @Mock
    private EstudiosRepository repository;

    @InjectMocks
    private ServiceEstudios service;

    private Alumno_Estudios ae;

    @BeforeEach
    void setUP(){
        Person person=Person.builder()
                .id_persona(1)
                .usuario("Chuchi")
                .name("Jesús Javier")
                .surname("Puente Sánchez")
                .company_email("jesus.puente@bosonit.com")
                .personal_email("jesus.puente@gmail.com")
                .city("Logroño")
                .active(true)
                .created_date(new Date()).build();
        Profesor profesor= Profesor.builder()
                .id_profesor(1)
                .persona(person)
                .coments("He programado una reunión")
                .rama("Backend")
                .build();
        Person pe = Person.builder()
                .id_persona(1)
                .usuario("Jose123")
                .name("Jose")
                .surname("del Rio")
                .company_email("jose.delrio@bosonit.com")
                .personal_email("josedr.hermo@gmail.com")
                .city("SdC")
                .active(true)
                .created_date(new Date()).build();
        Student student= Student.builder()
                .id_estudiante(1)
                .persona(pe)
                .num_hours_week(40)
                .rama("Backend")
                .coments("Muy aplicado")
                .profesor(profesor)
                .build();
        ae= Alumno_Estudios.builder()
                .asignatura("TestingMockito")
                .comment("Test 70%")
                .id_study(1)
                .initial_date(new Date())
                .profesor(profesor)
                .students(Arrays.asList(student))
                .build();
    }

    @Test
    @Order(1)
    void saveAeTest(){
        when(repository.save(any(Alumno_Estudios.class))).thenReturn(ae);
        Assertions.assertNotNull(service.save(ae));
    }
    @Test
    @Order(2)
    void getByIdTest() throws EntityNotFoundException {
        when(repository.findById(any(Integer.class))).thenReturn(Optional.ofNullable(ae));
        Assertions.assertNotNull(service.getById(1));
    }
    @Test
    @Order(3)
    void getExceptionTest()   {
        assertThatExceptionOfType(EntityNotFoundException.class)
                .isThrownBy(()-> service.getById(2));
    }
    @Test
    @Order(4)
    void getAllTest(){
        when(repository.findAll()).thenReturn(Arrays.asList(ae));
        Assertions.assertNotNull(service.getAll());
    }
    @Test
    @Order(5)
    void deleteTest() throws EntityNotFoundException {
        Alumno_Estudios subject=new Alumno_Estudios();
        when(repository.findById(any(Integer.class))).thenReturn(Optional.of(subject));
        service.delete(1);
        verify(repository).findById(1);
    }
    @Test
    @Order(6)
    void deleteExceptionTest(){
        assertThatExceptionOfType(EntityNotFoundException.class)
                .isThrownBy(()->service.delete(1));
    }

}
