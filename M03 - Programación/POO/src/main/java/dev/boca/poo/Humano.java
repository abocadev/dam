package dev.boca.poo;

public class Humano {
    
    String nombre;
    int edad;
    String dni;

    public Humano(String nombre, int edad){
        this.nombre = nombre;
        this.edad = edad;
    }

    public Humano(String dni){
        this.dni = dni;
    }
    public void volar(){
        System.out.println("Nombre: " + nombre + ", edad: " + edad);
    }

    public void volar(int km){
        System.out.println("Dinstancia recorrida volando: " + km + "kilometros");
    }
}
