package example.estructurada;
import java.util.Scanner;
public class BocanegraAlbertNUM{
    // LO QUE HAREMOS EN ESTE PROGRAMA ES COMPROBAR SI UN NUMERO ES CAPICUA
    public static void main(String[] args) {
        Scanner input = new Scanner (System.in);
        System.out.println("Lo que haremos en este programa es un comprobar si un numero es capicua.");
        // DECLARAMOS LAS VARIABLES NECESARIAS PARA ESTE PRIMER BUCLE
        boolean numval = false;
        int num = 0, capicua = 0, numeros = 0, dis = 0;
        // CREAMOS UN BUCLE PARA COMPROBAR SI HA INTRODUCIDO UN NUMERO Y SI CUMPLE LAS CARACTERÍSTICAS 
        do{
            System.out.println("Introduce un numero:");
            // COMPROBAMOS SI EL VALOR INTRODUCIDO ES "INT" O NO
            if(input.hasNextInt()){
                num = input.nextInt();
                // COMPROBAMOS SI NUMERO ES > DE 10, EN EL CASO QUE D
                if(num > 10){
                    numval = true;
                }else{
                    System.out.println("El numero que has introducido no es mayor de 10");
                }
            }else{
                System.out.println("El numero que has introducido no es valido.");
            }
            input.nextLine(); // LIMPIAMOS EL BUFFER
        }while(!numval);
        // INDICAMOS QUE EL VALOR DISMINUYENTE PARA EL SIGUIENTE BUCLE
        dis = num;
        // VAMOS A INVERTIR EL ORDEN EL NUMERO
        do{
            numeros = dis % 10; // OBTENEMOS EL ULTIMO NUMERO
            capicua = capicua * 10 + numeros; // PONEMOS EL NUMERO AL FINAL Y EL ANTERIOR NUMERO LE SUBIMOS UNA POSICION
            dis = dis / 10; // LE QUITAMOS UN NUMERO
        }while(dis != 0);

        // INDICAMOS SI EL VALOR QUE HAS INTRODUCIDO
        if(num == capicua){
            System.out.println("El numero " + num + " es capicua.");
        }else{
            System.out.println("El numero " + num + " no es capicua."); 
        }

        // IMPRIMOS EL NUMERO PRINCIPAL Y EL NUMERO INVERTIDO
        System.out.println("El numero que has introducido es: " + num + ".\nEl numero invertido es: " + capicua + ".");
    }
}
