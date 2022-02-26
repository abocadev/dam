package com.mycompany.modular;
public class E010string {
    public static void main(String[] args) {
        E010string programa = new E010string();
        programa.inicio();
    }
    
    public void inicio(){
        String i = "Hola";
        System.out.println("Antes de invocar el metodo \"i\" vale " + i);
        modificarString(i);
        System.out.println("Despues de invocar el metodo \"i\" vale " + i);
    }
    
    public void modificarString(String a){
        a = "Adios";
    }
    
}
