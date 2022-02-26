
package example.estructurada;

import java.util.Scanner;

public class E036separarstringalReves {

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        System.out.println("Introduce una palabra");
        String palabra = entrada.next();
        for(int i = 0; i < palabra.length(); i++){
            System.out.println(palabra.charAt((palabra.length() -1)-i));
        }
    }
    
}
