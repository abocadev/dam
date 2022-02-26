package example.estructurada;

import java.util.Scanner;

public class UF1_007_0 {
    public static void main(String[] args) {
        Scanner input = new Scanner (System.in);
        System.out.println("Inserta el primer numero:");
        int dividendo = input.nextInt();
        System.out.println("Inserta el segundo numero:");
        int divisor = input.nextInt();
        if (divisor != 0 && dividendo != 0){   
            int resultado1 = dividendo / divisor;
            int resultado2 = dividendo % divisor;
            System.out.println(dividendo + "/" + divisor + " = " + resultado1);
            System.out.println("El residuo = " + resultado2);   
        } else{
            System.out.println("El divisor es 0.");
        }
    }
    
}
