package com.mycompany.modular;
public class E008parametroValor {
    public static void main(String[] args) {
        E008parametroValor programa = new E008parametroValor();
        programa.inicio();
    }
    
    public void inicio(){
        int i = 10;
        System.out.println("Antes de invocar al metodo \"i\" vale " + i);
        modificar(i);
        System.out.println("Despues de invocar al metodo \"i\" vale " + i);
    }
    
    public void modificar(int x){
        x = 0;
        System.out.println("Se ha modificado el valor a " + x);
    }
    
}
