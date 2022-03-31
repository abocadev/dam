package BocanegraAlbertPersona;
public class NewMain {
    public static void main(String[] args) {
        char letras[] = {'T', 'R', 'W', 'A', 'G', 'M', 'Y', 'F', 'P', 'D', 'X', 'B', 'N', 'J', 'Z', 'S', 'Q', 'V', 'H', 'L', 'C', 'K', 'E'};
        int dni = 48017058;
        int resto = dni % 23;
        char letraDni = ' ';
        for(int i = 0; i<23; i = resto){
            System.out.println(letras[i]);
            letraDni = letras[i];
        }
        
        System.out.println("La letra del DNI: " + letraDni);
    }
    
}
