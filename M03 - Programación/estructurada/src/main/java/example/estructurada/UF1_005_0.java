package example.estructurada;
import java.util.Scanner;
public class UF1_005_0 {
    public static void main(String[] args) {
        Scanner input = new Scanner (System.in);
        System.out.println("Inserta un numero del 1 al 100:");
        int num  = input.nextInt();
        if (num%2 == 0 && num <= 100 && num>=1){
            System.out.println("El numero " + num + " es par");
        } else if(num <= 100 && num>=1){
            System.out.println("El numero " + num + " es impar.");
        } else{
            System.out.println("El numero que has insertado no es mayor a 1 y no es menor o igal a 100");
        }
    }
    
}
