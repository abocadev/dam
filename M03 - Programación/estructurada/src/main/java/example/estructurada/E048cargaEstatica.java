package example.estructurada;

import java.util.Scanner;

public class E048cargaEstatica {
    public static void main(String[] args) {
        Scanner entrada  = new Scanner(System.in);
        System.out.println("¿Cuantos elementos tiene el array?");
        int numElementos = entrada.nextInt();
        
        // declarar y crear el array
        String cosas [] = new String[numElementos];
        
        // inicializar el array
        for(int i = 0; i < cosas.length; i++){
            System.out.println("Introduce el valor del elemento" + (i+1) +":");
            cosas[i] = entrada.next();
        }
        
        // imprimir los elementos
        System.out.println("Cosas contiene:");
        for(int i = 0; i<cosas.length;i++){
            System.out.println(cosas[i]);
        }
    }
    
}
