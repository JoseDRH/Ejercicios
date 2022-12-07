package com.example.block14testing.alumno_EstudiosTest;

import com.example.block14testing.Application.Exceptions.EntityNotFoundException;
import com.example.block14testing.Application.Exceptions.UnprocessableEntityException;
import com.example.block14testing.Application.Person.Person;
import com.example.block14testing.Application.Profesor.Profesor;
import com.example.block14testing.Application.Student.Crud.RepositoryStudent;
import com.example.block14testing.Application.Student.Crud.ServiceStudent;
import com.example.block14testing.Application.Student.Student;
import com.example.block14testing.Application.Subjects.Alumno_Estudios;
import com.example.block14testing.Application.Subjects.Controller.ControllersEstudios;
import com.example.block14testing.Application.Subjects.Crud.EstudiosRepository;
import com.example.block14testing.Application.Subjects.Crud.ServiceEstudios;
import org.junit.jupiter.api.*;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Arrays;
import java.util.Date;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@DataJpaTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class Alumno_estudiosControllerTest {

    @Mock
    private EstudiosRepository repository;


    @Mock
    private ServiceEstudios service;

    @InjectMocks
    private  ControllersEstudios controller;

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
    void saveAETest() throws UnprocessableEntityException {

        when(service.save(any(Alumno_Estudios.class))).thenReturn(ae);
        assertNotNull(controller.saveAsign(ae));
    }
    @Test
    @Order(2)
    void getSubjectTest() throws EntityNotFoundException {
        when(service.getById(any(Integer.class))).thenReturn(ae);
        assertNotNull(controller.getAsignById(1));
    }

    @Test
    @Order(3)
    void getSubjectExceptionTest() throws EntityNotFoundException {
        when(service.getById(any(Integer.class))).thenThrow(EntityNotFoundException.class);
        assertThatExceptionOfType(EntityNotFoundException.class)
                .isThrownBy(()->controller.getAsignById(2));
    }
    @Test
    @Order(4)
    void getSubjectsTest(){
        when(service.getAll()).thenReturn(Arrays.asList(ae));
        assertNotNull(controller.seeAll());
    }
    @Test
    @Order(5)
    void deleteSubject() throws EntityNotFoundException {
        Alumno_Estudios subject=new Alumno_Estudios();
        when(service.getById(any(Integer.class))).thenReturn(subject);
        controller.deleteAsign(1);
        verify(service).getById(1);
    }
    @Test
    @Order(6)
    void setToDTOTest(){
        assertThat(ae.setToDTO().getAsignatura().equals("TestingMockito"));
    }
    @Test
    @Order(7)
    void setToSimpleDTO(){
        assertThat(ae.setToSimpleDTO().getAsignatura().equals("TestingMockito"));
    }
    @Test
    @Order(8)
    void deleteExceptionTest() throws EntityNotFoundException {
        when(service.getById(any(Integer.class))).thenThrow(EntityNotFoundException.class);
        assertThatExceptionOfType(EntityNotFoundException.class)
                .isThrownBy(() ->controller.deleteAsign(2));
    }
    @Test
    @Order(9)
    void subjectValidationTest(){
        assertThatExceptionOfType(UnprocessableEntityException.class)
                .isThrownBy(() -> new Alumno_Estudios().validacion());
    }
    @Test
    @Order(10)
    void updateTest() throws UnprocessableEntityException {
        when(service.save(any(Alumno_Estudios.class))).thenReturn(ae);
        assertNotNull(controller.updateAsign(ae));
    }
    @Test
    @Order(11)
    void updateExceptionTest(){
        Alumno_Estudios sub=new Alumno_Estudios();
        assertThatExceptionOfType(UnprocessableEntityException.class)
                .isThrownBy(()-> controller.updateAsign(sub));
    }
    @Test
    @Order(12)
    void saveExceptionTest(){
        assertThatExceptionOfType(UnprocessableEntityException.class)
                .isThrownBy(()->controller.saveAsign(new Alumno_Estudios()));
    }



}
