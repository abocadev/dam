package dev.boca.actividad1.Pregunta2;
public class Main {
    public static void main(String[] args) {
        GestorDespegue gd = new GestorDespegue();
        
        for(int i = 0; i < 20; i++){
            if(i%2 == 0) (new Avion(gd)).start(); 
            else (new Avioneta(gd)).start();
        }
    }
}
