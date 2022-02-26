package dev.boca.ficheros;

import java.io.File;

public class E004gestionFicheros {
    public static void main(String[] args) {
        E004gestionFicheros programa = new E004gestionFicheros();
        programa.inicio();
    }
    
    public void inicio(){
        File fotos = new File("C:/Temp/Fotos");
        File documento = new File("C:/Temp/Documento.txt");
        
        boolean resultado = fotos.mkdir();
        System.out.println("Carpeta creada " + fotos.getName()+"? " + resultado);
        if(!resultado){
            boolean delCarpeta = fotos.delete();
            System.out.println("Carpeta borrada " + fotos.getName() + "? " + delCarpeta);
            boolean delFichero = documento.delete();
            System.out.println("Fichero borrada " + documento.getName() + "? " + delFichero);
        }
    }
    
}
