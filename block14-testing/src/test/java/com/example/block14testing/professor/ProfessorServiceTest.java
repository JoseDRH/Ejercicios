package com.example.block14testing.professor;

import com.example.block14testing.Application.Exceptions.EntityNotFoundException;
import com.example.block14testing.Application.Person.Person;
import com.example.block14testing.Application.Profesor.Crud.RepositoryProfesor;
import com.example.block14testing.Application.Profesor.Crud.ServiceProfesor;
import com.example.block14testing.Application.Profesor.Profesor;
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
public class ProfessorServiceTest {

    @Mock
    private RepositoryProfesor repository;

    @InjectMocks
    private ServiceProfesor service;

    private Profesor profesor;

    @BeforeEach
    void crearAChuchi(){
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
        profesor= Profesor.builder()
                .id_profesor(1)
                .persona(person)
                .coments("He programado una reunión")
                .rama("Backend")
                .build();
    }

    @Test
    @Order(1)
    void saveTest(){
        when(repository.save(any(Profesor.class))).thenReturn(profesor);
        Assertions.assertNotNull(service.saveProfesor(profesor));
    }
    @Test
    @Order(2)
    void getTest() throws EntityNotFoundException {
        when(repository.findById(any(Integer.class))).thenReturn(Optional.ofNullable(profesor));
        Assertions.assertNotNull(service.getProfesorbyId(1));
    }
    @Test
    @Order(3)
    void getExceptionTest(){
        assertThatExceptionOfType(EntityNotFoundException.class)
                .isThrownBy(()->service.getProfesorbyId(1));
    }
    @Test
    @Order(4)
    void getAllTest(){
        when(repository.findAll()).thenReturn(Arrays.asList(profesor));
        Assertions.assertNotNull(service.getAllProfesor());
    }
    @Test
    @Order(5)
    void deleteTest() throws EntityNotFoundException {
        Profesor p=new Profesor();
        when(repository.findById(any(Integer.class))).thenReturn(Optional.of(p));
        service.deleteProfesor(1);
        verify(repository).findById(1);
    }
    @Test
    @Order(6)
    void deleteExceptionTest(){
        assertThatExceptionOfType(EntityNotFoundException.class)
                .isThrownBy(()->service.deleteProfesor(1));
    }
}

