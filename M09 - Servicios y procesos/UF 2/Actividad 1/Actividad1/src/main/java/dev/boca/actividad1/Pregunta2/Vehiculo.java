package dev.boca.actividad1.Pregunta2;
public class Vehiculo extends Thread{
    
    GestorDespegue gd;
    boolean VehiculoAvion;
    
    public Vehiculo(GestorDespegue gd, boolean VehiculoAvion){
        this.gd = gd;
        this.VehiculoAvion = VehiculoAvion;
    }
    
    @Override
    public void run(){
        try {
            if(VehiculoAvion){
                if(gd.anteriorAvioneta){
                    gd.despegarAvion();
                    gd.autorizarDespegue(true);
                }

            }else{
                if(!gd.anteriorAvioneta){
                    gd.despegarAvioneta();
                    gd.autorizarDespegue(false);
                }
            }
            
        } catch (InterruptedException e) {
        }
        
    }
}
