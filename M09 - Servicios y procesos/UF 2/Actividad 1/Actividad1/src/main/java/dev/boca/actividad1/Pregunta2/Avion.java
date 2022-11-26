package dev.boca.actividad1.Pregunta2;
public class Avion extends Thread{
    GestorDespegue gd;
    
    public Avion(GestorDespegue gd){
        this.gd = gd;
    }
    
    @Override
    public void run(){
        try {
            gd.despegarAvion();
        } catch (InterruptedException e) {
        }
    }
}
