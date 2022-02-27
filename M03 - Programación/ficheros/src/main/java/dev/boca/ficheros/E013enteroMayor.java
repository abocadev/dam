package dev.boca.ficheros;

import java.io.File;
import java.util.Scanner;

public class E013enteroMayor {
    public static void main(String[] args) {
        E013enteroMayor programa = new E013enteroMayor();
        programa.inicio();
    }
    
    public void inicio(){
        Scanner lectura = null;
        try {
            // intentamos abrir el fichero
            File f = new File("D:/fichero.txt");
            lectura = new Scanner(f);
            
            int max = lectura.nextInt();
            for(int i = 1; i < 10; i++){
                int valor = lectura.nextInt();
                if(max<valor){
                    max = valor;
                }
            }
            System.out.println("El mayor de los valores es " + max);
        } catch (Exception e) {
            
        }
    }
}
