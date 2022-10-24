package dev.boca.Ejemplos.Semaphores;

import java.util.concurrent.Semaphore;

public class Hilo2 extends Thread{

    protected Semaphore S2;
    public Hilo2(Semaphore S1) {
        this.S2 = S2;
    }

    public void run(){
        try {
            S2.acquire();
        } catch (InterruptedException e) {
        }
        for(int i = 0; i < 10; i++){
            System.out.println("Adios");
        }

        try {
            S2.acquire(5);
        }catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
