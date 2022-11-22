package dev.boca.actividad1.Pregunta2;
public class Temporizador {
    
    public void iniciarTemporizador(boolean avion) throws InterruptedException{
//        int minutos = avion ? 3 : 2 ; 
//        int milisegundos = (minutos * 60) * 1000;
        int segundos = avion ? 5000 : 1000;
        Thread.sleep(segundos);
    }
    
}