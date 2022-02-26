package example.estructurada;
import java.util.Scanner;
public class UF1_017 {
    public static void main(String[] args) {
        Scanner input = new Scanner (System.in);
        int a = input.nextInt();
        int b = input.nextInt();
        if(b <= a){
            while(b <= a){
                System.out.println("Vuelve a introducir los numeros");
                a = input.nextInt();
                b = input.nextInt();
            }
        }
        if(a%2 != 0){
            a++;
        }
        if(b%2 != 0){
            b++;
        }
        while(a <= b){
            System.out.println(a);
            a+= 2;
        }
    }
}