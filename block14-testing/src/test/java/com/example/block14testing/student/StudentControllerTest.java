package com.example.block14testing.student;

import com.example.block14testing.Application.Exceptions.EntityNotFoundException;
import com.example.block14testing.Application.Exceptions.UnprocessableEntityException;
import com.example.block14testing.Application.Person.Person;
import com.example.block14testing.Application.Profesor.Profesor;
import com.example.block14testing.Application.Student.Controller.ControllersStudent;
import com.example.block14testing.Application.Student.Crud.RepositoryStudent;
import com.example.block14testing.Application.Student.Crud.ServiceStudent;
import com.example.block14testing.Application.Student.Student;
import org.junit.jupiter.api.*;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Arrays;
import java.util.Date;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@DataJpaTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class StudentControllerTest {

    @Mock
    private RepositoryStudent repositoryStudent;

    @Mock
    private ServiceStudent serviceStudent;

    @InjectMocks
    private ControllersStudent controller;


    private Student student;
    @BeforeEach
    void setUp(){
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
       student=Student.builder()
               .id_estudiante(1)
               .persona(pe)
               .num_hours_week(40)
               .rama("Backend")
               .coments("Muy aplicado")
               .profesor(profesor)
               .build();
    }

    @Test
    @Order(1)
    void saveStudent() throws UnprocessableEntityException {
        when(serviceStudent.saveStudent(any(Student.class))).thenReturn(student);
        assertNotNull(controller.add(student));
    }

    @Test
    @Order(2)
    void getStudentTest() throws EntityNotFoundException {
        when(serviceStudent.getStudentById(any(Integer.class))).thenReturn((student));
        assertNotNull(controller.searchByStudentId(1,"simple"));
    }
    @Test
    @Order(3)
    void getStudentExceptionTest() throws EntityNotFoundException {
        when(serviceStudent.getStudentById(any(Integer.class))).thenThrow(EntityNotFoundException.class);
        assertThatExceptionOfType(EntityNotFoundException.class)
                .isThrownBy(() -> controller.searchByStudentId(2,"simple"));
    }
    @Test
    @Order(4)
    void getStudentsTest(){
        when(serviceStudent.getAllStudents()).thenReturn(Arrays.asList(student));
        assertNotNull(controller.seeAll());
    }
    @Test
    @Order(5)
    void deleteStudentTest() throws EntityNotFoundException {
        Student st=new Student();
        when(serviceStudent.getStudentById(any(Integer.class))).thenReturn(st);
        controller.delete(1);
        verify(serviceStudent).deleteStudent(1);
    }
    @Test
    @Order(6)
    void setToDTOTest(){
        assertThat(student.setToDTO().getRama().equals("Backend"));
    }
    @Test
    @Order(7)
    void setToSimpleDTOTest(){
        assertThat(student.setToSimpleDTO().getRama().equals("Backend"));
    }
    @Test
    @Order(8)
    void deleteExceptionTest() throws EntityNotFoundException {
        when(controller.delete(any(Integer.class))).thenThrow(EntityNotFoundException.class);
        assertThatExceptionOfType(EntityNotFoundException.class)
                .isThrownBy(()->controller.delete(2));
    }
    @Test
    @Order(9)
    void studentValidationTest(){
        assertThatExceptionOfType(UnprocessableEntityException.class)
                .isThrownBy(() ->new Student().validacion()).withMessage(null);
    }
    @Test
    @Order(10)
    void saveExceptionTest(){

        assertThatExceptionOfType(UnprocessableEntityException.class)
                .isThrownBy(()-> controller.add(new Student()));
    }
    @Test
    @Order(11)
    void updateTEst() throws UnprocessableEntityException {
        when(serviceStudent.saveStudent(any(Student.class))).thenReturn(student);
        assertNotNull(controller.update(student));
    }
    @Test
    @Order(12)
    void updateExceptionTest(){
        Student s=new Student();
        assertThatExceptionOfType(UnprocessableEntityException.class)
                .isThrownBy(()->controller.update(s));
    }
    @Test
    @Order(13)
    void getStudentFullTest() throws EntityNotFoundException {
        when(serviceStudent.getStudentById(any(Integer.class))).thenReturn((student));
        assertNotNull(controller.searchByStudentId(1,"full"));
    }
}
