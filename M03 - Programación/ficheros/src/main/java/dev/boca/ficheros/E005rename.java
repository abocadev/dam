package dev.boca.ficheros;

import java.io.File;

public class E005rename {
    public static void main(String[] args) {
        E005rename programa = new E005rename();
        programa.inicio();
    }
    
    public void inicio(){
        File origenCarpeta = new File("C:/Temp/Fotos");
        File destinoCarpeta = new File("C:/Temp/Media/Fotos");
        File origenDocumento = new File("C:/Temp/Media/Fotos/fichero1.txt");
        File destinoDocumento = new File("C:/Temp/Media/fichero1.txt");
        
        boolean resultado = origenCarpeta.renameTo(destinoCarpeta);
        System.out.println("Se ha movido y renombrado la carpeta? " + resultado);
        resultado = origenDocumento.renameTo(destinoDocumento);
        System.out.println("Se ha movido y renombrado el documento? " + resultado);

    }
    
}
