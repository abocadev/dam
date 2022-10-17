package dev.boca.Ejercicios.Ejercicio2;

public class RecursoJardin {
    private int cuenta;

    public RecursoJardin(){
        cuenta = 50;
    }

    public void incrementaCuenta(){
        System.out.println("hilo " + Thread.currentThread().getName());
        cuenta++;
        System.out.println(cuenta + " en jardin");
    }

    public void decrementaCuenta(){
        System.out.println("hilo " + Thread.currentThread().getName());
        cuenta--;
        System.out.println(cuenta + " en jardin");
    }
}
