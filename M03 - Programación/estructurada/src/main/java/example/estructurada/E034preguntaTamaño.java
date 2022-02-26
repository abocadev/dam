package example.estructurada;

import java.util.Scanner;

public class E034preguntaTamaño {

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        int tam = 0;
        boolean salir = false;

        // estructura de validación do... while (+if)
        do {
            System.out.println("Que tamaño tiene el array?");
            if (entrada.hasNext()) {
                tam = entrada.nextInt();
                salir = true;
            } else{
                entrada.next();
            }
        } while (!salir);

        // array
        double valores[] = new double[tam];
        for (int i = 1; i < tam + 1; i++) {
            if (entrada.hasNextDouble()) {
                System.out.println(i + "  numero:");
                valores[i] = entrada.nextInt();
                System.out.println("El valor que has introducido " + valores[i]);
            } else {
                i--;
                System.out.println("Elemento no válido");
            }
            entrada.next();
        }
        double acumulada = 0;
        for(int i=0; i<valores.length;i++){
            System.out.println("el elemento " + (i+1) + " vale ");
        }
    }

}
