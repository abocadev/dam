package dev.boca.actividad1.Pregunta2;
public class GestorDespegue {
    
    Temporizador temporizador = new Temporizador();
    boolean pistaOcupada = false;
    boolean anteriorAvioneta = false;
    int avionesEsperando = 0;
    int avionetasEsperando = 0;
    
    public synchronized void despegarAvion() throws InterruptedException{
        System.out.println("Hay un avion que esta esperando");
        avionesEsperando++;
        while(pistaOcupada) wait();
        System.out.println("El avion va a comenzar a despegar");
        avionesEsperando--;
        temporizador.iniciarTemporizador(true);
        pistaOcupada = true;
        System.out.println("Aviones esperando: " + avionesEsperando
                + "\nAvionetas esperando: " + avionetasEsperando);
    }
    
    public void despegarAvioneta() throws InterruptedException{
        System.out.println("Hay una avioneta que esta esperando");
        avionetasEsperando++;
        while(pistaOcupada) wait();
        System.out.println("La avioneta va a comenzar a despegar");
        avionetasEsperando--;
        anteriorAvioneta = true;
        temporizador.iniciarTemporizador(false);
        pistaOcupada = true;
        System.out.println("Aviones esperando: " + avionesEsperando
                + "\nAvionetas esperando: " + avionetasEsperando);
    }
    
    public void autorizarDespegue(String n){
        System.out.println("Vehiculo que se ha autorizado despegue: " + n);
        pistaOcupada = false;
        notifyAll();
    }
}