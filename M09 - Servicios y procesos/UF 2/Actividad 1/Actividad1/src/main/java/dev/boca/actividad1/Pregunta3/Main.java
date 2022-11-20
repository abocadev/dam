package dev.boca.actividad1.Pregunta3;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        try {
            final int NUM_CLIENTES = 300;
            final int NUM_PRODUCTOS = 100;
            
            List<Cliente> clientes = new ArrayList<>();
            Almacen almacen = new Almacen(NUM_PRODUCTOS);
            Puerta puerta = new Puerta();
            
            for(int i = 0; i < NUM_CLIENTES; i++){
                clientes.add(new Cliente(puerta, almacen, "Cliente " + i));
                
                new Thread(clientes.get(i)).start();
            }
        } catch (Exception e) {
        }
    }
}
