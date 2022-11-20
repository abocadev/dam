package dev.boca.actividad1.Pregunta3;
public class Puerta {
    boolean ocupada;
    
    public Puerta(){
        this.ocupada = false;
    }
    
    public boolean estaOcupada(){
        return this.ocupada;
    }
    
    public synchronized void liberarPuerta(){
        this.ocupada = false;
    }
    
    public synchronized boolean intentarEntrar(){
        if (this.ocupada) return false;
        this.ocupada = true;
        return true;
    }
}
