package com.mycompany.modular;

import java.util.Scanner;

public class E011salida{
    public static void main(String[] args){
        E011salida programa = new E011salida();
        programa.inicio();
    }

    public void inicio(){
        System.out.println("Escribe un numero entero:");
        int a = leerNumero();
        System.out.println("Has introducido " + a + ".");
        System.out.println("Introduce otro numero:");
        a = leerNumero();
        System.out.println("Has introducido " + a + ".");
    }

    // metodo que lee un entero desde el teclado
    // parametro entrada -> nope
    // parametro salida -> int
    public int leerNumero(){
        Scanner entrada = new Scanner (System.in);
        int numLeido = 0;
        boolean leido = false;
        while(!leido){
            leido = entrada.hasNextInt();
            if(leido){
                numLeido = entrada.nextInt();
            }else{
                System.out.println("Esto nmo es un numero leido");
                entrada.next();
            }
            entrada.nextLine();
        }
        return numLeido;
    }
}