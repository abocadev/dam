package dev.boca.actividad1.Pregunta1;
public class EntraCocheEste extends Thread {
    private GestorGarage gg;
    
    public EntraCocheEste(String nombre, GestorGarage gg){
        this.setName(nombre);
        this.gg = gg;
    }
    
    @Override
    public void run(){
        gg.entraCochePorEste();
    }
}
