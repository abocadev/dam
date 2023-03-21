package dev.boca;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Main {
    public static void main(String[] args) {
        try {
            // Creamos el archivo .csv
            File  archivo = new File("archivo.csv");
            if(archivo.createNewFile()) System.out.println("El archivo se ha creado correctamente");
            else System.out.println("No se ha creado correctamente");
            PrintWriter pw = new PrintWriter(archivo);

            // Creamos la cabecera CSV
            StringBuilder sb = new StringBuilder();
            sb.append("Fecha");
            sb.append(",");
            sb.append("Numero");
            sb.append(",");
            sb.append("Booleano");
            sb.append("\n");

            // Creamos los datos de la cabecera
            int contador = 0;
            while(contador < 10000){
                int randomAux = (int)(Math.random()*999999999+1);
                Calendar calendar = new GregorianCalendar();
                String fecha = "" + calendar.get(Calendar.DAY_OF_MONTH) + "/" + calendar.get(Calendar.MONTH) + "/" + calendar.get(Calendar.YEAR);
                boolean bool = randomAux%2==0 ? true : false;
                sb.append(fecha);
                sb.append(",");
                sb.append(randomAux);
                sb.append(",");
                sb.append(bool);
                sb.append("\n");
                contador++;
            }

            // Escribimos los datos en el archivo
            pw.write(sb.toString());
            pw.close();
            System.out.println("Creacion del CSV finalizado");

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}