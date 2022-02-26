package com.mycompany.modular;

public class E021monolitico {
    public static void main(String[] args) {
        E021monolitico programa = new E021monolitico();
        programa.inicio();
    }

    public void inicio(){
        double[] notas = {2.0, 5.5, 7.25, 3.0, 9.5, 8.25, 7.0, 7.5};
        double max = calcularMaximo(notas);
        double min = calcularMinimo(notas);
        double media = calcularMedia(notas);
        System.out.println("La nota maxima es: " + max);
        System.out.println("La nota minima es: " + min);
        System.out.println("La nota media es: " + media);

    }

    public double calcularMaximo(double[] array){
        double max = array[0];
        for(int i = 1; i<array.length;i++){
            if(max<array[i]){
                max = array[i];
            }
        }
        return max;
    }

    public double calcularMinimo(double[] array) {
        double min = array[0];
        for (int i = 1; i < array.length; i++) {
            if (min > array[i]) {
                min = array[i];
            }
        }
        return min;
    }

    public double calcularMedia(double[] array){
        double suma = 0;
        for(int i = 0; i<array.length;i++){
            suma += array[i];
        }
        return suma/array.length;
    }
}
