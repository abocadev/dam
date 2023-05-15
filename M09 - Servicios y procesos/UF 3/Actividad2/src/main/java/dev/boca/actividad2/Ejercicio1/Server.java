package dev.boca.actividad2.Ejercicio1;

import java.io.IOException;
import java.util.*;
import java.net.*;
public class Server {
    public static void main(String[] args) {
        final int TAM_BUFFER = 1024;
        final int PUERTO = 5000;
        final int NUM_NUMEROS = 5;
        Random rand = new Random();

        try (DatagramSocket socket = new DatagramSocket(PUERTO)) {
            byte[] buffer = new byte[TAM_BUFFER];

            // Generar los números aleatorios
            int[] numeros = new int[NUM_NUMEROS];
            for (int i = 0; i < NUM_NUMEROS; i++) {
                numeros[i] = rand.nextInt(5) + 1;
            }

            // Mostrar los números generados
            System.out.print("Numeros generados: ");
            for (int i = 0; i < NUM_NUMEROS; i++) {
                System.out.print(numeros[i] + " ");
            }
            System.out.println();

            // Mandar los números a los clientes
            InetAddress direccionCliente1 = InetAddress.getByName("localhost");
            InetAddress direccionCliente2 = InetAddress.getByName("localhost");
            int puertoCliente1 = 6000;
            int puertoCliente2 = 7000;

            for (int i = 0; i < NUM_NUMEROS; i++) {
                buffer = Integer.toString(numeros[i]).getBytes();

                DatagramPacket paquete1 = new DatagramPacket(buffer, buffer.length, direccionCliente1, puertoCliente1);
                DatagramPacket paquete2 = new DatagramPacket(buffer, buffer.length, direccionCliente2, puertoCliente2);

                socket.send(paquete1);
                socket.send(paquete2);
            }

        } catch (SocketException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}