package example.estructurada;
import java.util.Scanner;
public class Extra001countchar {
    public static void main(String[] args) {
        Scanner input = new Scanner (System.in);
        System.out.println("Introduce un palabra o una frase:");
        String word = input.nextLine();
        int wordlength = word.length();
        int contador = 0;
        for(int i = 0; i < wordlength; i++){
            char caracter = word.charAt(i);
            for(int x = 0; x <wordlength; x++){
                char caracter_temp = word.charAt(x);
                if(caracter == caracter_temp){
                    contador++;
                }
            }
            System.out.println("La letra " + caracter + " contiene " + contador + " letras.");
            contador = 0;
        }
    }
}