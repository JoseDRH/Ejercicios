package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {

    public static void leerDatos(String[] datos){
        int cantidad=datos.length;
        String respuesta="";
        boolean esstring=false;
        for (int i=0;i<cantidad;i++){
            if (datos[i].charAt(0)=='+' ) {
                if(datos[i-1].charAt(0)=='“'  && datos[i+1].charAt(0)=='“') {
                    esstring=true;
                    respuesta = respuesta + " " + datos[i - 1].substring(1, datos[i - 1].length() - 1) + " " + datos[i + 1].substring(1, datos[i + 1].length() - 1);
                }
                else {
                    respuesta=String.valueOf(Integer.parseInt(datos[i-1])+Integer.parseInt(datos[i+1]));
                }
                i = i + 2;
            }
            else if (datos[i].charAt(0)=='-') {
                respuesta=String.valueOf(Integer.parseInt(datos[i-1])-Integer.parseInt(datos[i+1]));
            }
            else if (datos[i].charAt(0)=='*' ) {
                if( datos[i-1].charAt(0)=='“' && datos[i+1].charAt(0)!='“') {
                    esstring=true;
                    for (int e = 0; e < Integer.parseInt(datos[i + 1]); e++) {
                        respuesta = respuesta + " " + datos[i - 1].substring(1, datos[i - 1].length() - 1);
                    }
                }
                else  respuesta=String.valueOf(Integer.parseInt(datos[i-1])*Integer.parseInt(datos[i+1]));
            }
            else if (datos[i].charAt(0)=='/') {
                respuesta=String.valueOf(Integer.parseInt(datos[i-1])/Integer.parseInt(datos[i+1]));
            }
        }
        if(esstring) System.out.println('"'+respuesta+'"');
        else System.out.println(respuesta);
    }

    public static void main(String[] args) {

        try {
            Path ruta = Paths.get("src/main/Archivos/Archivo.txt");
            BufferedReader reader = Files.newBufferedReader(ruta);
            while (reader.ready()){
                String linea= reader.readLine();
                String[] datos=linea.split(" ");
                leerDatos(datos);
            }
            reader.close();
        } catch (IOException e) {e.printStackTrace();}
    }
}