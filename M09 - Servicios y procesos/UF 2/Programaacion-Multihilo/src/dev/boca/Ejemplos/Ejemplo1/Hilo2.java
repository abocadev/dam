package dev.boca.Ejemplos.Ejemplo1;
public class Hilo2 extends Thread{
    Hilo2() {
        Thread t = new Thread(this, "New Thread");
        System.out.println("Hilo2 Creado");
        t.start();
    }
    public void run(){
        System.out.println("Hello");
        System.out.println("Hilo 2 Finalizado");
    }
}