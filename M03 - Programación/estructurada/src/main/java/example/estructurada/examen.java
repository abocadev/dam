package example.estructurada;

import java.util.Scanner;

public class examen {

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        int VIDAS = 5;
        System.out.println("Introduce la palabra oculta:");
        String palabra = entrada.next().toUpperCase();
        char letras[] = new char[palabra.length()];
        boolean win = false;
        for(int i = 0; i<letras.length;i++){
            letras[i] = '_';
        }
        int aciertos = 0;
        boolean fallada = false;
        while(!win){
            for(int i = 0;i<letras.length;i++){
                System.out.print(letras[i] + " ");
            }
            System.out.println(" \nTe quedan " + VIDAS + "vidas\nIntroduce una letra:");
            char letra = (char)entrada.next().toUpperCase().charAt(0);
            for(int i = 0; i<letras.length;i++){
                if(letras[i] == '_' && palabra.charAt(i) == letra){
                    letras[i] = palabra.charAt(i);
                    aciertos++;
                    fallada = false;
                }
            }
            if(fallada == true){
                System.out.println("Has fallado la letra");
                VIDAS--;
            }
            if(aciertos == palabra.length()){
                win = true;
            }else if(VIDAS == 0){
                win = true;
            }
            fallada=true;
        }
        if(aciertos == palabra.length()){
            System.out.println("Ganaste");
            for(int i = 0;i<letras.length;i++){
                System.out.print(letras[i] + " ");
            }
        }else{
            System.out.println("GAME OVER");
        }
        
    }
    
}
