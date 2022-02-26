package dev.boca.ficheros;

import java.io.File;
import java.util.Scanner;

public class E007textoTeclado {
    Scanner entrada = new Scanner(System.in);
    public static void main(String[] args) {
        E007textoTeclado programa = new E007textoTeclado();
        programa.inicio();
    }
    
    public void inicio(){
        File archivo1 = new File("C:/Temp/doc1.txt");
        File archivo2 = new File("C:/Temp/doc2.txt");

        System.out.println("Vamos a cambiar el nombre del Fichero doc1.txt, Introduce un nuevo nombre para el fichero con formato 'txt':");
        String nuevoNombre = entrada.next();
        File arcCambiado1  = new File("C:/Temp/" + nuevoNombre  + ".txt");
        
        boolean resultado = archivo1.renameTo(arcCambiado1);
        System.out.println("Archivo de la carpeta cambiado? " + resultado);
        
        System.out.println("Vamos a cambiar el nombre del Fichero doc2.txt, Introduce un nuevo nombre para el fichero, le tienes que poner tu la extension:");
        nuevoNombre = entrada.next();
        File arcCambiado2 = new File("C:/Temp/" + nuevoNombre);
        
        resultado = archivo2.renameTo(arcCambiado2);
        System.out.println("Archivo de la carpeta cambiado? " + resultado);
    }
    
}
