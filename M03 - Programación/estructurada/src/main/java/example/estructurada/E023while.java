package example.estructurada;

import java.util.Scanner;

public class E023while {
    public static void main(String[] args) {
        Scanner input = new Scanner (System.in);
        int num = input.nextInt();
        while(num<5){
            System.out.println("El numero " + num + "es menor que 5");
            num++;
        }
    }
    
}
