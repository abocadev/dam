package dev.boca.poo;

import java.util.Scanner;

public class AlumnoMain {
    public static void main(String[] args) {
        Alumno[] alumnos = new Alumno[5];
        double sumaNotas = 0;
        Scanner entrada = new Scanner(System.in);
        System.out.println("Nombre y nota media de los alumnos:");
        for(int i = 0; i<5;i++){
            alumnos[i] = new Alumno();
            System.out.println("Alumno " + (i+1));
            System.out.println("Nombre: ");
            String nombreTeclado = entrada.next();
            alumnos[i].setNombre(nombreTeclado);
            System.out.println("Nota media: ");
            double notaTeclado = entrada.nextDouble();
            alumnos[i].setNotaMedia(notaTeclado);
        }
        
        System.out.println("Los datos introducidos son: ");
        
        for (int i = 0; i < 5; i++) {   
            System.out.println("Alumno: " + (i+1));
            System.out.println("Nombre: " + alumnos[i].getNombre());
            System.out.println("Nota media: " + alumnos[i].getNotaMedia());
            System.out.println("*************************************************");
            
            sumaNotas += alumnos[i].getNotaMedia();
            
        }
        System.out.println("La media de la clase es " +sumaNotas/5);
    }
}