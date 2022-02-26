package dev.boca.ficheros;

import java.io.File;

public class E002estado {
    
    public static void main(String[] args) {
        E002estado programa = new E002estado();
        programa.inicio();
    }
    
    public void inicio(){
        File temp = new File("C:/Temp");
        File fotos = new File("C:/Temp/Fotos");
        File documento = new File("C:/Temp/Fotos/Documento.txt");
        
        System.out.println(temp.getAbsoluteFile() + " existe? - " + temp.exists());
        MostrarEstado(fotos);
        MostrarEstado(documento);
    }

    public void MostrarEstado(File f){
        System.out.println(f.getAbsolutePath() + " es un fichero? - " + f.isFile());
        System.out.println(f.getAbsolutePath() + " es una carpeta? - " + f.isDirectory());
    }
}
