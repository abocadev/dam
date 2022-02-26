package example.estructurada;

import java.util.Scanner;

public class UF1_008_0 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Inserta un numero:");
        int num1 = input.nextInt();
        System.out.println("Inserta otro numero:");
        int num2 = input.nextInt();
        System.out.println("Inserta otro numero:");
        int num3 = input.nextInt();
        if (num1> num2 && num1>num3){
            System.out.println("El numero " + num1 + " es mayor que el resto.");
        } else if(num2>num1 && num2>num3){
            System.out.println("El numero " + num2 + " es mayor que el resto.");
        } else if(num3>num1 && num3>num2){
            System.out.println("El numero " + num3 + " es mayor que el resto");
        }else if(num1  == num2&& num2 == num3){
            System.out.println("Has repetido tres veces el numero " + num1);
        }else{
            System.out.println("¡ERROR!");
        }
    }
    
}
