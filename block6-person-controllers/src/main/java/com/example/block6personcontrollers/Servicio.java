package com.example.block6personcontrollers;

import ClasesObjeto.Ciudad;
import ClasesObjeto.Persona;

import java.util.ArrayList;
import java.util.List;

public class Servicio {

    static public List<Persona> personas=new ArrayList<>();
    static public List<Ciudad> ciudades=new ArrayList<>();

    static String controlador1Persona(String nombre,String ciudad,int edad){
        Persona persona =new Persona(nombre,ciudad,edad);
        personas.add(persona);
        return persona.toString();
    }
    static String controlador2Persona(){
        int ultimaPersona=personas.size()-1;
        Persona edadx2=new Persona(personas.get(ultimaPersona).getNombre(),
                personas.get(ultimaPersona).getCiudad(),
                (personas.get(ultimaPersona).getEdad()*2));
        return edadx2.toString();
    }

    static String controlador1Ciudad(String nombre,int numHabitantes){
        Ciudad ciudad=new Ciudad(nombre,numHabitantes);
        ciudades.add(ciudad);
        return ciudad.toString();
    }

    static String controlador2Ciudad(){
        String listaCiudades="";
        for (Ciudad c:
             ciudades) {
            listaCiudades=listaCiudades+c.toString()+"\n";
        }

        return listaCiudades;
    }
}
