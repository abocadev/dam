package dev.boca.Ejercicios.Ejercicio1;

public class Hilo2 extends Thread{
    Hilo2() {
        Thread t = new Thread(this, "Hilo2");
    }

    public void run() {
       String [] abc = {"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","U","V","W","X","Y","Z"};
        for(String letter: abc){
            System.out.println(letter);
        }
    }
}
