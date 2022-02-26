package example.estructurada;
import java.util.Scanner;
public class E042compareTo {
    public static final String MES_SECRETO = "julio";
    public static void main(String[] args) {
        // adivinar un mes, danto pistas
        Scanner entrada = new Scanner (System.in);
        System.out.println("Adivina el mes secreto:");
        boolean acierto = false;
        while(!acierto){
            System.out.println("¿Qué mes crees que es el secreto?");
            String intento = entrada.next();
            entrada.nextLine();
            int posicion = intento.compareTo(MES_SECRETO);
            if(posicion<0){
                // intento es anterior al mes secreto
                System.out.println("Has fallado, el mes va después alfabéticamente");
            } else if(posicion > 0){
                System.out.println("Has fallado, el mess va antes alfabéticamente");
            } else{
                acierto = true;
            }
        }
        System.out.println("Acertaste!");
    }   
}