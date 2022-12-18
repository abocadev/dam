package dev.boca.actividad2.pregunta2;
public class Main {
    public static void main(String[] args) {
        GestorMuseo gm = new GestorMuseo();
        for(int i = 0; i < 150; i++) {
             if(i % 3 == 0) new PersonasJubiladas(gm).start();
             else new PersonasNormales(gm).start();
        }
    }
}
