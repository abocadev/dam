
package dev.boca.ficheros;
public class E032principal {
    public static void main(String[] args) {
        System.out.println("El valor es: " + E032metodoEstatico.valor);
        System.out.println("E032metodoEstatico.dividir2: " + E032metodoEstatico.dividir2());
        
        E032metodoEstatico.valor = 4;
        System.out.println("El valor es: " + E032metodoEstatico.valor);
    }
    
}