package com.mycompany.modular;
public class prueba {
    public static void main(String[] args) {
        int num  = 152348523;
        String numString = "" + num + "";
        int[] numeros = new int[numString.length()];
        int contador = numeros.length-1;
        while(num>0){
            numeros[contador] = num % 10;
            num /= 10;
            contador--;
        }
        for(int i = 0; i<numeros.length;i++){
            System.out.println(numeros[i]);
        }
    }    
}