package dev.boca.ficheros;

import java.io.File;
import java.util.Scanner;

public class E018vocales {
    
    public static final String MARCA = "fin";
    public static void main(String[] args) {
        E018vocales programa = new E018vocales();
        programa.inicio();
    }
    
    // contar vocales
    
    // que es una vocal
    // contarlas
    public void inicio(){
        try {
            // abrir el fichero
            File f = new File("C:/Temp/Demo.txt");
            Scanner lectura = new Scanner(f);
            // datos necesarios
            int numPalabras = 0;
            int numVocales = 0;
            // marca de finalizacion
            boolean leer = true;
            while (leer) {
                String palabras = lectura.next();
                if(MARCA.equals(palabras)){
                    // bandera
                    leer = false;
                }else{
                    // tratar el dato
                    numPalabras++;
                    // que es una vocal
                    numVocales = numVocales + contarVocales(palabras);
                }
            }
            System.out.println("Hay " + numPalabras + " palabras");
            System.out.println("Hay " + numVocales + " vocales");
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }
    
    // metodo para saber que es una vocal
    // entrada --> char
    // salida --> boolean
    public boolean esVocal(char c){
        switch(c){
            case 'a':
            case 'e':
            case 'i':
            case 'o':
            case 'u':
                return true;
            default:
                return false;
        }
    }
    
    
    // meotodo para contar vocales
    // entrada --> string, la palabra
    // salida --> int
    public int contarVocales(String palabra){
        int total = 0;
        // validar datos (mayusculas / minusculas)
        palabra = palabra.toLowerCase();
        for(int i = 0; i<palabra.length();i++){
            if(esVocal(palabra.charAt(i))){
                total++;
            }
        }
        return total;
    }
}
