package example.estructurada;

import java.util.Scanner;

public class UF1_009_0 {
    public static void main(String[] args) {
        Scanner input = new Scanner (System.in);
        System.out.println("Inserta las HORA:");
        if(input.hasNextInt()){
            int h = input.nextInt();
            System.out.println("Inserta los MINUTO:");
            int m = input.nextInt();
            System.out.println("Inserta los SEGUNDOS:");
            int s = input.nextInt();

            if (h >= 0 && h <= 24 && m >= 0 && m <= 60 && s >= 0 && s <= 60) {
                System.out.println(h + ":" + m + ":" + s);
                System.out.println("La HORA introducida es valida.");
            } else {
                System.out.println("La HORA introducida es erronea.");
            }
        } else{
            System.out.println("Esto no es un numero entero");
        }
    }
    
}
