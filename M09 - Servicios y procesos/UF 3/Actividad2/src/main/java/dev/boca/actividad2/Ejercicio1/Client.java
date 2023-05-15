package dev.boca.actividad2.Ejercicio1;

import java.net.*;
import java.util.*;

public class Client {

    public static void main(String[] args) throws Exception{
        // Crear paquete para recibir datos del servidor
        try ( // Crear socket UDP
                DatagramSocket socket = new DatagramSocket()) {
            // Crear paquete para recibir datos del servidor
            byte[] buffer = new byte[1024];
            DatagramPacket paqueteRecibido = new DatagramPacket(buffer, buffer.length);
            // Generar números aleatorios
            Random random = new Random();
            int[] numerosAleatorios = new int[5];
            for (int i = 0; i < numerosAleatorios.length; i++) {
                numerosAleatorios[i] = random.nextInt(5) + 1;
            }   // Crear paquete con los números aleatorios
            String mensaje = Arrays.toString(numerosAleatorios);
            InetAddress direccion = InetAddress.getByName("localhost");
            int puerto = 12345;
            DatagramPacket paqueteEnviado = new DatagramPacket(mensaje.getBytes(), mensaje.length(), direccion, puerto);
            // Enviar paquete con los números aleatorios
            socket.send(paqueteEnviado);
            System.out.println("Números aleatorios enviados al servidor: " + Arrays.toString(numerosAleatorios));
            // Recibir paquete del servidor con el resultado
            socket.receive(paqueteRecibido);
            String resultado = new String(paqueteRecibido.getData(), 0, paqueteRecibido.getLength());
            System.out.println("Resultado recibido del servidor: " + resultado);
            // Comprobar si el resultado contiene la palabra BINGO
            if (resultado.contains("BINGO")) {
                System.out.println("¡¡¡BINGO!!! Tienes números coincidentes.");
            } else {
                System.out.println("Lo siento, no has ganado.");
            }
            // Cerrar socket
        }
    }
    
}
