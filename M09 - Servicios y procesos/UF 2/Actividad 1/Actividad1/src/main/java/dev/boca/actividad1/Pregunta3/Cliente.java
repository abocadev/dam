package dev.boca.actividad1.Pregunta3;

import java.util.Random;

public class Cliente extends Thread{
    Puerta puerta;
    Almacen almacen;
    String nombre;
    Random generador;
    
    final int MAX_INTENTOS = 10;
    
    public Cliente(Puerta p, Almacen a, String nombre){
        this.puerta = p;
        this.almacen = a;
        this.nombre = nombre;
        generador = new Random();
    }
    
    public void esperar(){
        try {
            Thread.sleep(generador.nextInt(100));
        } catch (InterruptedException e) {
            System.out.println("Error: " + e);
        }
    }
    
    @Override
    public void run(){
        for(int i = 0; i < MAX_INTENTOS; i++){
            if(!puerta.estaOcupada()){
                if(puerta.intentarEntrar()){
                    esperar();
                    puerta.liberarPuerta();
                    if(almacen.cogerProducto()){
                        System.out.println(this.nombre + ": cogi un producto!");
                        return ;
                    }else{
                        System.out.println(this.nombre + ": ops, cruce pero no cogi nada");
                        return ;
                    }
                }
            }else esperar();
        }
        System.out.println(this.nombre +
                ": lo intente muchas veces y no pude");
    }
}
