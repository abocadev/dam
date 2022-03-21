package dev.boca.poo;
public class primo {
    // atributos
    private int edad;
    private final String nombre;
    
    public primo(int edad, String nombre){
        this.edad = edad;
        this.nombre = nombre;
    }
    
    // metodo imprimir datos
    public void imprimir(){
        System.out.println("Mi primo se llama: " + nombre + ", ");
        System.out.println("tiene " + edad + " años");
    }
    
    // hay que modificar la edad del primo, ya que no tiene 23
    // para modificar la edad utilizaremos edad.

    public int getEdad(){
        return edad;
    }
    
    public void setEdad(int edad){
        this.edad = edad;
    }
}
