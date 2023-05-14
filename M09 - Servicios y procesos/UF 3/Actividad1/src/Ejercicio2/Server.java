package Ejercicio2;

import java.io.*;
import java.net.*;

public class Server {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        // Crear un socket de servidor en el puerto 8080
        int puerto = 8080;
        ServerSocket serverSocket = new ServerSocket(puerto);

        // Esperar conexion entrante del cliente
        System.out.println("Esperando conexion entrante del cliente...");
        Socket clientSocket = serverSocket.accept();
        System.out.println("Cliente encontrado");

        // Crear stream de entrada y salida para el socket del cliente
        ObjectOutputStream outToClient = new ObjectOutputStream(clientSocket.getOutputStream());
        ObjectInputStream inFromClient = new ObjectInputStream(clientSocket.getInputStream());

        // Enviar país de ejemplo al cliente
        Pais pais = new Pais("España", 47000000, "Europa", 1391000);
        outToClient.writeObject(pais);
        System.out.println("País enviado al cliente: " + pais.getNombre() + ", " + pais.getHabitantes() + " habitantes, " + pais.getPIB() + " euros");

        // Recibir país modificado del cliente
        pais = (Pais) inFromClient.readObject();
        System.out.println("País recibido del cliente: " + pais.getNombre() + ", " + pais.getHabitantes() + " habitantes, " + pais.getPIB() + " euros");

        // Cerrar streams y sockets
        outToClient.close();
        inFromClient.close();
        clientSocket.close();
        serverSocket.close();
        System.out.println("Conexión cerrada");
    }
}