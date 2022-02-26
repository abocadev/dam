package example.estructurada;

import java.util.Scanner;


public class E017notas {
    // a partir de una nota cuantitativa saca una nota qualitativa
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Introduce tu nota:");
        float nota = input.nextFloat();
        if (nota < 5){
            System.out.println(nota + " = insuficiente");
        } else if( (nota >= 5) && (nota < 6.5)){
            System.out.println(nota + " = suficiente");
        } else if( (nota >= 6.5) && (nota < 8)){
            System.out.println(nota + " = notable");
        } else if( (nota >= 8) && (nota < 9)){
            System.out.println(nota + " = notable alto");
        }else{
            System.out.println(nota + " = excelente");
        }
    }
    
}
