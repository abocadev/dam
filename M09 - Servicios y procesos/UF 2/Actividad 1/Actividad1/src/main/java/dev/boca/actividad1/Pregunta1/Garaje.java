package dev.boca.actividad1.Pregunta1;
public class Garaje {
    final int maxPlazas = 5;
    int plazasOcupadas = 0;
    int esperandoE = 0;
    int esperandoO = 0;
    int contadorEste = 0;
    int contadorOeste = 0;
    boolean prioridadE = true;

    public synchronized void EntraCocheEste() throws InterruptedException {
        contadorEste++;
        System.out.println("Coche este " + contadorEste + " intenta entrar.");
        esperandoE++;
        while (!puedoEntrar(prioridadE, esperandoO)) {
            System.out.println("El coche este " + contadorEste + " esta esperando.");
            wait();
        }
        esperandoE--;
        System.out.println("Coche este " + contadorEste + " ha entrado.");
        prioridadE = false;
        plazasOcupadas++;
        System.out.println("Plazas actuales: " + (maxPlazas - plazasOcupadas));
    }

    public synchronized void EntraCocheOeste() throws InterruptedException {
        contadorOeste++;
        System.out.println("Coche oeste " + contadorOeste + " intenta entrar.");
        esperandoO++;
        while (!puedoEntrar(!prioridadE, esperandoE)) {
            System.out.println("El coche oeste " + contadorOeste + " esta esperando.");
            wait();
        }
        esperandoO--;
        System.out.println("Coche oeste " + contadorEste + " ha entrado.");
        prioridadE = true;
        plazasOcupadas++;
        System.out.println("Plazas actuales: " + (maxPlazas - plazasOcupadas));
    }

    public boolean puedoEntrar(boolean prioridad, int esperando) {
        if (esperando > maxPlazas) {
            return false;
        }
        if (plazasOcupadas == maxPlazas) {
            return false;
        }
        if (prioridad) {
            return true;
        } else {
            return false;
        }

    }

    public synchronized void salirCoche() {
        plazasOcupadas--;
        System.out.println("Ha salido un coche, el numero de espacios actual es de " + plazasOcupadas);
        notifyAll();
    }
}