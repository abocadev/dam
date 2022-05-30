package dev.boca.progragramacioncompetitiva;

import java.util.Scanner;

public class ejercicio {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        int[] valores = new int[10];
        int num = 0;
        boolean salir = false;
        System.out.println("introduce un numero para salir");
        for(int i = 0; i < 10 && !salir; i++){
            num = entrada.nextInt();
            if( num < 0){
                salir = true;
            }else{
                valores[i] = num;
            }
        }
        
        int contador = 0;
        for(int i = 0; i < valores.length;i++){
            if(valores[i] % 10 == 2){
                contador++;
            }
        }
        
        System.out.println("Todos los 2 que hay: " + contador);
    }
}
