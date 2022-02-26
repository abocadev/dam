package example.estructurada;

import java.util.Scanner;

public class E025Bandera {
    public static void main(String[] args) {
        Scanner input = new Scanner (System.in);
        int num;
        boolean salir = false;
        do{
            System.out.println("Pon un 0 para salir");
            num = input.nextInt();
            if(num==0){
                salir =true;
            }
        }while(!salir);
        System.out.println("FIN");
    }
    
}