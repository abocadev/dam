
package example.estructurada;

import java.util.Scanner;

public class E006Entrada {

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        System.out.println("Escribe tu nombre: ");
        String nombre = entrada.next();
        System.out.println("Tu nombre es " + nombre);
        
        System.out.println("Escribe tu edad: ");
        int edad = entrada.nextInt();
        System.out.println("Tienes " + edad + " años.");
        
        if(edad <= 18){
            System.out.println("Eres mayor de edad");
        } else{
            System.out.println("Eres menor de edad.");
        }
    }
    
}
