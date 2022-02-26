package example.estructurada;
import java.util.Scanner;
public final class E047acronimo {
	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		System.out.println("Introduce una frase:");
		String frase = entrada.nextLine();
		String acronimo = "";
		String [] palabras = frase.split(" ");
		for(int i = 0; i<palabras.length; i++) {
			acronimo = acronimo + palabras[i].charAt(0); 
		}
		System.out.println("El acronimo es: " + acronimo);
	}
}