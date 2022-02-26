package com.mycompany.modular;
public class E009parametroArray {
    public static void main(String[] args) {
        E009parametroArray programa = new E009parametroArray();
        programa.inicio();
    }
    
    public void inicio(){
        int[] a = {1,2,3,4,5};
        System.out.println("Antes de invocar al metodo \"i[3]\" vale " + a[3]);
        modificarArray(a);
        System.out.println("Despues de invocar al metodo \"i[3]\" vale " + a[3]);
    }
    
    public void modificarArray(int[] a){
        a[3] = 0;
        System.out.println("Se ha modificado el valor a " + a[3]);
    }
    
}
