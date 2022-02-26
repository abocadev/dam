
package example.estructurada;

import java.util.Scanner;

public class E044substring {

    public static void main(String[] args) {
        Scanner entrada = new Scanner (System.in);
        System.out.println("Introduce un frase:");
        String frase = entrada.nextLine();
        
        // Buscamos el primer y el último espacios en blanco
        int inicioSubstring = frase.indexOf(' ');
        int finSubstring = frase.lastIndexOf(' ');
        
        System.out.println("La frae sin la primera ni la ultima es:");
        
        if(inicioSubstring == finSubstring){
            // no hay espacios, evalúa -1
            // solo hay dos palabras, evalúa a la misma posición
            // No se muestra nada
        } else{
            // Hay que mostrar una cadena intermedia
            // La segunda palabra empieza tras un espacio en blanco
            String fraseFinal = frase.substring(inicioSubstring + 1, finSubstring);
            System.out.println(fraseFinal);
        }
    }
    
}
