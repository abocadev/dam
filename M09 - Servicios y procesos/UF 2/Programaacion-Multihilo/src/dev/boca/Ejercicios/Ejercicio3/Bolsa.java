package dev.boca.Ejercicios.Ejercicio3;

import java.util.ArrayList;

public class Bolsa {
    private ArrayList<Producto> listaProductos = new ArrayList<Producto>();

    public void addProducto(Producto producto) {
        if(!estaLlena()){
            listaProductos.add(producto);
        }
    }

    public int getSize(){
        return listaProductos.size();
    }

    public boolean estaLlena(){
        return listaProductos.size() >= 5;
    }
}
