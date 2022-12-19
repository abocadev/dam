/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ejercicio3;


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
        if (numero == numeroElegido) {
            banca.restarSaldo(360);
            sumarSaldo(360);
            System.out.println("El jugador " + nombreHilo + " gana 360 fichas");
        }
        System.out.println("El saldo actual del jugador " + nombreHilo + " es de: " + saldo);
         //Cambio apuestaRealizada a false para cerrar el ciclo de apuesta.
        apuestaRealizada = false;
    }

    @Override
    public void hacerApuesta() {
         //TODO. Se elige un número del 1 al 36 y se modifican los saldos de la abnca y del jugador
        if (!banca.aceptaApuestas())
            return;
        if (apuestaRealizada)
            return;
        //Genero el número elegido. Le sumo 1 para que no salga el 0.
        numeroElegido = generador.nextInt(36)+1;
        System.out.println("El jugador " + nombreHilo + " ha elegido el numero: " + numeroElegido);
        //Manejo los cambios de saldo
        banca.sumarSaldo(10);
        restarSaldo(10);
        //Cambio el estado de la apuestaRealizada a true y...
        apuestaRealizada = true;
        //Le paso los datos a la banca.
        banca.aceptarApuesta(this);
    }
}
