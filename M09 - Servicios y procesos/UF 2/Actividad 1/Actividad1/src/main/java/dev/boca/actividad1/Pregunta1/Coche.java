package dev.boca.actividad1.Pregunta1;

import java.util.Random;

public class Coche extends Thread{
    GestorGarage gg;
    boolean cocheEste;
    public Coche(GestorGarage gg, boolean cocheEste){
        this.gg = gg;
    }
    
    @Override
    public void run(){
        if(cocheEste){
            gg.entraEste();
        }else{
            gg.entraOeste();
        }
        try {
            Thread.sleep(new Random().nextInt(10000)+1);
        } catch (InterruptedException ex) {
        }
        gg.saleCoche();
    }
}
