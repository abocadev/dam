package example.estructurada;
import java.util.Scanner;
public class E032arrayMedia {
    
    // introducimos X valores
    // calculamos la media acumulada
    // calculamos la media de todos los valores
    public static void main(String[] args) {
        Scanner input = new Scanner (System.in);
        final int TAM = 7;      
        //declaración de array
        double valores [] = new double [TAM];
        // inicializar el array con valores por teclado
        for(int i = 0; i <valores.length; i++){
            System.out.println("Introduce el valor " + (i+1));
            // validación del tipo de dato
            if(input.hasNextDouble()){
                valores[i] = input.nextDouble();
            } else{
                i--;
                System.out.println("Valor no valido");
            }
            input.nextLine();
        }
        double sumaAcumulada = 0;
        for(int i = 0; i <valores.length;i++){
            System.out.println("El elemento " + (i+1) + " vale " + valores[i]);
            sumaAcumulada += valores[i];
        }
        System.out.println("La media de los valores es: " + (sumaAcumulada/valores.length));
    }
}
