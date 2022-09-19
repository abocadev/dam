package dev.boca.Ejemplos.Ejemplo1;
public class HelloThread  implements Runnable{
    public HelloThread(){
        Thread t = new Thread(this, "New Thread");
        System.out.println("Hilo 1 Creado");
        t.start();
    }
    public void run(){
        System.out.println("Hola");
        System.out.println("Hilo finalizado");
    }
}