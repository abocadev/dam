package example.estructurada;

import java.util.Scanner;

public class E027adivina3vidas {
    public static void main(String[] args) {
        Scanner input = new Scanner (System.in);
        int numRandom = (int)((Math.random()*10)+1);
        int num;
        // numeros de vidas
        int vidas = 3;
        // bandera
        boolean acierto = false;
        do{
            if(vidas > 0){
                System.out.println("Introduce un numero del 1 al 10: ");
                System.out.println("Te quedan "+ vidas + " vidas.");
                num = input.nextInt();
                // comparar valor con el num aleatorio
                if(num == numRandom){
                    System.out.println("Acertaste!");
                    acierto = true;
                } else{
                    System.out.println("Fallaste! \nVuelvelo a intentar");
                    vidas--;
                    if(num < numRandom){
                        System.out.println("El numero secreto es mayor");
                    } else{
                        System.out.println("El numero secreto es menor");
                    }
                }
            } else{
                System.out.println("Te quedastes sin vidas");
                acierto = true;
            }
        } while(!acierto);
        System.out.println("El numero secreto era " + numRandom);
        System.out.println("Juego finalizado");
    }
    
}
