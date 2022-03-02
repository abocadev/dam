package dev.boca.ficheros;

import java.io.File;
import java.io.RandomAccessFile;
import java.util.Arrays;
import java.util.Random;

public class E025reales {
    public static void main(String[] args) {
        E025reales programa = new E025reales();
        programa.inicio();
    }
    
    public void inicio(){
        File f = new File("Reales.bin");
        crearFichero(f);
        double[] valores = leerReales(f);
        if(valores != null){
            // todook
            Arrays.sort(valores);
            for(int i = valores.length-1; i>=0;i--){
                System.out.println(valores[i]);
            }
        }else{
            System.out.println("Error en la lectura de datos");
        }
    }
    
    // lectura de datos del bin y guardarlos en un array
    // entrada -> ruta
    // salida -> array de reales
    public double[] leerReales(File f){
        try {
            RandomAccessFile raf = new RandomAccessFile(f, "r");
            // calculo del numero de reales
            long numReales = f.length() / 8;
            // necesito un entero para inicializar el array
            int n = (int)numReales;
            double []array = new double[n];
            for(int i = 0; i<numReales; i++){
                array[i] = raf.readDouble();
            }
            raf.close();
            return array;
        } catch (Exception e) {
            System.out.println("Error: " + e);
            return null;
        }
    }
    // metodo que crea fichero bin con valores random entre 0 y 100
    // entrada -> la ruta
    // salida -> nope
    public void crearFichero(File f){
        try {
            RandomAccessFile raf = new RandomAccessFile(f, "rw");
            Random r = new Random();
            for(int i = 0; i<20;i++){
                raf.writeDouble(100*r.nextDouble());
            }
            raf.close();
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }
}