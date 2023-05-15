package dev.boca.actividad2.Ejercicio1;

import java.net.*;
import java.util.*;

public class Client {

    public static void main(String[] args) throws Exception {
        Random r = new Random();

        DatagramSocket socketClient1 = new DatagramSocket(1234);
        String stringBuffer = "";
        for(int i = 0; i < 5; i++){
            stringBuffer += (1 + r.nextInt(5)) + " ";
        }
        System.out.println("Numeros generados aleatoriamente del servidor 2: " + stringBuffer);
        
        byte[] buffer = stringBuffer.getBytes();
        DatagramPacket packet1 = new DatagramPacket(buffer, buffer.length);
        socketClient1.receive(packet1);
        String message = new String(packet1.getData(), 0, packet1.getLength());
        String[] numsStrings = message.trim().split(" ");
        Set<Integer> serverNumbers = new HashSet<>();
        for(String part: numsStrings){
            serverNumbers.add(Integer.parseInt(part));
        }
        
        Set<Integer> clientNumbers = new HashSet<>();
        String[] aux = stringBuffer.trim().split(" ");
        for(String part: aux){
            clientNumbers.add(Integer.parseInt(part));
        }
        System.out.println("Numeros del servidor: " + serverNumbers.toString());
        System.out.println("Numeros del cliente sin hashear: " + stringBuffer);
        System.out.println("Numeros del cliente: " + clientNumbers.toString());

        /*if(.equals(serverNumbers)) System.out.println("BINGO!!!");
        else System.out.println("No has ganado");*/
    }
}
