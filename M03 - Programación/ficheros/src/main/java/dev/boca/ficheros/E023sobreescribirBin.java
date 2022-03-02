package dev.boca.ficheros;

import java.io.File;
import java.io.RandomAccessFile;

public class E023sobreescribirBin {
    public static void main(String[] args) {
        E023sobreescribirBin programa = new E023sobreescribirBin();
        programa.inicio();
    }
    
    public void inicio(){
        try {
            File f = new File("Enteros.bin");
            RandomAccessFile raf = new RandomAccessFile(f, "rw");
            long puntero = raf.getFilePointer();
            System.out.println("Inicio: puntero en posicion " + puntero);
            // sobreescribir parte del fichero
            for(int i = 0; i<5; i++){
                raf.writeInt(-1);
            }
            // si el fichero tiene mas datos, se mantendran al final
            puntero = raf.getFilePointer();
            System.out.println("Inicio: puntero en posicion " + puntero);
            // medida del fichero
            raf.setLength(puntero);
            raf.close();
            System.out.println("Fichero modificado correctamente");
        } catch (Exception e) {
            System.out.println("Error: " + e); 
        }
    }
    
}
