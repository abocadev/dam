package com.mycompany.modular;

public class E023registroNotas {
    public static void main(String[] args) {
        E023registroNotas programa = new E023registroNotas();
        programa.inicio();
    }

    public void inicio() {
        double[] notas = {2.0, 5.5, 7.25, 3.0, 9.5, 8.25, 7.0, 7.5};
        E022calculoArray calculador = new E022calculoArray();
        double max = calculador.calcularMaximo(notas);
        double min = calculador.calcularMinimo(notas);
        double media = calculador.calcularMedia(notas);
        System.out.println("La nota maxima es: " + max);
        System.out.println("La nota minima es: " + min);
        System.out.println("La nota media es: " + media);

    }
}
