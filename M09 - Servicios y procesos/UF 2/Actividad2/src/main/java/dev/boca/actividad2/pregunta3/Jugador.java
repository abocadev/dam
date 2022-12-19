package dev.boca.actividad2.pregunta3;

import java.util.Random;

public abstract class Jugador implements Runnable {

    protected long saldo;

    protected boolean enBancarrota;

    protected long cantidadApostada;

    protected boolean apuestaRealizada;

    protected Banca banca;

    protected String nombreHilo;

    protected Random generador;

    public Jugador(long saldoInicial, Banca b) {
        saldo = saldoInicial;
        banca = b;
        apuestaRealizada = false;
        generador = new Random();
    }

    public void sumarSaldo(long cantidad) {
        saldo = saldo + cantidad;
    }

    public void restarSaldo(long cantidad) {
        if (saldo - cantidad <= 0)enBancarrota = true;
        else saldo = saldo - cantidad;
    }

    public boolean enBancarrota() {
        return enBancarrota;
    }

    public abstract void comunicarNumero(int numero);

    public abstract void hacerApuesta();
    @Override
    public void run() {
        nombreHilo = Thread.currentThread().getName();
        while ((!enBancarrota) && (!banca.enBancarrota())) {
            int msAzar;
            while (!banca.aceptaApuestas()) {
                msAzar = this.generador.nextInt(500);
                try {
                    Thread.sleep(msAzar);
                } catch (InterruptedException e) {
                    System.out.println("Error: "+ e);
                }
            }
            hacerApuesta();
        }
        String nombre = Thread.currentThread().getName();
        if (enBancarrota) System.out.println(nombre + " se ha arruinado");
        else if (banca.enBancarrota()) System.out.println(nombre + " hizo saltar la banca");
    }
}

