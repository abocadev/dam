package example.estructurada;
import java.util.Scanner;
public class E026adivinaNumero {
    public static void main(String[] args) {
        // Generar num aleatorio
        // clase Math, método RANDOM
        // random devuelve un double en 0.0 y 1.0
        // (int) (Math.random()*max)+min)
        int numRandom = (int)(Math.random()*10) + 1;
        Scanner input = new Scanner (System.in);
        //variable para el intento del usuario
        int num;
        // variable booleana bandera
        boolean salir = false;
        
        do{
            System.out.println("Adivina un numero entre 1 y 10");
            System.out.println("Pon un 0 para salir");
            num = input.nextInt();
            if(num==0){
                salir = true;
            } else{
                if(num == numRandom){
                    System.out.println("Acertaste");
                    salir = true;
                } else{
                    System.out.println("Fallaste");
                }
            }
        } while(!salir);
        System.out.println("FIN");
    }
    
}
