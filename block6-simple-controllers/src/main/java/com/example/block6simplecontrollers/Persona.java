package com.example.block6simplecontrollers;



public class Persona   {

    private String name;
    private String ciudad;
    private Integer edad;
    public Persona(String name, String ciudad, Integer edad) {
        this.name = name;
        this.ciudad = ciudad;
        this.edad = edad+1;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getCiudad() {
        return ciudad;
    }
    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }
    public Integer getEdad() {
        return edad;
    }
    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    @Override
    public String toString() {
        return "Nombre: "+getName()+" Ciudad:"+" Edad:"+getEdad();
    }
}
