package dev.boca.Ejemplos.Semaphores;

import java.util.concurrent.Semaphore;

public class Hilo1 extends Thread{
    protected Semaphore S1;

    public Hilo1(Semaphore S1) {
        this.S1 = S1;
    }

    public void run(){
        try {
            S1.acquire();
        } catch (InterruptedException e) {
        }
        for(int i = 0; i < 10; i++){
            System.out.println("Hola");
        }

        try {
            S1.acquire(5);
        }catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
