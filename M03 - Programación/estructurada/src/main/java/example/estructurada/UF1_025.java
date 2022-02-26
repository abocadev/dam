package example.estructurada;

import java.util.Scanner;

public class UF1_025 {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        int TAM = 10;
        int tabla1[] = new int[TAM];
        int tabla2[] = new int[TAM];
        String tablafinal[] = new String[TAM];
        int num;
        for(int i = 0; i < TAM; i++){
            System.out.println("Introduzca un numero:");
            num = entrada.nextInt();
            tabla1[i] = num;
            tabla2[i] = num;
        }
        for(int i = 0; i < TAM; i++){
            tablafinal[i] = tabla1[i] + "º de A, " + tabla2[i] + "º de B";
        }
        for(int i = 0; i <TAM; i++){
            System.out.println(tablafinal[i]);
        }
    }
    
}
