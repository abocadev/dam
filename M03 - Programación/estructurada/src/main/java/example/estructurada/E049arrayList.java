
package example.estructurada;

import java.util.ArrayList;
import java.util.Scanner;


public class E049arrayList {


    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        // no hace falta establecer el tamaño del array
        
        // declarar ArrayList e inicialización
        // Entre <> va el tipo de dato de inicialización del array
        ArrayList <String> cosas = new ArrayList<>();
        // en el constructor, <> puede contener el tipo de dato
        
        // inicializar
        // como no conocemos el tamaño, no podemos inicializar con for
        // inicializamos con while, o do while
        char respuesta;
        do{
            System.out.println("Introduce un valor:");
            String valor = entrada.next();
            // grabar el dato en el arraylist
            cosas.add(valor);
            System.out.println("¿Algún dato que introducir? s/n");
            respuesta = entrada.next().charAt(0);
        }while(respuesta == 's' || respuesta == 'S');
        
        for(int i = 0; i<cosas.size(); i++){
            // size() sustituye a length() 
            System.out.println(cosas.get(i));
            // cosas.get(i) sustituye a cosas[i]
        }
    }
    
}
