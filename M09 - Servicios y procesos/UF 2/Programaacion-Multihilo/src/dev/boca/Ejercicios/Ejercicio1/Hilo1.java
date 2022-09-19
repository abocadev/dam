package dev.boca.Ejercicios.Ejercicio1;

public class Hilo1 extends Thread{
    Hilo1(){
        Thread t = new Thread(this, "Hilo1");
    }


    public void run(){
        for(int i=0; i < 100; i+=3){
            System.out.println(i);
        }
    }
}
