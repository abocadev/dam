package example.estructurada;

import java.util.Scanner;

public class UF1_004_0 {
    public static void main(String[] args) {
        Scanner entrada = new Scanner (System.in);
        String number = entrada.next();
        System.out.println(number.charAt(0));
        System.out.println(number.charAt(0) + "" + number.charAt(1));
        System.out.println(number.charAt(0) + "" + number.charAt(1) + "" + number.charAt(2));
        System.out.println(number.charAt(0) + "" + number.charAt(1) + "" + number.charAt(2) + "" + number.charAt(3));
        System.out.println(number.charAt(0) + "" + number.charAt(1) + "" + number.charAt(2) + "" + number.charAt(3) + "" + number.charAt(4));
    }
    
}