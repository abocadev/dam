package dev.boca.ficheros;

import java.io.File;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.Scanner;

public class E019enterosOrdenados {
    public static void main(String[] args) {
        E019enterosOrdenados programa = new E019enterosOrdenados();
        programa.inicio();
    }
    
    public void inicio(){
        // metodo para leer los datos
        // metodo para crear el fichero y escribir los valores almacenados
        int[] valores = leerDatos("C:/Temp/Enteros.txt");
        if(valores != null){
            // obtengo los datos
            // ordeno los datos con un metodo secreo que solo sabe Miguel Angel
            Arrays.sort(valores);
            escribirArray("C:/Temp/Ordenados.txt", valores);
        }else{
            System.out.println("Algo ha pasadoi");
        }
    }
    
    // leer valores y cargarlos en un array
    // entrada --> fichero
    // salida --> array tipo int
    public int[] leerDatos(String nombre){
        try {
            File f = new File(nombre);
            Scanner lectura = new Scanner(f);
            int medida = lectura.nextInt();
            int[] datos = new int[medida];
            for(int i = 0; i<medida; i++){
                datos[i] = lectura.nextInt();
            }
            return datos;
        } catch (Exception e) {
            System.out.println("Error: " + e);
            return null;
        }
    }
    
    // escrbiir en array en otro fichero
    // entrada --> array + ruta del fichero
    // salida --> nope
    public void escribirArray(String nombre, int[] datos){
        try{
            File f = new File(nombre);
            PrintStream escribe = new PrintStream(f);
            escribe.print(datos.length);
            for(int i = 0; i<datos.length;i++){
                escribe.print(" " + datos[i]);
            }
            System.out.println("");
            escribe.close();
        }catch(Exception e) {
        
        }
    }
}
