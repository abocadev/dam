package example.estructurada;

import java.util.Scanner;

public class UF1_000_0 {
    public static void main(String[] args) {
        // Llamamos al método Scanner y le damos nombre de "entrada"
        Scanner entrada = new Scanner(System.in);
        // Le decimos que introduzca un numero
        System.out.println("Introduce un número: ");
        int x = entrada.nextInt();
        // Le decimos que introduzca otro numero        
        System.out.println("Introduce otro número: ");
        int y = entrada.nextInt();
        // Imprimos otro número
        System.out.println("Has introducido los números " + x + " y " + y);
    }    
}
