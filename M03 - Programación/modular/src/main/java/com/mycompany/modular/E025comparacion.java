package com.mycompany.modular;

public class E025comparacion {
    public static void main(String[] args) {
        E024temperaturas programa = new E024temperaturas();
        programa.inicio();
    }

    public void inicio() {
        double[] array1 = { 20.0, 21.5, 19.0, 18.5, 17.5, 19.0, 22.25, 21.75 };
        double[] array2 = {40.1, 24.6, 12.5, 15.5, 46.0};
        E022calculoArray calculador = new E022calculoArray();
        double masgrande = 0;
        if(calculador.calcularMedia(array1)>calculador.calcularMedia(array2)){
            masgrande = calculador.calcularMedia(array1);
            System.out.println("La primera array es mas grande: " + masgrande);
        }else{
            masgrande = calculador.calcularMedia(array2);
            System.out.println("La segunda array es mas grande: " + masgrande);
        }
        
    }
}
