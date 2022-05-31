package example.estructurada;

import java.util.Scanner;

public class BocanegraAlbertDNI {

    /*
        Programa que pida el numero del DNI y luego la letra
        Saber si el DNI que ha insertado corresponde a la letra, haciendo una división 
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Declaramos todas las variables necesarias
        boolean validado = false;
        int numeroDNI = 0;
        char letraDNI = 0;

        // Indicamos las letras del DNI en el siguiente orden
        char letrasDNI[] = new char[]{'T', 'R', 'W', 'A', 'G', 'M', 'Y', 'F', 'P', 'D', 'X', 'B', 'N', 'J', 'Z', 'S', 'Q', 'V', 'H', 'L', 'C', 'K', 'E'};
      
        
        // Pedir numero de DNI, hasta que el numero cumpla los requisitos
        do {
            System.out.println("Introduce el numero del DNI (SIN LA LETRA):");

            // Comprobaremos si el numero es tipo INT y si cumple los requisitos anteriores
            // En el caso que no cumpla los requisitos se le vuelve a pedir el numero de DNI
            if (input.hasNextInt()) {
                numeroDNI = input.nextInt();
                if (numeroDNI > 0 && numeroDNI < 99999999) {
                    validado = true;
                } else {
                    System.out.println("Has introducido un numero erroneo");
                }
            } else {
                System.out.println("Has introducido un valor erroneo");
                input.nextLine(); // Lo que hacemos es limpiar el buffer para que no entre en bucle la entrada indicada anteriormente
            }
        } while (!validado);
        validado = false;

        // Pediremos la letra del DNI y no parara de pedir la letra hasta que cumpla los requisitos
        do {
            System.out.println("Introduce la letra del DNI:");
            
            // Comprobaremos si el valor introducido es un numero 
            if(input.hasNextInt()){
                System.out.println("Has introducido un valor incorrecto");
                input.nextLine();
            }
            
            // Comprobaremos si el valor introducido es tipo String 
            else if (input.hasNext()) {
                String caracteres = input.next();
                // Comprobamos si el tamaño el String solo tiene un caracter
                if (caracteres.length() == 1) {
                    letraDNI = caracteres.toUpperCase().charAt(0);
                    validado = true;
                } else {
                    System.out.println("Has introducido una letra de mas");
                    input.nextLine();

                }
            } else {
                System.out.println("Has introducido un valor incorrecto.");
                input.nextLine();
            }
        } while (!validado);
        // Ahora lo que hacemos es saber dividir NUMERO DEL DNI entre 23 y el resto será 
        int saberLetra = numeroDNI % 23;
        
        // Mostraremos si el resultado es correcto o incorrecto
        // En el caso que sea correcto, lo imprimira
        // Y en el caso de que sea incorrecto, indicara la verdadera letra que corresponde al numero indicado anteriormente
        if (letrasDNI[saberLetra] == letraDNI) {
            System.out.println("La letra que has introducido corresponde a la del DNI.");
            System.out.println("Tu numero de DNI es " + numeroDNI + " y la letra es " + letraDNI);
        } else {
            letraDNI = letrasDNI[saberLetra];
            System.out.println("La letra que has introducido no corresponde a la del DNI.");
            System.out.println("Tu numero de DNI es " + numeroDNI + " y tu letra sería " + letraDNI);
        }
        //FIN DEL CODIGO MEJORADO -> Comenta hasta aquí para poder ejecutar el codigo principal
       
    }
}
