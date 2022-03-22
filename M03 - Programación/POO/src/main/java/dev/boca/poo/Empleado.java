package dev.boca.poo;

public class Empleado {

    private int edad;

    private String nombre;

    public void setEdad(int edad) {
        if (edad > 15 && edad < 66) {
            this.edad = edad;
        } else {
            System.out.println("Con esa edad no se puede trabajar");
        }
    }

    public int getEdad(){
        return edad;
    }
    
   
    public String getNombre(){
        return nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

}
