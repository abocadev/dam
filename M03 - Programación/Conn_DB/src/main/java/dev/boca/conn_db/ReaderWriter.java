package dev.boca.conn_db;

import java.io.FileReader;
import java.io.FileWriter;

public class ReaderWriter {
    public static void main(String[] args) {
        try(FileWriter escribe = new FileWriter("flipa.txt");) {
            // abrimos el stream, si no existe el fichero, lo creara
            
            // escribir en el fichero
            escribe.write("Este es un ejemplo de escritura de un fichero");
            escribe.write("\r\n");
            escribe.write(105);
            escribe.close();
            
            // abro stream para lectura, el fichero debe existe
            FileReader lectura = new FileReader("flipa.txt");
            // leo el fichero y lo imprimo
            int valor = lectura.read();
            while(valor!= -1){
                System.out.println((char)valor);
                valor = lectura.read();
            }
        } catch (Exception e) {
            System.out.println("Error: " + e);
                    
        }
    }
    
}
