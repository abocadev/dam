package dev.boca.ficheros;

import java.io.File;
import java.io.RandomAccessFile;

public class E022binarios20enteros {
    public static void main(String[] args) {
        E022binarios20enteros programa = new E022binarios20enteros();
        programa.inicio();
    }

    public void inicio(){
        try {
            File f = new File("Enteros.bin");
            RandomAccessFile raf = new RandomAccessFile(f, "rw");
            int valor = 1;
            for (int i = 0; i < 20; i++) {
                raf.writeInt(valor);
                valor = valor * 2;
            }
            System.out.println("Fichero escrito correctamente");
            raf.close();
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }
}