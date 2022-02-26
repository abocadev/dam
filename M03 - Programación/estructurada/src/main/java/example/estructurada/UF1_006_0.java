package example.estructurada;

import java.util.Scanner;

public class UF1_006_0 {
    public static void main(String[] args) {
        Scanner input = new Scanner (System.in);
        System.out.println("Inserta un numero: ");
        int num = input.nextInt();
        if(num >= 0){
            System.out.println("El numero " + num + " es positivo.");
        } else{
            System.out.println("El numero " + num + " es negativo.");
        }
        
        if(num%2 == 0){
            System.out.println("El numero " + num + " es par.");
        } else{
            System.out.println("El numero " + num + " es impar.");
        }
        
        if(num%5 == 0){
            System.out.println("El numero " + num + " es multiplo de 5.");
        } else{
            System.out.println("El numero " + num + " no es multiplo de 5.");
        }
        
        if(num%10 == 0){
            System.out.println("El numero " + num + " es multiplo de 10.");
        } else{
            System.out.println("El numero " + num + " no es multiplo de 10.");
        }
        
        if(num < 100){
            System.out.println("El numero " + num + " es menor que 100.");
        } else if(num == 100){
            System.out.println("El numero " + num + " es igual a 100.");
        } else{
            System.out.println("El numero " + num + " es mayor que 100.");
        }
    }
    
}
