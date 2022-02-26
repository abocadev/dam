package dev.boca.ficheros;

import java.io.File;
import java.util.Scanner;

public class E009tryCatch {
    public static void main(String[] args) {
        E009tryCatch programa = new E009tryCatch();
        programa.inicio();
    }

    public void inicio(){
        try {
            // bloque try
            // Intentamos abrir un fichero
            File f = new File("C:/Temp/doc.txt");
            Scanner entrada = new Scanner(f);
            System.out.println("Fichero abierto correctamente");
        } catch (Exception e) {
            // bloque catch
            // excepcion en algun lugar del try
            System.out.println("Error: " + e);
        }

        System.out.println("Finalizacion del programa");
    }
}