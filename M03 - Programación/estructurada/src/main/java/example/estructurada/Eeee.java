package example.estructurada;

import java.util.Scanner;

public class Eeee {
    public static void main(String[] args) {
        final int VIDAS = 5;
        Scanner entrada = new Scanner(System.in);
        System.out.println("Introduce la palabra secreta:");
        String palabra = entrada.next().toUpperCase();

        int intentos = VIDAS;
        int aciertos = 0;
        char actual[] = new char[palabra.length()];
        for (int i = 0; i < actual.length; i++) {
            actual[i] = '_';
        }

        boolean fin = false;
        do {
            System.out.println("¿Qué letra?. Tienes " + intentos + " intentos");
            char letra = entrada.next().toUpperCase().charAt(0);
            boolean win = false;
            for (int i = 0; i < palabra.length(); i++) {
                if ((palabra.charAt(i) == letra) && (actual[i] == '_')) {
                    actual[i] = letra;
                    aciertos++;
                    win = true;
                }
                System.out.println(actual[i] + " ");
            }
            System.out.println();
            if (!win) {
                intentos--;
            }
            
            if(aciertos==palabra.length()){
                System.out.println("Ganaste!");
                fin = true;
            }else{
                System.out.println("¡Has fallado la letra!");
            }
            
            if(intentos<=0){
                fin = true;
                System.out.println("Game Over");
            }
        }while(!fin);

    }
    
}
