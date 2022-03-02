package dev.boca.ficheros;

import java.io.File;
import java.io.RandomAccessFile;

public class E024lectura {
    public static void main(String[] args) {
        E024lectura programa = new E024lectura();
        programa.inicio();
    }
    
    public void inicio(){
        try{
            File f = new File("Enteros.bin");
            RandomAccessFile raf = new RandomAccessFile(f, "r");
            //calculo del numero de enteros
            long numEnteros = f.length();
            for(int i = 0; i<numEnteros;i++){
                int valor = raf.readInt();
                System.out.println("Valor leido: " + valor);
            }
            raf.close();
            
        }catch (Exception e) {
        
        }
    }
}
