package dev.boca.actividad1.Pregunta3;

public class Main {
    public static void main(String[] args) {
        try {
            final int NUM_CLIENTES = 300;
            final int NUM_PRODUCTOS = 100;
            
            Almacen almacen = new Almacen(NUM_PRODUCTOS);
            Puerta puerta = new Puerta();
            
            for(int i = 0; i < NUM_CLIENTES; i++){
                new Thread(new Cliente(puerta, almacen, "Cliente " + i)).start();
            }
        } catch (Exception e) {
        }
    }
}
