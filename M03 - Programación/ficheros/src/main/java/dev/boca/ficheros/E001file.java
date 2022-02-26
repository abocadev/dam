package dev.boca.ficheros;

import java.io.File;

public class E001file {
    public static void main(String[] args) {
        E001file programa = new E001file();
        programa.inicio();
    }
    
    public void inicio(){
        // INICIALIZAR dos rutas absolutas
        File carpetaAbs = new File("C:/Carpeta/");
        File ficheroAbs = new File("C:/Carpeta/Documento.txt");
        
        
        // INICIALIZAR RUTAS RELATIVAS
        File carpetaRe1 = new File("Carpeta");
        File ficheroRe1 = new File("Carpeta/Documento.txt");
        
        MostrarRutas(carpetaAbs);
        MostrarRutas(ficheroAbs);
        MostrarRutas(carpetaRe1);
        MostrarRutas(ficheroRe1);
        
    }
    
    public void MostrarRutas(File f){
        System.out.println("La ruta es: " + f.getAbsolutePath());
        System.out.println("Su padre es: " + f.getParent());
        System.out.println("Su nombre es: " + f.getName());
        System.out.println("---------------------------------------------");
    }
}