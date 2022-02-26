package example.estructurada;

import java.util.Scanner;

public class UF1_023 {
    public static void main(String[] args) {
        Scanner entrada = new Scanner (System.in);
        int TAM = 10;
        int nums[] = new int[TAM];
        for(int i = 0; i <TAM; i++){
            System.out.println("Introduce un numero:");
            nums[i] = entrada.nextInt();
        }
        for (int i = TAM-1; i >= 0; i--){
            System.out.println(nums[i]);
        }
    }
}