package example.estructurada;

import java.util.Scanner;

public class E016PrecioRebajado {
        // precio de transporte
        // con compra mínima de 30 euros, transporte gratis
        // con compra mínima de 100€, 15% descuento
    public static void main(String[] args) {
        final float TRANSPORTE = 5;
        final float DESCUENTO = 0.15f;
        final float COMPRA_MIN = 30;
        final float COMPRA_MIN_DESCUENTO = 100;
        Scanner input = new Scanner (System.in);
        System.out.println("¿Cual es el precio de la compra?");
        float precio = input.nextFloat();
        input.nextLine();
        if(precio < COMPRA_MIN){
            precio += TRANSPORTE;
        } else if(precio >= COMPRA_MIN_DESCUENTO){
            precio = precio - precio * DESCUENTO;
        }
        
        System.out.println("El precio final de la compra es " + precio + " euros.");
    }
    
}
