package example.estructurada;
import java.util.Scanner;
public class UF1_021 {
    public static void main(String[] args){
        Scanner entrada = new Scanner(System.in);
        System.out.println("Introduzca un numero:");
        int num = entrada.nextInt();
        int pares = 20 + num;
        int nums[] = new int [pares];
        for(int i = num; i< pares; i+=2){
            if(i%2==0){
                System.out.println(nums[i]);
                nums[i] = i;
            }
        }
    }
}