package example.estructurada;

public class E005especiales {

    public static void main(String[] args) {
        // declaramos la variable constante PI
        final double  PI = 3.1416d;
        // imprimimos la constante
        System.out.println(PI);
        // intentamos cambiar el contenido de la variable, pero no vamos a poder
        //PI = 23;
        
        // declaracion de variable tipo "char"
        char a = 'B';
        // declarar una variable tipo int
        int i = a;
        System.out.println(i);
        
        // Salto de línea
        System.out.println("Salto de linea \n Tabulación \tEstoy tabulando \n Fin \"Fin\"");
    }
    
}
