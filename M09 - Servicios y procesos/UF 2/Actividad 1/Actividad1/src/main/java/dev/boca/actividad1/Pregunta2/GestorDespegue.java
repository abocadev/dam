package dev.boca.actividad1.Pregunta2;
public class GestorDespegue {
   
    boolean pistaOcupada = false;
    int avionesEsperando = 0;
    int avionetasEsperando = 0;
    boolean anteriorAvioneta = false;
    
    public synchronized void despegarAvion() throws InterruptedException{
        avionesEsperando++;
        while(pistaOcupada) wait();
        pistaOcupada = true;
        avionesEsperando--;
        anteriorAvioneta = false;
        System.out.println("Va a despegar un avion");
        System.out.println("Aviones Esperando: " + avionesEsperando
                            + "\nAvionetas Esperando: " + avionetasEsperando);
        
        Thread.sleep(10000);
        autorizarDespegue();
    }
    
    public synchronized void despegarAvioneta() throws InterruptedException{
        avionetasEsperando++;
        while(pistaOcupada || avionesEsperando > 0 || anteriorAvioneta) wait();
        avionetasEsperando--;
        pistaOcupada = true;
        anteriorAvioneta = true;
        System.out.println("Va a despegar una avioneta");
        System.out.println("Aviones Esperando: " + avionesEsperando
                            + "\nAvionetas Esperando: " + avionetasEsperando);
        Thread.sleep(3000);
        autorizarDespegue();
        
    }

    private synchronized void autorizarDespegue() {
        pistaOcupada = false;
        notifyAll();
        System.out.println("-----------------------------------------------------------------");
        System.out.println("Ahora la pista esta libre");
        System.out.println("Aviones Esperando: " + avionesEsperando
                            + "\nAvionetas Esperando: " + avionetasEsperando);
        System.out.println("-----------------------------------------------------------------");
    }
}