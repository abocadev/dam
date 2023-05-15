package dev.boca.actividad2.Ejercicio1;

import java.util.*;
import java.net.*;
import java.io.*;

public class Server {
    public static void main(String[] args)throws Exception {
        int puerto = 8080;
        DatagramSocket serverSocket = new DatagramSocket(puerto);
        Random r = new Random();
        
        // Enviamos al primer cliente
        String stringBuffer = "";
        for(int i = 0; i < 5; i++){
            stringBuffer += (1 + r.nextInt(5)) + " ";
        }
        System.out.println("Numeros generados aleatoriamente del servidor 1: " + stringBuffer);
        
        byte[] buffer = stringBuffer.getBytes();
        
        InetAddress address1 = InetAddress.getByName("localhost");
        DatagramPacket packet1 = new DatagramPacket(buffer, buffer.length, address1, 1234);
        serverSocket.send(packet1);
        
        // Enviamos al segundo cliente
        Thread.sleep(5000);

        stringBuffer = "";
        for(int i = 0; i < 5; i++){
            stringBuffer += (1 + r.nextInt(5)) + " ";
        }
        System.out.println("Numeros generados aleatoriamente del servidor 2: " + stringBuffer);
        
        buffer = stringBuffer.getBytes();
        InetAddress address2 = InetAddress.getByName("localhost");
        DatagramPacket packet2 = new DatagramPacket(buffer, buffer.length, address2, 2345);
        serverSocket.send(packet2);
    }
}