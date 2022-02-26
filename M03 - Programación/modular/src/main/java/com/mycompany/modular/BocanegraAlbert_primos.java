package com.mycompany.modular;

import java.util.Scanner;

public class BocanegraAlbert_primos{

    // DECLARAMOS LAS VARIABLES QUE QUEREMOS QUE SE VEAN EN TODOS LOS MÉTODOS
    Scanner entrada = new Scanner(System.in);
    int[] primos = {2, 3, 5, 7}; // Numeros Primos
    int numero = 0; // Numero del usuario
    int[] numerosPrimos = new int[primos.length + 1]; // Array que almacanera los números primos que corresponden al numero que ha introducido el usuario
    
    public static void main(String[] args) {
        BocanegraAlbert_primos programa = new BocanegraAlbert_primos();
        programa.inicio();
    }

    // METODO DE INICIO
    public void inicio(){
        pedirnumero(); // Metodo que pedira al usuario el numero
        comprobarNumero(); // Metodo que comprobara si el numero es Spencer o no y llamara a otro metodo para imprimir los numeros
    }

    // PRIMER NIVEL

    // Metodo que pedira al usuario que introduzca el numero y proximamente llamara a otro metodo para comprobar si el tipo de numero es correcto
    // entrada -> no
    // salida -> si
    public void pedirnumero(){
        System.out.println("Introduce un numero para comprobar si es primo o no:");
        numero = numeroValido(0); // Llamaremos a otro metodo para comprobar si el tipo de numero y el numero es correcto o no.
    }

    // En este metodo lo que haremos sera comprobar si el numero es primo o no, y si lo es que busque que calcule que numeros primos contienen
    // entrada -> no
    // salida -> si
    public void comprobarNumero() {
        int a = numero; // Variable para poder hacer los calculos al numero primo
        int indice = 0;
        boolean valorPrimo = true;
        for (int i = 0; i < primos.length; i++) {
            // Lo primero que comprobaremos es que si el numero que ha introducido forma parte del que tenemos en la lista de numeros primos
            if(numero == primos[i]){
                // En el caso que si lo que haremos sera introducir el numero en el array de los numeros del numero introducido por el usuario.
                numerosPrimos[indice] = primos[i];
            }else if (a % primos[i] == 0) {
                // En el caso que no lo que haremos sera calcular el numero
                valorPrimo = false;
                a = a / primos[i];
                boolean valor = false;
                // En este bucle lo que hacemos es comprobar si el numero primo esta en la lista de los numeros primos del numero introducido por el usuario.
                for (int x = 0; x < numerosPrimos.length; x++) {
                    if (primos[i] == numerosPrimos[x]) {
                        valor = true;
                    }
                }
                // En el caso que el valor no este en la lista de numeros primos del usuario lo la introduciremos
                if(valor == false){
                    numerosPrimos[indice] = primos[i];
                    indice++;
                }
                i--;
            }
        }
        comprobarPrimo(a, indice);

        imprimirPrimos(valorPrimo);

    }
    
    // En este metodo lo que haremos sera imprimir los valores de la lista de los numeros primos introducidos por el usuario
    // entrada -> si
    // salida -> si
    public boolean imprimirPrimos(boolean valorPrimo){

        System.out.print("El numero " + numero + " que has introducido ");
        // Este condicional imprime si es un numero primo o no
        if (valorPrimo == true) {
            System.out.print("es primo: ");
        }else{
            System.out.print("no es primo: ");
        }

        // Aqui imprimiremos los numeros primos que contiene el numero que ha introducido el usuario
        for (int i = 0; i < numerosPrimos.length; i++) {
            if (numerosPrimos[i] != 0) {
                System.out.print(numerosPrimos[i] + " ");
            }
        }
        return valorPrimo;
    }

    // SEGUNDO NIVEL
    // Metodo de comprueba si el numero es correcto o no
    // entrada -> si
    // salida -> si
    public int numeroValido(int a){
        // Comprobamos si el tipo de valor que ha introducido es correcto
        if(entrada.hasNextInt()){
            // En el caso que el tipo de valor sea correcto lo que tiene que hacer es comprobar si es igual o mayor a 2
            a = entrada.nextInt();
            if(a <= 1){
                System.out.println("El numero que has introducido tiene que ser mayor o igual a 2");
                pedirnumero();
            }
        }else{
            // En el caso que no sea correcto se lo volveremos a pedir y limpiaremos el buffer
            System.out.println("Has introducido un valor incorrecto");
            entrada.next();
            pedirnumero();
        }
        return a;
    }
    
    // En este metodo lo que haremos sera comprobar si el numero final del calculo es mayor que 1 y si lo es un numero primo o no
    // entrada -> si
    // salida -> no
    public int comprobarPrimo(int a, int indice){
        if(a > 1){
            boolean valor = false;
            // Este bucle lo que hace es comprobar es si el resto del calculo corresponde a un numero de la lista primos.
            for (int i = 0; i < primos.length; i++) {
                if (primos[i] == a) {
                    valor = true;
                }
            }
            // En el caso de que no este en la lista de los primos, lo que haremos sera introducirlo en la variable de los numeros primos que ha introducido el usuario.
            if (valor == false) {
                numerosPrimos[indice] = a;
            }
        }
        return indice;
    }
}