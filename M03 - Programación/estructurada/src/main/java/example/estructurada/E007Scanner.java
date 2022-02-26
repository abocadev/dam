package example.estructurada;
import java.util.Scanner;
public class E007Scanner{
    public static void main(String[] args){
        Scanner entrada = new Scanner (System.in);
        char caracter;
        System.out.println("Escribe una palabra: ");
        caracter = entrada.next().charAt(0);
        System.out.println("Tu caracter es " + caracter);
    }
}