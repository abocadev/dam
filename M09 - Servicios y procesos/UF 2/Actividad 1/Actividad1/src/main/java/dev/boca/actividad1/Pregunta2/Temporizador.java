package dev.boca.actividad1.Pregunta2;
public class Temporizador {
    
    public void iniciarTemporizador(boolean avion){
//        int minutos = avion ? 3 : 2 ; 
//        int milisegundos = (minutos * 60) * 1000;
        int segundos = avion ? 5000 : 1000;
        try {
            Thread.sleep(segundos);
        } catch (Exception e) {
        }
    }
    
}