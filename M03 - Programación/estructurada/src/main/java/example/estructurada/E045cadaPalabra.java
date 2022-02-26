package example.estructurada;

import java.util.Scanner;

public class E045cadaPalabra {

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        System.out.println("Introduce una frase:");
        String frase = entrada.nextLine();
        boolean fin = false;
        
        // bucle que acorte una palabra a cada interación
        do{
            // La primera palabra va desde el inicio el primer espacio en blanco
            int primerEspacio = frase.indexOf(' ');
            // Si no hay espacios, solo hay una palabra
            if(primerEspacio == -1){
                System.out.println(frase);
                fin = true;
            } else{
                String palabra = frase.substring(0, primerEspacio);
                System.out.println(palabra);
                frase = frase.substring(primerEspacio+1, frase.length());
                // Eliminar la palabra que ya he impreso
            }
        }while(!fin);
        
        /*
        String[] palabras = frase.split(" ");
        for(int i = 0; i<palabras.length; i++){
            System.out.println(palabras[i]);
        }*/
        
      
    }
    
}
