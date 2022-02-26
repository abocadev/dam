package example.estructurada;

import java.util.Scanner;

public class E40cuentaA {
    public static void main(String[] args) {
        // contar cuántas palabras tienen la letra "a"
        int contador = 0;
        // arg es un array
        // lo que hemos introducido en args son los elementos del array
        for(int i = 0; i <args.length; i++){
            // comprobar si hay alguna "a" en la iteración
            if(-1 != args[i].indexOf("a")){
                contador++;
            }
        }
        System.out.println("Hay " + contador + " argumentos con la letra a");
    }
    
}
