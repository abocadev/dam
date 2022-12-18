package dev.boca.actividad2.pregunta2;

import java.sql.SQLOutput;

public class GestorMuseo {
    private final int numMaxPersNorm = 50,
            numMaxPersAltaTemp = 30,
            temperatura = 30;

    private int nPersonas = 0,
            nPersonasEsperando = 0,
            numJubilados = 0,
            numMaxPersonas = numMaxPersNorm;

    public synchronized void entrarJubilado() throws InterruptedException{
        numJubilados++;
        System.out.println("Personas Jubiladas esperando: " + numJubilados +
                "\nPersonas esperando: " + nPersonasEsperando +
                "\nPersonas Dentro: " + nPersonas +
                "\nLa temperatura actual es: " + temperatura +
                "\nLa capacidad maxima es: " + numMaxPersonas +
                "\n--------------------------------------------------------------");
        while (nPersonas >= numMaxPersonas) wait();
        numJubilados--;
        nPersonas++;

        System.out.println("HA ENTRADO UN JUBILADO");
        System.out.println("Personas Jubiladas esperando: " + numJubilados +
                "\nPersonas esperando: " + nPersonasEsperando +
                "\nPersonas Dentro: " + nPersonas +
                "\nLa temperatura actual es: " + temperatura +
                "\nLa capacidad maxima es: " + numMaxPersonas +
                "\n--------------------------------------------------------------");
    }

    public synchronized void entrarSala() throws InterruptedException{
        nPersonasEsperando++;
        System.out.println("Personas Jubiladas esperando: " + numJubilados +
                "\nPersonas esperando: " + nPersonasEsperando +
                "\nPersonas Dentro: " + nPersonas +
                "\nLa temperatura actual es: " + temperatura +
                "\nLa capacidad maxima es: " + numMaxPersonas +
                "\n--------------------------------------------------------------");
        while (nPersonas >= numMaxPersonas || numJubilados > 0) wait();
        nPersonasEsperando--;
        nPersonas++;
        System.out.println("HA ENTRADO UNA PERSONA NORMAL");
        System.out.println("Personas Jubiladas esperando: " + numJubilados +
                "\nPersonas esperando: " + nPersonasEsperando +
                "\nPersonas Dentro: " + nPersonas +
                "\nLa temperatura actual es: " + temperatura +
                "\nLa capacidad maxima es: " + numMaxPersonas +
                "\n--------------------------------------------------------------");
    }

    public synchronized void salirSala() throws InterruptedException{
        nPersonas--;
        notifyAll();
        System.out.println("HA SALIDO UNA PERSONA");
        System.out.println("Personas Jubiladas esperando: " + numJubilados +
                "\nPersonas esperando: " + nPersonasEsperando +
                "\nPersonas Dentro: " + nPersonas +
                "\nLa temperatura actual es: " + temperatura +
                "\nLa capacidad maxima es: " + numMaxPersonas +
                "\n--------------------------------------------------------------");
    }

    public synchronized void notifyTemperatura(int temp){
        if(temp > temperatura) numMaxPersonas = numMaxPersNorm;
        if(temp < temperatura) numMaxPersonas = numMaxPersAltaTemp;
        temp = temperatura;
    }
}
