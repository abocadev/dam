package com.mycompany.modular;
public class E005 {
    public static void main(String[] args) {
        int contador = 1;
        
        int lista[] = new int[3];
        
        lista[0] = 1;
        lista[1] = 2;
        lista[2] = 3;
        
        duplicarArray(lista);
        for(int i = 0; i<3;i++){
            System.out.println(lista[i]);
        }
    }
    
    public static int duplicarValor(int x){
        x = x * 2;
        return x;
    }
    
    public static void duplicarArray(int [] lista){
        for(int i = 0; i<3;i++){
            lista[i] = lista[i] * 2;
        }
    }
    
}
