package com.mycompany.modular;
public class BocanegraAlbert_Spencer {
    private final int num = 20;
    private int contador = 1, conteo = 0;
    private int[] numerosSpencer = new int[num];
    public static void main(String[] args) {
        BocanegraAlbert_Spencer programa = new BocanegraAlbert_Spencer();
        programa.funcionSpencer();
        programa.mostrarNums();
    }
    public void funcionSpencer() {
        while (conteo != num) {
            numerosSpencer();
            contador++;
        }
    }
    public void mostrarNums() {
        System.out.println("Los numeros Spencer son: ");
        for (int i = 0; i < numerosSpencer.length; i++) {
            System.out.print(numerosSpencer[i] + " ");
        }
    }
    public void numerosSpencer() {
        int digitos = 0, number = contador;
        while (number != 0) {
            number /= 10;
            digitos++;
        }
        number = contador;
        int[] numeros = new int[digitos];
        for (int i = 0; i < digitos; i++) {
            numeros[i] = number % 10;
            number /=  10;
        }
        calculoSpencer(numeros, digitos);
    }
    public int[] calculoSpencer(int[] a, int b) {
        int calculo = 0;
        for (int i = 0; i < a.length; i++) {
            calculo +=  (int) (Math.pow(a[i], b));
        }
        if (calculo == contador) {
            numerosSpencer[conteo] = contador;
            conteo++;
        }
        return a;
    }
}