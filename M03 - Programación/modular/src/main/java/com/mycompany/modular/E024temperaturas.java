package com.mycompany.modular;

public class E024temperaturas {
    public static void main(String[] args) {
        E024temperaturas programa = new E024temperaturas();
        programa.inicio();
    }

    public void inicio(){
        double[] temp = {20.0, 21.5, 19.0, 18.5, 17.5, 19.0, 22.25, 21.75};
        E022calculoArray calculador = new E022calculoArray();
        double max = calculador.calcularMaximo(temp);
        double min = calculador.calcularMinimo(temp);
        double diferencia = max - min;
        System.out.println("La diferencia maxima de temperatura es " + diferencia + ".");
    }
}
