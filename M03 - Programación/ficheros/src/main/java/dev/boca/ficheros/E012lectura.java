package dev.boca.ficheros;

import java.io.File;
import java.util.Scanner;

public class E012lectura {
    public static void main(String[] args) {
        E012lectura programa = new E012lectura();
        programa.inicio();
    }
    
    public void inicio(){
        try {
            // intentamos abrir un fichero
            File f = new File("C://Temp//doc.txt");
            Scanner lectura = new Scanner(f);
            // Si se ejecuta, se ha abierto el fichero
            for(int i = 0; i<10;i++){
                int valor  = lectura.nextInt();
                System.out.println("El valor cerrado es: " + valor);
            }
            lectura.close();
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }
    
}
