package dev.boca.actividad2.pregunta1;
public class GestorAlmacen {
    private int cantidad = 0;
    private boolean peticionPendiente = false;
    
    public synchronized void solicitar(int cantidadPiezas) throws InterruptedException{
        System.out.println("Hay un solicitado en espera");
        while (peticionPendiente) wait();
        peticionPendiente = true;
        
        System.out.println("Hay un solicitado esperando piezas");
        while(cantidad < cantidadPiezas) wait();
        
        System.out.println("Han sacado " + cantidadPiezas + " piezas.");
        cantidad -= cantidadPiezas;
        peticionPendiente = false;
        notifyAll();
        System.out.println("En total " + cantidad + " piezas en total.");
    }
    
    public synchronized void agregar(int cantidadPiezas) throws InterruptedException{
        System.out.println("Han agregado " + cantidadPiezas + " piezas.");
        cantidad += cantidadPiezas;
        notifyAll();
        System.out.println("En total " + cantidad + " piezas en total.");
    }
}
