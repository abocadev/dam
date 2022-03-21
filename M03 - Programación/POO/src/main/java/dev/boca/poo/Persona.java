package dev.boca.poo;

public class Persona {
    // en esta clase declararemos los atributos de las personas
    String nombre;
    int edad;

    // metodos

    // metodo constructor
    public Persona(String nombre, int edad){
        this.nombre = nombre;
        this.edad = edad;
    }

    public void imprimir(){
        System.out.println("Nombre:" + nombre);
        System.out.println("Edad: " + edad);
    }
}
