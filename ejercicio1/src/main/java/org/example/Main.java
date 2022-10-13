package org.example;

import java.nio.file.Path;
import java.nio.file.Paths;
public class Main {




    public static void main(String[] args) {

        //Ruta del archivo con los datos
        Path ruta= Paths.get("src/main/Archivos CSV/personas.csv");

        Persona.extraerDatos(ruta);
        Persona.menorQue(25);
        //Aparatado a)
        System.out.println("<\n\nApartado A:");
        for (Persona p:
            Persona.personas ) {
            System.out.println(p);
        }
        //Apartado c)
        System.out.println("\n\nApartado C: \n"+Persona.primeraCiudad("Madrid"));
        //Apartado d)
        System.out.println("\n\nApartado D: \n"+Persona.primeraCiudad("Madrid"));

        //Aparatado B
        System.out.println("<\n\nApartado B:");
        Persona.extraerDatos(ruta);
        Persona.eliminarPorInicial('A');
        for (Persona p :
                Persona.personas) {
            System.out.println(p);

        }


    }
}