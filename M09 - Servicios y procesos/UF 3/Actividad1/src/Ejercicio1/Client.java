package Ejercicio1;

import java.io.*;
import java.net.*;

public class Client {
    public static void main(String[] args) throws IOException {
        int puerto = 8080;
        Socket clientSocket = new Socket("localhost", puerto);
        System.out.println("Cliente conectado al servidor...");

        BufferedReader entrada = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        PrintWriter salida = new PrintWriter(clientSocket.getOutputStream(), true);

        BufferedReader entradaCliente = new BufferedReader(new InputStreamReader(System.in));
        String mensaje;
        while((mensaje = entradaCliente.readLine()) != null){
            salida.println("Cliente: " + mensaje);
            System.out.println(entrada.readLine());
            if(mensaje.equalsIgnoreCase("salir")) break;
        }
        salida.close();
        entrada.close();
        entradaCliente.close();
        clientSocket.close();
        System.out.println("Conexion cerrada");
    }
}
