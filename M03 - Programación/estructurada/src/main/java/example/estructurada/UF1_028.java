package example.estructurada; 

import java.util.Scanner;

public class UF1_028 {
    public static void main(String[] args) {
        Scanner entrada = new Scanner (System.in);
        final int TAM  = 5;
        // declaración del array con una constante
        int []valores = new int[TAM];
        
        int tamActual = 0; // lo usaré como indice del array en el bucle
        int num = 0; // para recoger el numero (al margen del array)
        
        // bucle do... while que funciona mientras no se introduzca un -1
        do{
            System.out.println("Introduce un -1 para salir");
            if(entrada.hasNextInt()){ // validación del tipo de dato en el buffer
                 if(num>=0){ // si num es positivo
                    valores[tamActual] = num; // lo guardi en la actual posicion del array
                    tamActual++;// incremento el índice
                    // hay que controlar que no crezca mas que TAM
                    if(tamActual >= valores.length){ // mal, porque sobrepsasa el rango del arrray
                        // nuevo array
                        int aux[] = new int[valores.length+TAM];
                        for(int i = 0; i < valores.length; i++){
                            aux[i] = valores[i];
                        }
                        valores= aux;
                    }
                }
            }else{
                entrada.nextLine();
            }
        } while(num!= -1);
        
        // imprimir
        for(int i = 0; i < tamActual; i++){
            System.out.println("En la posicion " + i + " está el valor " + valores[i]);
        }
    }
    
}
