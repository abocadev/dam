package dev.boca.actividad1.Pregunta1;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        final int NUM_PLAZAS = 100;
        final int NUM_COCHES = 300;
        
        Parking p = new Parking();
        GestorGarage gg = new GestorGarage();
        
        for(int i = 0; i < NUM_COCHES; i++){
            new Thread(new Coche(gg, p, i)).start();
        }
    }
}
