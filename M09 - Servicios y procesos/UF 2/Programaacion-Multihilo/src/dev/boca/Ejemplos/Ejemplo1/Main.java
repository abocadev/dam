package dev.boca.Ejemplos.Ejemplo1;
public class Main {
    public static void main(String[] args) {
        new HelloThread();
        new Hilo2();
        System.out.println("Hola desde el proceso");
        System.out.println("Main finalizado");
    }
}