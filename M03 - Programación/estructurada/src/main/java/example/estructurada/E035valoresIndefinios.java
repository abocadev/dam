package example.estructurada;
import java.util.Scanner;
public class E035valoresIndefinios {
    // cargamos cantidad indefinida de valores
    // creamos una bandera para salir(S)
    // calcular suma acumulada
    // calcular media
    public static void main(String[] args) {
        final int TAM = 10;
        Scanner entrada = new Scanner (System.in);
        double []valores = new double [TAM];
        boolean salir = false;
        int contador = 0;    
        // estructura para pedir los valores
        do{
            System.out.println("Introduce el valor " + (contador+1));
            System.out.println("S para salir");
            // validar el tipo de dato
            // si es double, lo guardo en el array e incrementamos el contador (índice)
            if(entrada.hasNextDouble()){
                valores[contador] = entrada.nextDouble();
                contador++;
            } else{
                // si no es double, vamos a ver si es S o s
                char leido = (char)entrada.next().charAt(0);
                if(leido == 's' || leido == 'S'){
                    salir = true;
                } else{
                    System.out.println("Valor no valido");
                }
            }
            // limpiar el buffer
            entrada.nextLine();
            // comprobar si el indice ha llegado a TAM.
            // TAM es la cantidad máxima, por tanto el último indice es TAM-1
            // Si llega a TAM, nos hemos pasado
            if(contador == TAM){
                salir = true;
                System.out.println("Has superado el limite " + TAM);
            }
        } while(!salir);
        // calcular la suma acumulada y media
        // recorrer array con un for
        double suma = 0;
        for(int i = 0;i<contador;i++){
            System.out.println("El elemento " + (i+1) + " vale " +valores[i]);
            suma += valores[i];
        }
        System.out.println("La suma acumulada de los elementos del array " + suma);
        System.out.println("La media de los elementos del array " + (suma/contador));
    }   
}