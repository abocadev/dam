package example.estructurada;
import java.util.Scanner;
public class E031Array {
    public static void main(String[] args) {
        // declaración array
        final int TAM = 5;
        int valores [] = new int[TAM];
        Scanner input = new Scanner (System.in);
        
        // inicializar el array -> asignación
        for(int i = 0; i<5; i++){
            System.out.println("Introduce un numero entero:");
            valores[i] = input.nextInt();
            // Imprimir los valores del array
            System.out.println("El elemento " + (i+1) + " vale " + valores[i]);
        }                
    }
    
}
