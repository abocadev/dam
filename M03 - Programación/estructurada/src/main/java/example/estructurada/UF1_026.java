package example.estructurada;
import java.util.Scanner;
public class UF1_026 {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        int TAM = 10;
        int nums[] = new int[TAM];
        boolean creciente = false, decreciente = false;
        for(int i = 0; i < TAM; i++){
            System.out.println("Ingresa un numero:");
            nums[i] = entrada.nextInt();
        }
        for(int i = 0; i<nums.length; i++){
            int a = 1;
            if(i == (nums.length-1)){
                a = 0;
            }
            if(nums[i] > nums[i+a]){
                decreciente = true;
            }
            if(nums[i] < nums[i+a]){
                creciente = true;
            }
        }
        if(creciente == true && decreciente == false){
            System.out.println("Los numeros anteriores estan ordenados crecientemente");
        } else if(creciente == false && decreciente == true){
            System.out.println("Los numeros anteriores estan ordenados decrecientemente");
        } else if(creciente == false && decreciente == false){
            System.out.println("Son el mismo numero");
        } else{
            System.out.println("Los numeros estan desordenados");
        }
    }   
}