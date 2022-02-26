package example.estructurada;

import java.util.Scanner;

public class E021diames {
    public static void main(String[] args) {
        Scanner input = new Scanner (System.in);
        System.out.println("¿Qué mes quieres analizar? [1 al 12]");
        
        int mes  = input.nextInt();
        input.nextLine();
        
        switch(mes){
            case 2:
               System.out.println("Este mes 28 o 29 dias");
               break;
               
            case 4:
            case 6:
            case 9:
            case 11:
               System.out.println("Este mes tiene 30 dias");
               
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                System.out.println("Este mes tiene 31 dias");
                break;
            default:
                System.out.println("Este mes no existe");
        }
    }
    
}
