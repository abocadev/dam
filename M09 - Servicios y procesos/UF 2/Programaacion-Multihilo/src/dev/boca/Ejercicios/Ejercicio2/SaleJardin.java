package dev.boca.Ejercicios.Ejercicio2;

public class SaleJardin extends Thread{
    private RecursoJardin jardin;

    public SaleJardin(String nombre, RecursoJardin j){
        this.setName(nombre);
        this.jardin = j;
    }

    @Override
    public void run(){
        jardin.decrementaCuenta();
    }
}
