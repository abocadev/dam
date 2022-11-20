package dev.boca.actividad1.Pregunta1;

import java.util.Random;

public class GestorGarage {
    
    private int PLAZAS = 0;
    
    int numCoches = 0; // Coches que estan dentro del parking
    int esperandoE = 0; // Coches que estan esperando en el ESTE
    int esperandoW = 0; // Coches que estan esperando en el OESTE
    
    boolean prioridad;   
    
    public GestorGarage(int numPlazas){
        PLAZAS = numPlazas;
        prioridad = true;
    }
    
    
    public void entraCochePorEste(){
        System.out.println("hilo " + Thread.currentThread().getName() + "----------- Entra coche por este.");
        esperandoE++;
        if(prioridad){
            if (numCoches < PLAZAS) {
                esperandoE--;
                numCoches++;
            }
        }else{
            if(esperandoW == 0) if(numCoches < PLAZAS){
                esperandoE--;
                numCoches++;
            }
        }
        System.out.println("Coche esperando por ESTE: " + esperandoE
                + "Coches esperando por OESTE: " + esperandoW
                + "Coches dentro del parking: " + numCoches
                + "----------------------------------------\n");
    }
    
    
    public void entraCochePorOeste(){
        System.out.println("hilo " + Thread.currentThread().getName() + "----------- Entra Coche por OESTE");
        esperandoW++;
        if(prioridad){
            if(esperandoE == 0 && numCoches < PLAZAS){
                esperandoW--;
                numCoches++;
            }
        }else{
            if(numCoches < PLAZAS){
                esperandoW--;
                numCoches++;
            }
        }
        System.out.println("Coche esperando por ESTE: " + esperandoE
                + "Coches esperando por OESTE: " + esperandoW
                + "Coches dentro del parking: " + numCoches
                + "----------------------------------------\n");
    }
    
    public void introducirCochePorEste(){
       
    }
    
    public void introducirCochePorOeste(){
        
    }
    
    public void esperar() throws InterruptedException{
        Random r = new Random();
        int num = r.nextInt(10000)+1;
        Thread.sleep(num);
    }
    
    public void saleCoche(){
        System.out.println("Hilo " + Thread.currentThread().getName() + "------------ Sale coche del parking");
        if(numCoches <= 0) System.out.println("El parking esta vacio");
        else numCoches--;
    }
}
