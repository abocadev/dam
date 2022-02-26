package example.estructurada;

import java.util.Scanner;

public class UF1_019 {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        int tam = 10;
        int nums[] = new int[tam];
        for(int i = 0; i < tam; i++){
            System.out.println("Introduce un numero:");
            nums[i] = entrada.nextInt();
            System.out.println("El valor que has introducido es "+ nums[i]);
        }
        int contador= 0;
        int resultadosuma = 0;
        for(int i = 0; i <= tam; i+=2){
            resultadosuma += nums[contador];
        }
        System.out.println("La suma total de los pares es " + resultadosuma + " y la media es " + (resultadosuma/(tam/2)));
    }
    
}
