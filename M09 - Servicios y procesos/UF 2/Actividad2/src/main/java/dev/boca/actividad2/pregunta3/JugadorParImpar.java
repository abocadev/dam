package dev.boca.actividad2.pregunta3;

import java.util.Random;

public class JugadorParImpar extends Jugador {

    public JugadorParImpar(long saldoInicial, Banca b) {
        super(saldoInicial, b);
    }

    protected boolean jugamosAPares;
    Random r = new Random();

    @Override
    public void hacerApuesta() {
        if (!banca.aceptaApuestas() || apuestaRealizada) {}
        else if (r.nextInt() %2 == 0) {
            jugamosAPares = true;
            System.out.println("El jugador " + nombreHilo + " ha decidido ir a pares.");
        } else {
            jugamosAPares = false;
            System.out.println("El jugador " + nombreHilo + " ha decidido ir a nones.");
            banca.sumarSaldo(10);
            restarSaldo(10);
            apuestaRealizada = true;
            banca.aceptarApuesta(this);
        }
        
    }

    public boolean esGanador(int num) {
        if(num != 0){
            if((num% 2 == 0) && jugamosAPares) return true;
            else if((num% 2 != 0) && !jugamosAPares) return true;
        }
        return false;

    }

    @Override
    public void comunicarNumero(int numero) {
        if (esGanador(numero)) {
            System.out.println("Ha ganado 20 fichas: " + nombreHilo);
            banca.restarSaldo(20);
            this.sumarSaldo(20);
        }
        System.out.println(nombreHilo + " su saldo es de: " + saldo);
        apuestaRealizada = false;
    }
}
