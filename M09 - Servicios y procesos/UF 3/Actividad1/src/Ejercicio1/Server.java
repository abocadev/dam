package Ejercicio1;

import java.io.*;
import java.net.*;

public class Server {

    public static void main(String[] args) throws IOException {

        // Creamos socket de servidor en el puerto 8080
        int puerto = 8080;
        ServerSocket serverSocket = new ServerSocket(puerto);

        // Esperando la respuesta al cliente...
        System.out.println("Servidor abierto en el puerto: " + puerto);
        System.out.println("Esperando al cliente...");

        // Cliente encontrado
        Socket clientSocket = serverSocket.accept();
        System.out.println("Cliente encontrado");

        // Crear stream de entrada y salida para el socket del cliente
        BufferedReader entrada = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        PrintWriter salida = new PrintWriter(clientSocket.getOutputStream(), true);

        BufferedReader entradaServer = new BufferedReader(new InputStreamReader(System.in));
        String mensaje;
        while((mensaje = entradaServer.readLine()) != null){
            salida.println("Servidor: " + mensaje);
            System.out.println(entrada.readLine());
            if (mensaje.equalsIgnoreCase("salir")) break;
        }

        // Cerrar streams y sockets
        entrada.close();
        salida.close();
        clientSocket.close();
        serverSocket.close();
        System.out.println("Conexion cerrada");
    }
}