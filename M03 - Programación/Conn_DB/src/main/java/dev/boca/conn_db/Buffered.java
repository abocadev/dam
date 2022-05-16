package dev.boca.conn_db;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Buffered {
    public static void main(String[] args) throws IOException {
        try (BufferedWriter escribe = new BufferedWriter(new FileWriter("flipaBuffered.txt", true));
                BufferedReader lee = new BufferedReader(new FileReader("flipaBuffered.txt"))) 
        {
            escribe.write("Vas a flipar con la lectura linea a linea");
            escribe.newLine();
            escribe.write("Otra linea increible");
            // guardar los cambio, sin cerrar
            escribe.flush();
            String linea = lee.readLine();
            while(linea != null){
                System.out.println(linea);
                linea = lee.readLine();
            }
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }
    
}
