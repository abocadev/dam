package dev.boca.ficheros;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.Scanner;

public class E021notasNuevoFichero {
       
    public static void main(String[] args) {
        E021notasNuevoFichero programa = new E021notasNuevoFichero();
        programa.inicio();
    }
    
    public void inicio(){
        try {
            File f = new File("conversacion.txt");
            PrintStream escritura = new PrintStream(f);      
            String Nombre1 = "Albert";
            String Nombre2 = "Jose";
            escritura.println("Esta conversacion la compone entre: " + Nombre1 + " y " + Nombre2);
            conversacion(Nombre1, Nombre2, f);
            escritura.close();
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }
    
    public void conversacion(String a, String b, File f){
        try {
            int turno = 0;
            PrintWriter sobreEscritura = new PrintWriter(new FileWriter(f, true));
            boolean fin = false;
            Scanner entrada = new Scanner(System.in);
            while(!fin){
                String texto;
                if(turno == 0){
                    texto = entrada.nextLine();
                    sobreEscritura.println(a + ": " + texto);
                    turno++;
                }else{
                    texto = entrada.nextLine();
                    sobreEscritura.println(b + ": " + texto);
                    turno--;
                }
                if(texto.equals("f")){
                    fin = true;
                }
            }
            sobreEscritura.close();
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }
    
}
