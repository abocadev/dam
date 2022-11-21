package dev.boca.actividad1.Pregunta1;

public class Coche extends Thread {

    Garaje garaje = new Garaje();
    Boolean PuertaE;
    int contador = 0;

    public Coche(Garaje g, Boolean PuertaE) {

        this.garaje = g;
        this.PuertaE = PuertaE;
    }

    @Override
    public void run() {


        System.out.println("Contador: " + contador);
        try {
            if (PuertaE) {
                contador++;
                garaje.EntraCocheEste();
                Thread.sleep(10000);
                garaje.salirCoche();
            } else {
                contador++;
                garaje.EntraCocheOeste();
                Thread.sleep(10000);
                garaje.salirCoche();
            }

        } catch (InterruptedException e) {
            System.out.println("Exception: " + e);
        }

    }
}
