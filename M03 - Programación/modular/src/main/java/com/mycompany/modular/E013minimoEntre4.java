package com.mycompany.modular;
public class E013minimoEntre4 {
    
    public static void main(String[] args) {
        E013minimoEntre4 programa = new E013minimoEntre4();
        programa.inicio();
    }
    
    public void inicio(){
        var resultado = minimo(40, 3, -2, 1);
        System.out.println(resultado);
    }
    
    public int minimo(int a, int b, int c, int d){
        int min = a;
        if((a < b) && (a < c) && (a < d)){
            min = a;
        }else if((b < a) && (b < c) && (b < d)){
            min = b;
        } else if((c< a) && (c < b) && (c < d)){
            min = c;
        } else{
            min = d;
        }
        return min;
    }
    
}
