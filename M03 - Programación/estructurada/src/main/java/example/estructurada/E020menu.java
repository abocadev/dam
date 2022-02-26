package example.estructurada;

import java.util.Scanner;

public class E020menu {
    public static void main(String[] args) {
        Scanner input = new Scanner (System.in);
        System.out.println("Selecciona una opción: \nOpcion 1 \n Opcion 2 \nOpcion3");
        int seleccion = input.nextInt();
        switch(seleccion){
            case 1:
                System.out.println("Seleccionaste uno");
            case 2:
                System.out.println("Seleccionaste dos");
            case 3:
                System.out.println("Seleccionaste tres");
                
            default:
                System.out.println("Esa opción no existe");
                break;
        }
    }
    
}
