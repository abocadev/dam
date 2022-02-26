package dev.boca.ficheros;

import java.io.File;
import java.util.Date;

public class E003lecturaModificacion {
    
    public static void main(String[] args) {
        E003lecturaModificacion programa = new E003lecturaModificacion();
        programa.inicio();
    }
    
    public void inicio(){
        File documento = new File("C:/Temp/doc.txt");
        System.out.println(documento.getAbsolutePath());
        
        // ojo! tipo Date
        Date fecha = new Date(documento.lastModified());
        System.out.println("Ultima modificacion " + fecha);
        System.out.println("Tamanyo del fichero " + documento.length());
    }
    
}
