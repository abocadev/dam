package dev.boca.poo;

/**
 * Opmejores
 */
public class Opmejores {

    int suma, resta, multiplicacion, division;

    public void suma(int num1, int num2){
        suma = num1 + num2;
    }

    public void resta(int num1, int num2){
        resta = num1 - num2;
    }

    public void multiplicacion(int num1, int num2){
        multiplicacion = num1 * num2;
    }

    public void division(int num1, int num2){
        division = num1 / num2;
    }

    public void imprimir(){
        System.out.println("La suma: " + suma);
        System.out.println("La resta: " + resta);
        System.out.println("La division: " + division);
        System.out.println("La multiplicacion: " + multiplicacion);
    }
}