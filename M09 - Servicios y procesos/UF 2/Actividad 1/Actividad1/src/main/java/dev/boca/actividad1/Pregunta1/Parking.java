
package dev.boca.actividad1.Pregunta1;

public class Parking {
    public final int MAX_PLAZAS;
    int plazasOcupadas = 0;
    
    public Parking(int MAX_PLAZAS){
        this.MAX_PLAZAS = MAX_PLAZAS;
    }
    
    public void entraCoche(){
        if (plazasOcupadas < MAX_PLAZAS) plazasOcupadas++;
    }
    
    public void saleCoche(){
        if(plazasOcupadas > 0) plazasOcupadas--;
    }
    
    public boolean estaLleno(){
        return MAX_PLAZAS != plazasOcupadas ? true : false;
    }
}
