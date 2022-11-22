package dev.boca.actividad1.Pregunta1;
public class GestorGaraje {
    final int maxPlazas = 20;
    int ocupadas = 0;
    int esperandoE = 0;
    int esperandoO = 0;
    boolean prioridadE = true;

    public synchronized void entraEste() throws InterruptedException {
        System.out.println("En el este intenta entrar un coche.");
        esperandoE++;
        while (!puedoEntrar(prioridadE, esperandoO)) {
            System.out.println("El coche este esta esperando.");
            wait();
        }
        esperandoE--;
        System.out.println("Coche este  ha entrado.");
        prioridadE = false;
        ocupadas++;
        System.out.println("Hay " + ocupadas + " plazas ocupadas");
    }

    public synchronized void entraOeste() throws InterruptedException {
        System.out.println("En el oeste intenta entrar un coche");
        esperandoO++;
        while (!puedoEntrar(!prioridadE, esperandoE)) {
            System.out.println("Hay un coche en el oeste esperando");
            wait();
        }
        esperandoO--;
        System.out.println("Coche oeste ha entrado.");
        prioridadE = true;
        ocupadas++;
        System.out.println("Hay " + ocupadas + " plazas ocupadas.");
    }

    public boolean puedoEntrar(boolean prioridad, int esperando) {
        if (esperando > maxPlazas) return false; 
        if (ocupadas == maxPlazas) return false;
        if (prioridad) return true; 
        else return false;

    }

    public synchronized void salirCoche() {
        ocupadas--;
        System.out.println("Hay " + ocupadas + " plazas ocupadas.");
        notifyAll();
    }
}