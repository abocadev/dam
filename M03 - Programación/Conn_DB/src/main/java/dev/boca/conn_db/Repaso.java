package dev.boca.conn_db;

import java.io.File;
import java.io.IOException;

public class Repaso {
    public static void main(String[] args) throws IOException {
        // crear instancias de objetos de la clase File
        File fichero = new File("binario.bin");
        File fichero2 = new File("texto.txt");
        File carpeta = new File("prueba");
        File carpeta2 = new File("carpeta");
        
        // crear ficheos y carpetas
        fichero.createNewFile();
        fichero2.createNewFile();
        carpeta.mkdir();
        carpeta2.mkdir();
        
        // existe fichero o no
        System.out.println("El fichero existe (binario.bin): " + fichero.exists());
        System.out.println("La carpeta existe (prueba): " + carpeta.exists());
        
        // indicar si son directorios o no
        System.out.println("binario.bin es una carpeta: " + fichero.isDirectory());
        System.out.println("prueba es una carpeta: " + carpeta.isDirectory());
        
        // indicar si es un fichero o no
        System.out.println("binario.bin es un fichero: " + fichero.isFile());
        System.out.println("prueba es un fichero: " + carpeta.isFile());
        
        // pedir rutas absolutas de los objetos
        System.out.println("La ruta absoluta de binario.bin es" + fichero.getAbsolutePath());
        System.out.println("La ruta absoluta de prueba es" + carpeta.getAbsolutePath());
        
        // verificiar si se pueden leer, escribir o ejecutar
        System.out.println("binario.bin se puede leer: " + fichero.canRead());
        System.out.println("binario.bin se puede escribir: " + fichero.canWrite());
        System.out.println("binario.bin se puede ejecutar: " + fichero.canExecute());
        
        System.out.println("prueba se puede leer: " + carpeta.canRead());
        System.out.println("prueba se puede escribir: " + carpeta.canWrite());
        System.out.println("prueba se puede ejecutar: " + fichero.canExecute());
        
        // obtener el nombre sin extension
        System.out.println("El nombre del fichero2 es: " + fichero2.getName());
        System.out.println("El nombre de la carpeta2 es: " + carpeta2.getName());
        
        // obtener el directorio padre
        System.out.println("El nombre del padre del fichero2 es: " + fichero2.getParent());
        System.out.println("El nombre del padre de la carpeta 2 es: " + carpeta2.getParent());
        
        // guardar en un array todos los ficheros y carpetas que haya en un directorio
        System.out.println("Objetos File dentro de un array");
        File lista[] = carpeta.listFiles();
        for(int i = 0; i<lista.length; i++){
            System.out.println(lista[i]);
        }
    }
}