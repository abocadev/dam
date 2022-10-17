package dev.boca.Ejercicios.Ejercicio2;

public class EntraJardin extends Thread{
    private RecursoJardin jardin;

    public EntraJardin(String nombre, RecursoJardin j){
        this.setName(nombre);
        this.jardin = j;
    }

    @Override
    public void run(){
        jardin.incrementaCuenta();
    }
}
