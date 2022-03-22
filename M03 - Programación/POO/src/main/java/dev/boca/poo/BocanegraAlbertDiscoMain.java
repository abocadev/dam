package dev.boca.poo;

import java.util.ArrayList;
import java.util.Scanner;

public class BocanegraAlbertDiscoMain {
    public static void main(String[] args) {
        BocanegraAlbertDisco programaClass = new BocanegraAlbertDisco(0);
        
        Scanner entrada = new Scanner(System.in);
        System.out.println("************************************************");
        System.out.println("ELIGE UNA OPCION:");
        System.out.println("    [1] Listar discos.");
        System.out.println("    [2] Introducir disco.");
        System.out.println("    [3] Borrar disco.");
        System.out.println("    [4] Salir");
        System.out.println("\nEn total tienes " + programaClass.getTotalDiscos() + " disco(s).");
        System.out.println("************************************************");
        System.out.println("INSERTA UNA OPCION: ");
        
        if(!(entrada.hasNextInt())){
            entrada.nextLine();
            System.out.println("El valor que has insertado no es un numero entero.");
            main(null);
        }else{
            programaClass = new BocanegraAlbertDisco(entrada.nextInt());
        }
        
        programaClass.escogerOpcion();
    }
}