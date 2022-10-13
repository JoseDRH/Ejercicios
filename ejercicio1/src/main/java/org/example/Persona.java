package org.example;


import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class Persona {

    static List<Persona> personas= new ArrayList<>();
    private String nombre;
    private Optional<String> ciudad ;
    private int edad;

    //Constructor que recibe los datos en un unico String
    public Persona(String linea) throws InvalidFormatLineException{
        //Se crea un array con los 3 datos con la funcion split y el String recibido
        try {
        String[] datos= linea.split(",");
        if(!datos[0].equals("")) {
            this.nombre=datos[0];
            if(datos[1].isEmpty()) this.ciudad=Optional.ofNullable(null);
            else this.ciudad=Optional.ofNullable(datos[1]);
            if(datos[2]==null) this.edad=0;
            else  this.edad=Integer.parseInt(datos[2]);
        }
        else {
            throw  new InvalidFormatLineException("Debe introducir un valor en el campo de nombre obligatoriamente \n Error en la linea "+(personas.size()+1));
        }


        }
        //Ya que la edad es el ultimo campo, en ocacsiones esta vacio y no se incluira en el array
        //Por lo que dara un error de IndexOutofBOunds por lo que se crea un control de errores para asginar un valor de 0 en estos casos
        catch (ArrayIndexOutOfBoundsException e){this.edad=0;}
        // En este control comprobamos si se a insertado un valor no numerico para avisar del error y cambiarlo a 0
        catch (NumberFormatException e){this.edad=0; System.err.println("La edad debe ser determinada por una valor numerico");
            //Ya que este error solo se producira en la creacion de la lista inicial podemos determinar
            //La posicion de la linea con el error por el tamaño de la lista
        System.err.println("Error en la linea "+(personas.size()+1)+" del archivo");}

    }
    static void extraerDatos(Path ruta){
        try {
            //Vaciamos la lista para evitar insertar mas de una vez los datos en la lista
            personas.clear();
            BufferedReader reader= Files.newBufferedReader(ruta);

            while (reader.ready()){
                String linea =reader.readLine();

                try {
                    personas.add(new Persona(linea));
                } catch (InvalidFormatLineException e) {
                    System.err.println(e);
                }
            }

        } catch (IOException e) {throw new RuntimeException(e);}
    }
    static Persona primeraCiudad(String filtro){
        Stream<Persona> flujo=personas.stream();
        Optional<Persona> filtrado= flujo.filter(p->p.getCiudad().equals(filtro)).findFirst();
        return filtrado.get();


    }

    static void mayorQue(int filtro){
        Stream<Persona> flujo= personas.stream();
        List<Persona> filtrado= new ArrayList<>();

        flujo.filter(p ->p.getEdad()>=filtro)
                .forEach(p ->filtrado.add(p));
        personas=filtrado;

    }
    static void menorQue(int filtro){
        Stream<Persona> flujo= personas.stream();
        List<Persona> filtrado= new ArrayList<>();

        flujo.filter(p ->p.getEdad()<=filtro && p.getEdad()>0)
                .forEach(p ->filtrado.add(p));
        personas=filtrado;
    }
    static void porNombre(String filtro){
        Stream<Persona> flujo= personas.stream();
        List<Persona> filtrado= new ArrayList<>();

        flujo.filter(p ->p.getNombre().equals(filtro))
                .forEach(p ->filtrado.add(p));
        personas=filtrado;
    }
    static void porInicial(char filtro){
        Stream<Persona> flujo= personas.stream();
        List<Persona> filtrado= new ArrayList<>();

        flujo.filter(p ->p.getNombre().charAt(0)==(filtro))
                .forEach(p ->filtrado.add(p));
        personas=filtrado;
    }
    static void eliminarPorInicial(char filtro){
        Stream<Persona> flujo= personas.stream();
        List<Persona> filtrado= new ArrayList<>();

        flujo.filter(p ->p.getNombre().charAt(0)!=(filtro))
                .forEach(p ->filtrado.add(p));
        personas=filtrado;
    }


    @Override
    public String toString() {
        return "Name:" + nombre +
                ". Town:" + ciudad.orElse("unknow") +
                ". Age:" + edad  ;
    }

    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    public String getCiudad() {
        return ciudad.orElse("unknow");
    }
}
