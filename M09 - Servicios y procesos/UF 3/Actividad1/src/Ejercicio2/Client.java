package Ejercicio2;

import java.io.*;
import java.net.*;
import java.util.*;

public class Client {
    public static void main(String[] args) throws IOException {
        // Establecer conexión con el servidor
        int puerto = 8080;
        Socket socket = new Socket("localhost", puerto);

        // Preparar streams de entrada y salida de objetos
        ObjectOutputStream outputStream = new ObjectOutputStream(socket.getOutputStream());
        ObjectInputStream inputStream = new ObjectInputStream(socket.getInputStream());

        // Leer y mostrar el país enviado por el servidor
        Pais pais = new Pais("Sin pais", 0, "Sin continente", 0);
        try{
            pais = (Pais) inputStream.readObject();
        }catch (ClassNotFoundException e){
        }
        System.out.println("País recibido: " + pais.getNombre() + " (" + pais.getContinente() + ")");
        System.out.println("Habitantes: " + pais.getHabitantes() + ", PIB: " + pais.getPIB());

        // Modificar el país y enviarlo de vuelta al servidor
        Scanner scanner = new Scanner(System.in);
        System.out.print("Introduce nuevo número de habitantes: ");
        int nuevosHabitantes = scanner.nextInt();
        pais.setHabitantes(nuevosHabitantes);

        System.out.print("Introduce nuevo valor del PIB: ");
        int nuevoPIB = scanner.nextInt();
        pais.setPIB(nuevoPIB);

        outputStream.writeObject(pais);

        // Leer y mostrar el país actualizado enviado por el servidor
        try{
            pais = (Pais) inputStream.readObject();
        }catch (Exception e){
        }
        System.out.println("País actualizado: " + pais.getNombre() + " (" + pais.getContinente() + ")");
        System.out.println("Habitantes: " + pais.getHabitantes() + ", PIB: " + pais.getPIB());

        // Cerrar streams y conexión
        outputStream.close();
        inputStream.close();
        socket.close();
    }
}
