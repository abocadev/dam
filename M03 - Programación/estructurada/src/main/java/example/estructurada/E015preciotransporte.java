package example.estructurada;

import java.util.Scanner;

public class E015preciotransporte {
    public static void main(String[] args) {
        // declar como constante el precio del transporte
        final float TRANSPORTE = 5;
        final float COMPRA_MIN = 30;

        // declaro objeto scanner;
        Scanner input = new Scanner (System.in);
        
        // conseguir los valores
        System.out.println("¿Cuál es el valor de la compra?");
        float precio = input.nextFloat();
        
        // evaluación
        // si valua true, ejecuta el bloque de codigo
        // si evalua false, lo ignora
        if(precio < COMPRA_MIN){
            precio += TRANSPORTE;
        }
        System.out.println("El precio final es " + precio + " euros");
        
    }
    
}
