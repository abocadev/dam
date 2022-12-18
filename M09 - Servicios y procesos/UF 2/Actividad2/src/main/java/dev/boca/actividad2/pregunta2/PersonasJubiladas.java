package dev.boca.actividad2.pregunta2;

import java.util.Random;

public class PersonasJubiladas extends Thread{

    private GestorMuseo gm;
    public PersonasJubiladas(GestorMuseo gm){
        this.gm = gm;
    }

    @Override
    public void run(){
        int rTemp = new Random().nextInt(50);
        System.out.println("Numero aleatorio: " + rTemp);
        gm.notifyTemperatura(rTemp);
        try {
            gm.entrarJubilado();
            rTemp *= 100;
            Thread.sleep(rTemp);
            gm.salirSala();
        }catch (Exception e){
        }
    }
}
