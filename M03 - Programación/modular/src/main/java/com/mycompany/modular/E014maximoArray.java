package com.mycompany.modular;
public class E014maximoArray {
    public static void main(String[] args) {
        E014maximoArray programa = new E014maximoArray();
        programa.inicio();
    }
    
    public void inicio(){
        double[] valores = {4.5, 70.8, 9.5, -12.1, 2.1, 1.4, 0};
        double resultado = maximo(valores);
        System.out.println("El valor maximo es: " + resultado);
    }    
    
    // entrada --> array
    // salida --> double maximo
    
    public double maximo(double[]a){
        // "a" contiene el valor a tratar
        double max  = a[0];
        for(int i = 1; i<a.length;i++){
            if(max < a[i]){
                max = a[i];
            }
        }
        return max;
    }
}
