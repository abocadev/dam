package dev.boca.actividad1.Pregunta1;

public class Main {

        public static void main(String[] args) {
            GestorGaraje gg = new GestorGaraje();
            for (int i = 0; i < 50; i++) {
                if (i % 2 == 0) (new Coche(gg, true)).start();
                else (new Coche(gg, false)).start();
            }
            System.out.println("FIN DEL PROGRAMA");
        }
    }



