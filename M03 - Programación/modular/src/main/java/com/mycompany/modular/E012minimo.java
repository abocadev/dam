package com.mycompany.modular;
public class E012minimo {
    public static void main(String[] args) {
        E012minimo programa = new E012minimo();
        programa.inicio();
    }
    
    public void inicio(){
        int resultado = minimo(20, 30);
        System.out.println("El resultado es: " + resultado);
    }
    
    // entrada --> los dos int
    // salida --> el int menor
    
    public int minimo(int a, int b){
        // a y b contiene klos valores a tratar
        int min = b;
        if(a<b){
            min = a;
        }

        // el resultado esta en "min"
        return min;
    }
    
}