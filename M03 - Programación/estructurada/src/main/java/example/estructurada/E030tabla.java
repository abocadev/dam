package example.estructurada;

import java.util.Scanner;

public class E030tabla {
    public static void main(String[] args) {
        Scanner input = new Scanner (System.in);
        int num = input.nextInt();
        
        for(int i = 0; i <= 10; i++){
            System.out.println( i + " X " + num + " = " + num*i);
        }
        System.out.println("FIN");
    }
    
}
