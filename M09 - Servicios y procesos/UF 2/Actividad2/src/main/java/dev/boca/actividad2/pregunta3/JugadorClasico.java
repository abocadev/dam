package casino;

public class JugadorClasico extends Jugador {

    int numeroElegido;
    public JugadorClasico(long saldoInicial, Banca b) {
        super(saldoInicial, b);
    }

    @Override
    public void comunicarNumero(int numero) {
        /* No hace falta comprobar si el numero es
         * 0, ya que este jugador no lo elige nunca */
        //TODO. Si el número elegido es el ganador, se modifican los saldos pertinentes
    }

    @Override
    public void hacerApuesta() {
        //TODO. Se elige un número del 1 al 36 y se modifican los saldos de la abnca y del jugador
    }
}