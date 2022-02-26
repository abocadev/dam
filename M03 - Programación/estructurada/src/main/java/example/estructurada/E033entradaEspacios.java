package example.estructurada;

import java.util.Scanner;

public class E033entradaEspacios {

    public static void main(String[] args) {
        final int TAM = 10;
        Scanner input = new Scanner (System.in); 
        System.out.println("Introduce " + TAM + " numeros enteros");
        // Datos introducidos en la misma linea separados por espacios
        
        // Contador d valores
        int contador = 1;
        while(contador < TAM + 1){
            // Antes de leer, validamos si hay un entero en el buffer
            if(input.hasNextInt()){
                int valor = input.nextInt();
                System.out.println("Valor " + contador + " leido: " + valor);
                contador++;
            } else{
                // No hay un entero en el buffer
                // Se ignora y el contador no avanza
                input.next();                
            }
        }
        
        // Si hay mas valores, se descartan
        input.nextLine();
        System.out.println("Ya se han leido " + TAM + " valores");
    }
    
}
