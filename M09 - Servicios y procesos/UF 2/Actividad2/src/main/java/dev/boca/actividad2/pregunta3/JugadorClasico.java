package dev.boca.actividad2.pregunta3;


public class JugadorClasico extends Jugador {

    int numeroElegido;

    public JugadorClasico(long saldoInicial, Banca b) {
        super(saldoInicial, b);
    }

    @Override
    public void comunicarNumero(int numero) {
        if (numero == numeroElegido) {
            banca.restarSaldo(360);
            sumarSaldo(360);
            System.out.println("El jugador " + nombreHilo + " gana 360 fichas");
        }
        System.out.println("El saldo actual del jugador " + nombreHilo + " es de: " + saldo);
        apuestaRealizada = false;
    }

    @Override
    public void hacerApuesta() {
        if (!banca.aceptaApuestas() || apuestaRealizada) return;
        numeroElegido = generador.nextInt(36)+1;
        System.out.println(nombreHilo + " su numero es: " + numeroElegido);
        banca.sumarSaldo(10);
        restarSaldo(10);
        apuestaRealizada = true;
        banca.aceptarApuesta(this);
    }
}
