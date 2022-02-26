package example.estructurada;
import java.util.Scanner;
public class UF1_016 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Escribe un numero:");
        int num1 = input.nextInt();
        System.out.println("Escribe otro numero:");
        int num2 = input.nextInt();
        while (num1 == num2) {
            System.out.println("Has escrito el mismo numero");
            System.out.println("Escribe un numero:");
            num1 = input.nextInt();
            System.out.println("Escribe otro numero:");
            num2 = input.nextInt();
        }
        if (num1 > num2) {
            while (num2 <= num1) {
                System.out.println(num2);
                num2++;
            }
        } else {
            while (num1 <= num2) {
                System.out.println(num1);
                num1++;
            }
        }
    }
}