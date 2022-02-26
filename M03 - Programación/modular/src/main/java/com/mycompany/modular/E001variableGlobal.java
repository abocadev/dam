package com.mycompany.modular;
import java.util.Scanner;

public class E001variableGlobal {

    private int[] listaEnteros = new int[10];


    public static void main(String[] args) {
        // nombre de la clase + identificador
        E001variableGlobal programa = new E001variableGlobal();
        programa.inicio();
    }
    
    public void inicio(){
        // Instrucciones del metodo principal
        // problema general
        leerLista();
        ordenarLista();
        imprimirLista();
    }
    
    // Metodo con las instrucciones (bloque de codigo) para leer una lista.
    public void leerLista(){
        // Instrucciones - bloque de codigo
        System.out.println("Escribe 10 enteros:");
        Scanner entrada = new Scanner (System.in);
        int indice = 0;
        while(indice < listaEnteros.length){
            if(entrada.hasNextInt()){
                listaEnteros[indice] = entrada.nextInt();
                indice++;
            }else{
                entrada.next();
            }
        }
        entrada.nextLine();
    }

    public void ordenarLista(){
        // Instrucciones - bloque de codigo
        for(int i = 0; i<listaEnteros.length;i++){
            for(int j = 0; j<listaEnteros.length;j++){
                if(listaEnteros[i] > listaEnteros[j]){
                    // necesitamos una variable auxiliar para hacer el intercambio
                    int cambio = listaEnteros[i];
                    listaEnteros[i] = listaEnteros[j];
                    listaEnteros[j] = cambio;
                }
            }
        }
    }

    public void imprimirLista(){
        // Instrucciones
        System.out.println("El array ordenado es: [");
        for(int i = 0; i<listaEnteros.length;i++){
            System.out.print(listaEnteros[i] + " ");
        }
        System.out.println("]");
    }
}