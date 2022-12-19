/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ejercicio3;

public class JugadorMartingala extends Jugador {

    private int cantidadAApostar;

    private int numeroElegido;

    public JugadorMartingala(long saldoInicial, Banca b) {
        super(saldoInicial, b);
        cantidadAApostar = 10;
    }

    @Override
    public void comunicarNumero(int numero) {
        //Si el número que sale es 0, gana la banca y el jugador dobla la cantidad que apuesta
        if (numero == 0) {
            System.out.println("El jugador " + nombreHilo + " pierde " + cantidadAApostar);
            cantidadAApostar *=2;
            return;
        }
        //Si el número coincide con el elegido, el jugador gana 36 veces lo apostado y se manejan los saldos. La cantidad a apostar vuelve a 1.
        if (numeroElegido == numero) {
            System.out.println("El jugador " + nombreHilo + " gana " + cantidadAApostar);
            int premio = cantidadAApostar * 36;
            banca.restarSaldo(premio);
            sumarSaldo(premio);
            cantidadAApostar = 10;
        }
        //Si el número no coincide con el elegido, el jugador dobla su apuesta
        if (numeroElegido != numero) {
            System.out.println("El jugador " + nombreHilo + " pierde " + cantidadAApostar);
            cantidadAApostar *=2;
        }
        System.out.println("El jugador " + nombreHilo + " queda con un saldo de " + saldo);
        //Cambio apuestaRealizada a false para cerrar el ciclo de apuesta.
        apuestaRealizada = false;
    }

    @Override
    public void hacerApuesta() {
        if (!banca.aceptaApuestas())
            return;
        if (apuestaRealizada)
            return;
        //Para que no salga el 0 le sumo 1 al resultado.
        numeroElegido = generador.nextInt(36)+1;
        System.out.println("El jugador " + nombreHilo + " ha elegido el numero: " + numeroElegido);
        //Manejo los cambios de saldo
        banca.sumarSaldo(cantidadAApostar);
        restarSaldo(cantidadAApostar);
        //Cambio el estado de la apuesta a true y...
        apuestaRealizada = true;
        //Le paso los datos a la banca.
        banca.aceptarApuesta(this);
    }
}
