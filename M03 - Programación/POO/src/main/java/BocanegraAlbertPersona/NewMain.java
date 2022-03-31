/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package BocanegraAlbertPersona;

/**
 *
 * @author USUARI
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
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
