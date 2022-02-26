package com.mycompany.modular;
public class E007asteriscos {
    public static void main(String[] args) {
        E007asteriscos programa = new E007asteriscos();
        programa.inicio();
    }
    
    public void inicio(){
        int tortilla = 5;
        asteriscos(tortilla);
        asteriscos(10);
        asteriscos(0);
        asteriscos(15);
    }
    
    public void asteriscos(int n){
        for(int i = 0; i<n;i++){
            System.out.println("*");
        }
        System.out.println(".");
    }
    
}
