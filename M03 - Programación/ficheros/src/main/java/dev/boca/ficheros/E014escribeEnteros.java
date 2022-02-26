package dev.boca.ficheros;

import java.io.File;
import java.io.PrintStream;

public class E014escribeEnteros {
    public static void main(String[] args) {
        E014escribeEnteros programa = new E014escribeEnteros();
        programa.inicio();
    }
    
    public void inicio(){
        try {
            // intentamos abrir el fichero
            File f = new File("C://Temp//Enteros.txt");
            PrintStream escribe = new PrintStream(f);
            // escribimos el primer valor
            int valor = 1;
            escribe.println(valor);
            for(int i = 1; i<20; i++){
                // escribir espacio en blanco
                escribe.print(" ");
                // calcular el siguiente
                valor = valor * 2;
                escribe.print(valor);
            }
            escribe.close();
            System.out.println("Fichero escrito correctamente");
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }
}
