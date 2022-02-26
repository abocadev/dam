package example.estructurada;

import java.util.Scanner;

public class E009Scanner2 {
    public static void main(String[] args) {
        // Creamos un objeto escaner
        Scanner entrada = new Scanner (System.in);
        // Declaramos las variables
        String  nombre, direccion;
        int edad;
        // Pedimos el nombre al usuario
        System.out.println("Introduce tu nombre:");
        // leemos el nombre desde el buffer
        nombre = entrada.nextLine();
        //pedimos edad al usuario
        System.out.println("Escribe tu edad: ");
        edad = entrada.nextInt();
        // limpiamos buffer > aplicar el método sin asignar el valor a ninguna variable.
        entrada.nextLine();
        // pedimos direccion al usuario
        System.out.println("Escibre tu direccion: ");
        direccion = entrada.nextLine();
        // imprimos toda las eddades
        System.out.println("Tu nombre es " + nombre);
        System.out.println("Tu edad es " + edad);
        System.out.println("Tu dirección es " + direccion);
        
    }
    
}
