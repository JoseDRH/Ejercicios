package com.example.block14testing.professor;

import com.example.block14testing.Application.Exceptions.EntityNotFoundException;
import com.example.block14testing.Application.Exceptions.UnprocessableEntityException;
import com.example.block14testing.Application.Person.Person;
import com.example.block14testing.Application.Profesor.Controller.ControllersProfesor;
import com.example.block14testing.Application.Profesor.Crud.RepositoryProfesor;
import com.example.block14testing.Application.Profesor.Crud.ServiceProfesor;
import com.example.block14testing.Application.Profesor.Profesor;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.*;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Arrays;
import java.util.Date;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@DataJpaTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ProfessorControllerTest {


    @Mock
    private RepositoryProfesor repositoryProfesor;

    @Mock
    private ServiceProfesor serviceProfesor;
    @InjectMocks
    private ControllersProfesor controllers;

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
        profesor=Profesor.builder()
                .id_profesor(1)
                .persona(person)
                .coments("He programado una reunión")
                .rama("Backend")
                .build();
    }
    @Test
    @Order(1)
    void saveProfesorTest() throws UnprocessableEntityException {
        when(serviceProfesor.saveProfesor(any(Profesor.class))).thenReturn(profesor);
        assertNotNull(controllers.add(profesor));
    }
    @Test
    @Order(2)
    void getProfesorTest() throws EntityNotFoundException {
        when(serviceProfesor.getProfesorbyId(any(Integer.class))).thenReturn(profesor);
        assertNotNull(controllers.searchProfesorById(1));
    }
    @Test
    @Order(3)
    void getProfesoradoTest(){
        when(serviceProfesor.getAllProfesor()).thenReturn(Arrays.asList(profesor));
        assertNotNull(controllers.seeAll());
    }
    @Test
    @Order(4)
    void getProfessorExceptionTest() throws EntityNotFoundException {
        when(serviceProfesor.getProfesorbyId(any(Integer.class))).thenThrow(EntityNotFoundException.class);
        Assertions.assertThatExceptionOfType(EntityNotFoundException.class)
                .isThrownBy(() ->controllers.searchProfesorById(2));
    }
    @Test
    @Order(5)
    void deleteProfessorTest() throws EntityNotFoundException {
        Profesor pro=new Profesor();
        when(serviceProfesor.getProfesorbyId(any(Integer.class))).thenReturn(pro);
        controllers.delete(1);
        verify(serviceProfesor).deleteProfesor(1);
    }
    @Test
    @Order(6)
    void setToDTOTest(){
        Assertions.assertThat(profesor.setToDTO().getRama().equals("Backend"));
    }
    @Test
    @Order(7)
    void setToSimpleTest(){
        Assertions.assertThat(profesor.setToSimpleDTO().getRama().equals("Backend"));
    }
    @Test
    @Order(8)
    void deleteExceptionTest() throws EntityNotFoundException {
        when(controllers.delete(any(Integer.class))).thenThrow(EntityNotFoundException.class);
        Assertions.assertThatExceptionOfType(EntityNotFoundException.class)
                .isThrownBy(() -> controllers.delete(2));
    }
    @Test
    @Order(9)
    void professorValidationTest(){
        Assertions.assertThatExceptionOfType(UnprocessableEntityException.class)
                .isThrownBy(()-> new Profesor().validacion()).withMessage(null);
    }
    @Test
    @Order(10)
    void saveExceptionTest(){
        assertThatExceptionOfType(UnprocessableEntityException.class)
                .isThrownBy(()-> controllers.add(new Profesor()));
    }
    @Test
    @Order(11)
    void updateTest() throws UnprocessableEntityException {
        when(serviceProfesor.saveProfesor(any(Profesor.class))).thenReturn(profesor);
        assertNotNull(controllers.update(profesor));
    }
    @Test
    @Order(12)
    void updateExceptionTest(){

        assertThatExceptionOfType(UnprocessableEntityException.class)
                .isThrownBy(()-> controllers.update(new Profesor()));
    }

}
