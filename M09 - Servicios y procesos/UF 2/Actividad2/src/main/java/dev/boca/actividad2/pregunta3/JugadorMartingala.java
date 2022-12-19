package casino;

public class JugadorMartingala extends Jugador {

    private int cantidadAApostar;
    private int numeroElegido;
    public JugadorMartingala(long saldoInicial, Banca b) {
        super(saldoInicial, b);
        cantidadAApostar = 1;
    }

    @Override
    public void comunicarNumero(int numero) {
        //TODO
    }

    @Override
    public void hacerApuesta() {
        //TODO
    }
}