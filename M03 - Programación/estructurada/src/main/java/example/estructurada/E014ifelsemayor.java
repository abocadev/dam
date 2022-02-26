package example.estructurada;

import java.util.Scanner;

public class E014ifelsemayor {
    public static void main(String[] args) {
    Scanner input = new Scanner (System.in);
    int num1, num2;
    System.out.println("Introduce un número");
    num1 = input.nextInt();
    System.out.println("Introduce un número");
    num2 = input.nextInt();
    
    // evaluación
    if (num1 > num2){
        System.out.println(num1 + " es mayor que " + num2);
        System.out.println(num2 + " es menor que " + num1);

    } else{
        System.out.println(num2 + " es mayor que " + num1);
        System.out.println(num1 + " es menor que " + num2);
    }
    
        System.out.println("Fin del programa.");
    }
    
}
