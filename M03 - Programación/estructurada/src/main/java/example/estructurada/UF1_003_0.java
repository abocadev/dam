package example.estructurada;

import java.util.Scanner;

public class UF1_003_0 {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        System.out.println("Introduce grados centigrados: ");
        int C = entrada.nextInt();
        int F = 32 + (9 * C / 5);
        System.out.println(C + "ºC equivale a " + F + "ºF");
        
    }
    
}
