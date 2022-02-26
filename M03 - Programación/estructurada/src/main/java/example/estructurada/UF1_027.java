package example.estructurada;
import java.util.Scanner;
public class UF1_027 {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        int [] lista = new int[10];
        int numero, posicion;
        // leer y grabar 8 números
        for(int i = 0; i < 8; i++){
            System.out.println("Introduce un numero");
            lista[i] = entrada.nextInt();
        }
        //pedimos que la posción está entre 0 y 7
        System.out.println("Introduce un nuevo numero:");
        numero = entrada.nextInt();
        System.out.println("Introduce la posicion:");
        posicion = entrada.nextInt();
        
        // desplazamiento de los elemento de la tabla
        for(int i = 7; i>=posicion; i--){
            lista[i+1] = lista[i];
            lista[posicion] = numero;
            
        }
    }
}
