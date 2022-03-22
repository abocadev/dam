package dev.boca.poo;
public class Static {
    // atributos
    private String frase = "Frase molona";
    
    public static int sumar(int n1, int n2){
        int suma = n1+n2;
        return suma;
    }
    
    public static void main(String[] args) {
        // instanciar dos objetos
        Static uno = new Static();
        Static dos = new Static();
        
        System.out.println(uno.frase);
        System.out.println(dos.frase);
        
        // cada objeto hace una copia de los atributos NO estaticos
        dos.frase = "Frase increible";
        System.out.println(dos.frase);
        
        // cambiamos el atributo a estatico
        System.out.println(uno.frase);
        
        // si el atributo es de clase, no hace falta inicializar el objeto
        //System.out.println(static.frase);
        
        // metodo estatico
        System.out.println("La suma es: " + Static.sumar(50, 20));
    }
    
}
