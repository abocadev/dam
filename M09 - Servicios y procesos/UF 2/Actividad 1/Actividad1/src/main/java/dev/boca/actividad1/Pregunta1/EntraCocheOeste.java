package dev.boca.actividad1.Pregunta1;
public class EntraCocheOeste extends Thread {
    private GestorGarage gg;
    
    public EntraCocheOeste(String nombre, GestorGarage gg){
        this.setName(nombre);
        this.gg = gg;
    }
    
    @Override
    public void run(){
        gg.entraCochePorOeste();
    }
}
