package dev.boca.poo;
public class Perro {
    // atributo
    private String nombre;
    private String color;
    private String raza;
    
    // constructor

    public Perro(String nombre, String color, String raza) {
        this.nombre = nombre;
        this.color = color;
        this.raza = raza;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }   
    
    public String getColor() {
        return color;
    }

    public String getRaza() {
        return raza;
    }
    
    
}
