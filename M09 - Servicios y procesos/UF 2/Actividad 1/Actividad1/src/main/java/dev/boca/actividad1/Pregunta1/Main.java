package dev.boca.actividad1.Pregunta1;

public class Main {

        public static void main(String[] args) {
            int contador = 0;
            Garaje garaje = new Garaje();
            for (int i = 1; i <= 10; i++) {
                if (contador % 2 == 0){
                    contador++;
                    (new Coche(garaje, true)).start();
                } else {
                    contador++;
                    (new Coche(garaje, false)).start();
                }
            }
        }
    }



