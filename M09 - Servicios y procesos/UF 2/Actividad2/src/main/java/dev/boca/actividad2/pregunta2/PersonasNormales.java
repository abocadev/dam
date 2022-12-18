package dev.boca.actividad2.pregunta2;

import java.util.Random;

public class PersonasNormales extends Thread{
    private GestorMuseo gm;
    public PersonasNormales(GestorMuseo gm){
        this.gm = gm;
    }

    @Override
    public void run(){
        int rTemp = new Random().nextInt(50);
        gm.notifyTemperatura(rTemp);
        try {
            gm.entrarSala();
            rTemp *= 100;
            Thread.sleep(rTemp);
            gm.salirSala();
        }catch (Exception e){
        }
    }
}
