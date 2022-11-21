package dev.boca.actividad1.Pregunta1;
public class GestorGarage {
    private final int numPlazas;
    private int numCoches = 0;
    private boolean prioridadE = true;
    private int esperandoE = 0;
    private int esperandoW = 0;
    
    public GestorGarage(int numPlazas){
        this.numPlazas = numPlazas;
    }
    
    public synchronized void entraEste(){
        esperandoE++;
        while(!puedoEntrar(prioridadE, esperandoW)) waiting();
        esperandoE--;
        prioridadE = false;
        numCoches++;
    }
    
    public synchronized void entraOeste(){
        esperandoW++;
        while(!puedoEntrar(prioridadE, esperandoE)) waiting();
        esperandoW--;
        prioridadE = true;
        numCoches++;
    }
    
    public synchronized void saleCoche(){
        numCoches--;
        notifyAll();
    }
    
    private boolean puedoEntrar(boolean miPrioridad, int esperando){
        if(numCoches >= numPlazas) return false;
        if(miPrioridad) return true;
        return esperando == 0;
    }
    
    private void waiting(){
        try {
            wait();
        } catch (InterruptedException e) {
        }
    }
}