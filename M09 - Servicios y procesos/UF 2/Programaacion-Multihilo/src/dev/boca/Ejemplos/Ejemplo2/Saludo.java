package dev.boca.Ejemplos.Ejemplo2;

public class Saludo {
    public synchronized void saludoEmpleado(){
        // Aqui espera hasta que llega el jefe
        // hola jefe
    }

    public synchronized void saludoJefe(){
        // Hola soy el jefe notifica su llegada a todos
    }
}
