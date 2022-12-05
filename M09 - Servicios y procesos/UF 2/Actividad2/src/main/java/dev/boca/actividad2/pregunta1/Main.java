package dev.boca.actividad2.pregunta1;
public class Main {
    public static void main(String[] args) {
        GestorAlmacen ga = new GestorAlmacen();
        
        for(int i = 0; i < 20; i++){
            if(i % 3 == 0) new Productores(ga).start();
            else new Consumidores(ga).start();
        }
        
        for(int i = 0; i < 4; i++){
            new Consumidores(ga).start();
        }
        
    }
}
