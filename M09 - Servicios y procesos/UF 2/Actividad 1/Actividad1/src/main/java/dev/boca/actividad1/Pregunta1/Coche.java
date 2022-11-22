package dev.boca.actividad1.Pregunta1;

public class Coche extends Thread {

    GestorGaraje gg = new GestorGaraje();
    boolean entradaEste;

    public Coche(GestorGaraje g, boolean entradaEste) {

        this.gg = g;
        this.entradaEste = entradaEste;
    }

    @Override
    public void run() {
        try {
            if (entradaEste) {
                gg.entraEste();
                Thread.sleep(3000);
                gg.salirCoche();
            } else {
                gg.entraOeste();
                Thread.sleep(10000);
                gg.salirCoche();
            }

        } catch (InterruptedException e) {
        }

    }
}
