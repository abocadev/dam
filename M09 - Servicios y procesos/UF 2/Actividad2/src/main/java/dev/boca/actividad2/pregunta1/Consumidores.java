package dev.boca.actividad2.pregunta1;

public class Consumidores extends Thread {
    
    private GestorAlmacen ga;
    
    public Consumidores(GestorAlmacen ga){
        this.ga = ga;
    }
    
    @Override
    public void run(){
        try {
            ga.solicitar(2);
        } catch (InterruptedException ex) {
        }
    }
}