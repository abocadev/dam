package example.estructurada;

import java.util.Scanner;

public class UF1_002_0 {
    public static void main(String[] args) {
        // Llamamos al método Scanner
        Scanner entrada = new Scanner (System.in);
        // Le pedimos que introduzca un número
        System.out.println("Introduce un número: ");
        int num = entrada.nextInt();
        // Le decimos que imprima los números
        System.out.println("El doble de " + num + " es " + num*2);
        System.out.println("El triple de " + num + " es " + num*3);

    }
    
}
