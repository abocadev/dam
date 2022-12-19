/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ejercicio3;

import java.util.Random;

public class JugadorParImpar extends Jugador {

    public JugadorParImpar(long saldoInicial, Banca b) {
        super(saldoInicial, b);
    }

    protected boolean jugamosAPares;
    Random r = new Random();

    @Override
    public void hacerApuesta() {
        if (!banca.aceptaApuestas())
            return;
        if (apuestaRealizada)
            return;
        //Comprobamos el número que se elige con un random.
        //Si su factorial es 0, es par, de lo contrario son nones.
        //Cambiamos a true o false el boolean de jugamosAPares según corresponda.
        if (r.nextInt() %2 == 0) {
            jugamosAPares = true;
            System.out.println("El jugador " + nombreHilo + " ha decidido ir a pares.");
        } else {
            jugamosAPares = false;
            System.out.println("El jugador " + nombreHilo + " ha decidido ir a nones.");
        }
        //Manejo los saldos.
        banca.sumarSaldo(10);
        restarSaldo(10);
        //Cambio el estado de la apuestaRealizada a true y...
        apuestaRealizada = true;
        //Le paso los datos a la banca
        banca.aceptarApuesta(this);
    }

    public boolean esGanador(int num) {
        /* Este jugador necesita comprobar si ha salido el 0,
         * aunque no lo elige nunca, ya que si hemos apostado
         * Par podríamos pensar que hemos ganado cuando no es así */
        //TODO
        //Comprobamos los resultados. 
        //Primeramente comprobamos si el numero que ha salido es 0. 
        //Si es así, no es ganador. Devolvemos un false.
        if (num == 0) {
            return false;
        } else { //Habiendo descartado el 0 comprobamos si el número es par o impar
            //Y comprobamos si el jugador a apostado a pares o impares.
            //Si el numero es par y se han jugado a pares, gana, devolvemos un true
            if ((num % 2 == 0) && (jugamosAPares)) {
                return true;
            }
            //Si el numero es impar y NO se ha jugado a pares, gana, también devolvemos un true
            if ((num % 2 != 0) && (!jugamosAPares)) {
                return true;
            }
        }
        //Si no se cumple ninguna de estas condiciones significaría que el jugador
        //Ha jugado a pares y han tocado nones, o a la inversa.
        return false;

    }

    @Override
    public void comunicarNumero(int numero) {
        //Si es ganador
        if (esGanador(numero)) {
            //Lo comunico
            System.out.println("El jugador: " + nombreHilo + " gana 20 fichas");
            //Manejo el cambio de saldo
            banca.restarSaldo(20);
            this.sumarSaldo(20);
        }
        System.out.println("El saldo del jugador: " + nombreHilo + " es de: " + saldo);
        //Cambio apuestaRealizada a false para cerrar el ciclo de apuesta.
        apuestaRealizada = false;
        //TODO
    }
}
