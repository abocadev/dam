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
            File f = new File("D:/fichero.txt");
            Scanner lectura = new Scanner(f);
            // Si se ejecuta, se ha abierto el fichero
            int contador=0;
            for(int i = 0; i<10;i++){
                int valor  = lectura.nextInt();
                if(valor == 1){
                    contador++;
                }
                System.out.println("El valor cerrado es: " + valor);
            }
            System.out.println("El contador es igual a: " + contador);
            lectura.close();
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }
    
}
