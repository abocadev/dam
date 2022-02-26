package example.estructurada;

import java.util.Scanner;

public class E018dia {
    public static void main(String[] args) {
        Scanner input = new Scanner (System.in);
        System.out.println("Indica el dia de la semana (en numero):");
        int dia = input.nextInt();
        switch(dia){
            case 1:
                System.out.println("Lunes");
            case 2:
                System.out.println("Martes");
            case 3:
                System.out.println("Miercoles");
                
            case 4: 
                System.out.println("Jueves");
                
            case 5:
                System.out.println("Viernes");
                
            case 6:
                System.out.println("Sabado");
                
            case 7:
                System.out.println("Domingo");
                
            default:
                System.out.println("Ese dia de la semana no existe");
            
        }
    }
    
}
