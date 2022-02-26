package dev.boca.ficheros;

import java.io.File;

public class E011unidades {
    public static void main(String[] args) {
        E011unidades programa = new E011unidades();
        programa.inicio();
    }
    public void inicio(){
        try {
            File[] unidades = File.listRoots();
            for(int i = 0; i<unidades.length; i++){
                System.out.println(unidades[i] + " - Tamanyo total: " + unidades[i].getTotalSpace() + " - Tamanyo disponible: " + unidades[i].getFreeSpace());
            }
        } catch (Exception e) {
            System.out.println("Error en el programa: " + e);
        }
    }
}
