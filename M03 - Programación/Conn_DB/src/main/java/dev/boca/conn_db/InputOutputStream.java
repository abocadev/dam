package dev.boca.conn_db;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class InputOutputStream {
    public static void main(String[] args) {
        try (
                FileInputStream fis = new FileInputStream("imagen.jpg");
        ){
            String texto = "Prueba para ficheros binarios";
            // copiar el texto en un array de bytes
            byte codigo[] = texto.getBytes();
            fis.write(codigo);
        } catch (Exception e) {
        }
    }
    
}
