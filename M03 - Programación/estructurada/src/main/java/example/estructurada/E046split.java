package example.estructurada;

import java.util.Scanner;


public class E046split {

	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		System.out.println("Introduce una frase:");
		String frase = entrada.nextLine();
		
		// Separamos la frase en palabras, con espacios en blanco con separadores 
		String [] palabras = frase.split(" ");
		// Imprimir la frase al revés
		System.out.println("La frase invertida es:");
		// for en order inverso
		for(int i = palabras.length-1; i >= 0; i--) {
			System.out.println(palabras[i]);
			// no imprime espacios porque el split los ha eliminado
			System.out.println(" ");
		}
		
	}

}
