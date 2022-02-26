
package com.mycompany.modular;
public class E005variables {
    public static void main(String[] args) {
        int contador = 1;
        contador = duplicar_valor(contador);
        System.out.println(contador);
    }
    
    public static int duplicar_valor(int contador){
        contador = contador * 2;
        return contador;
    }
    
}
