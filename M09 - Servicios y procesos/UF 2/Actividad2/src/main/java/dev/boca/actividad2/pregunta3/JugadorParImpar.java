package casino;

public class JugadorParImpar extends Jugador {

    public JugadorParImpar(long saldoInicial, Banca b) {
        super(saldoInicial, b);
    }
    protected boolean jugamosAPares;

    @Override
    public void hacerApuesta() {
        //TODO
    }

    public boolean esGanador(int num) {
        /* Este jugador necesita comprobar si ha salido el 0,
         * aunque no lo elige nunca, ya que si hemos apostado
         * Par podríamos pensar que hemos ganado cuando no es así */
        //TODO
    }

    @Override
    public void comunicarNumero(int numero) {
        //TODO
    }
}