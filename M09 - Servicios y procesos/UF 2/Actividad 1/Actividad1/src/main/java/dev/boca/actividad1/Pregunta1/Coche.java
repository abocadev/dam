package dev.boca.actividad1.Pregunta1;
public class Coche extends Thread{
    
    String nombre;
    GestorGarage gg;
    Parking parking;
    public Coche (GestorGarage gg, Parking p, int ID){
        this.gg = gg;
        this.parking = p;
        this.nombre = "Coche " + ID;
    }
    
    public void esperar(){
        try {
            System.out.println("El coche:" + nombre + " esta esperando");
            wait();
        } catch (InterruptedException e) {
        }
    }
    
    @Override
    public void run(){
        while(parking.estaLleno()) esperar();
        if(ID % 4 == 0) gg.entrarEste();
        else gg.entrarOeste();
    }
}
