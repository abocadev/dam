package dev.boca.poo;

import javax.swing.JOptionPane;

public class OpMejoresMain {
    
    public static void main(String[] args) {
        
        
        Opmejores calculadora = new Opmejores();
        int num1 = Integer.parseInt(JOptionPane.showInputDialog("Cual es el primer numero?"));
        int num2 = Integer.parseInt(JOptionPane.showInputDialog("Cual es el segundo numero?"));
        
        calculadora.suma(num1, num2);
        calculadora.resta(num1, num2);
        calculadora.multiplicacion(num1, num2);
        calculadora.division(num1, num2);
        calculadora.imprimir();
    }
}
