package dev.boca.actividad2.pregunta3;

public class JugadorMartingala extends Jugador {

    private int cantidadAApostar;

    private int numeroElegido;

    public JugadorMartingala(long saldoInicial, Banca b) {
        super(saldoInicial, b);
        cantidadAApostar = 10;
    }

    @Override
    public void comunicarNumero(int numero) {
        if (numero == 0) {
            System.out.println(nombreHilo + " ha perdido" + cantidadAApostar);
            cantidadAApostar *= 2;
        } else if (numeroElegido == numero) {
            System.out.println(nombreHilo + " gana " + cantidadAApostar);
            banca.restarSaldo(cantidadAApostar * 36);
            sumarSaldo(cantidadAApostar * 36);
            cantidadAApostar = 10;
        } else if (numeroElegido != numero) {
            System.out.println("El jugador " + nombreHilo + " pierde " + cantidadAApostar);
            cantidadAApostar *= 2;
        }
        if (numero != 0) {
            System.out.println("El jugador " + nombreHilo + " queda con un saldo de " + saldo);
            apuestaRealizada = false;
        }
    }

    @Override
    public void hacerApuesta() {
        if (!banca.aceptaApuestas() || apuestaRealizada) {
        } else {
            numeroElegido = generador.nextInt(36) + 1;
            System.out.println("El jugador " + nombreHilo + " ha elegido el numero: " + numeroElegido);
            banca.sumarSaldo(cantidadAApostar);
            restarSaldo(cantidadAApostar);
            apuestaRealizada = true;
            banca.aceptarApuesta(this);
        }
    }
}
