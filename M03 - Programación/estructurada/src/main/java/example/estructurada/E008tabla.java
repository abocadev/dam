
package example.estructurada;
import java.util.Scanner;
public class E008tabla {
    public static void main(String[] args) {
        Scanner entrada = new Scanner (System.in);
        System.out.println("¿Qué tabla quieres multiplicar: ");
        int tabla = entrada.nextInt();
        System.out.println("############");
        System.out.println("TABLA DEL " + tabla);
        System.out.println("############");
        for(int multiplicando = 0; multiplicando<=10; multiplicando++){
            System.out.println(tabla + " X " + multiplicando + " = " + multiplicando*tabla);
        }
    }
    
}
