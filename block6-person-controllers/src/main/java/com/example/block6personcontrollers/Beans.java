package com.example.block6personcontrollers;

import ClasesObjeto.Persona;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Beans  {



    @Bean
    @Qualifier("bean1")
    public Persona bean1(){
        System.out.println("Bean1 creado");
        Persona persona=new Persona("bean1");
        Servicio.personas.add(persona);
        return  persona;
    }
    @Bean
    @Qualifier("bean2")
    public Persona bean2(){
        System.out.println("Bean2 creado");
        Persona persona=new Persona("bean2");
        Servicio.personas.add(persona);
        return  persona;
    }
    @Bean
    @Qualifier("bean3")
    public Persona bean3(){
        System.out.println("Bean3 creado");
        Persona persona=new Persona("bean3");
        Servicio.personas.add(persona);
        return  persona;
    }
}
