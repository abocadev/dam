package dev.boca.Ejercicios.Ejercicio1;

public class Main {
    public static void main(String[] args) {
        new Hilo1().start();
        new Hilo2().start();
        System.out.println("Programa acabado");
    }
}
