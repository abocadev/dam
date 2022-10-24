package dev.boca.Ejemplos.Semaphores;

import java.util.concurrent.Semaphore;

public class Main {
    protected static Semaphore S1;

    public static void main(String[] args) {
        //S1 = new Semaphore(numero de hilos, booleano de justicia);
        try {
            S1 = new Semaphore(3, true);
            Hilo1 hilo = new Hilo1(S1);
            Hilo2 hilo2 = new Hilo2(S1);
            hilo.start();
        }catch (Exception e) {
        }
    }
}