package dev.boca.ficheros;

import java.io.File;

public class E006listado {
    public static void main(String[] args) {
        E006listado programa = new E006listado();
        programa.inicio();
    }
    
    public void inicio(){
        File carpeta = new File("C:/Temp");
        File [] arrayElementos = carpeta.listFiles();
        System.out.println("El contenido de " + carpeta.getAbsolutePath() + " es: ");
        
        //Recorrer el array para que Enrique me deje tranquila
        for(int i = 0; i<arrayElementos.length; i++){
            File f = arrayElementos[i];
            if(f.isDirectory()){
                System.out.println("[DIR]");
            }else if(f.isFile()){
                System.out.println("[FIC]");
            }else{
                System.out.println("FIN");
            }
            
            System.out.println(f.getName());
        }
    }
}
