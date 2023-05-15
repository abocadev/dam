package dev.boca.actividad2.Ejercicio1;

import java.net.*;
import java.util.*;

public class Client {

    public static void main(String[] args) throws Exception {
        Random r = new Random();

        // Primer cliente
        DatagramSocket socketClient1 = new DatagramSocket(1234);
        String clientNumbers = "";
        for(int i = 0; i < 5; i++){
            clientNumbers += (1 + r.nextInt(5)) + " ";
        }
        System.out.println("Numeros generados aleatoriamente del servidor 2: " + clientNumbers);
        
        byte[] buffer = clientNumbers.getBytes();
        DatagramPacket packet1 = new DatagramPacket(buffer, buffer.length);
        socketClient1.receive(packet1);
        String serverNumbers = new String(packet1.getData(), 0, packet1.getLength());
        System.out.println("Numeros del servidor: " + serverNumbers);
        System.out.println("Numeros del cliente: " + clientNumbers);

        if(clientNumbers.equals(serverNumbers)) System.out.println("BINGO!!!");
        else System.out.println("No has ganado");
        
        // Segundo cliente
        Thread.sleep(3000);
        DatagramSocket socketClient2 = new DatagramSocket(2345);
        String clientNumbers2 = "";
        for(int i = 0; i < 5; i++){
            clientNumbers2 += (1 + r.nextInt(5)) + " ";
        }
        System.out.println("Numeros generados aleatoriamente del servidor 2: " + clientNumbers);
        
        buffer = clientNumbers2.getBytes();
        DatagramPacket packet2 = new DatagramPacket(buffer, buffer.length);
        socketClient2.receive(packet1);
        String serverNumbers2 = new String(packet2.getData(), 0, packet2.getLength());
        System.out.println("Numeros del servidor: " + serverNumbers2);
        System.out.println("Numeros del cliente: " + clientNumbers2);

        if(clientNumbers2.equals(serverNumbers2)) System.out.println("BINGO!!!");
        else System.out.println("No has ganado");
    }
}
