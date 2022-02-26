package example.estructurada;
import java.util.Scanner;
public class UF1_018 {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        int tam = 10;
        int nums[] =  new int [tam];
        int resultadopos = 0;
        int contadorpos = 0;
        int resultadoneg = 0;
        int contadorneg = 0;
        for(int i = 0; i < tam; i++){
            System.out.println("Introduce un numero:");
            if(entrada.hasNextInt()){
                nums[i] = entrada.nextInt();
                System.out.println("El numero que has introducido es " + nums[i]);
            } else{
                i--;
                System.out.println("No es valido el valor que has introducir");
            }
        }
        for(int x = 0; x<tam; x++){
            if(nums[x] > 0){
                resultadopos += nums[x];
                contadorpos++;
            } else if(nums[x] < 0){
                resultadoneg += nums[x];
                contadorneg++;
            }
        }
        System.out.println("Has introducido " + contadorpos + " valores positivos");
        System.out.println("El total de los numeros positivos es " +resultadopos + "  y la media de estos es " + (resultadopos/contadorpos));
        System.out.println("Has introducido " + contadorneg + " valores negativos");
        System.out.println("El total de los numeros negativos es " +resultadoneg + "  y la media de estos es " + (resultadoneg/contadorneg));
    }
}