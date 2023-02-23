package dev.boca;

import java.util.Scanner;

public class Main {
    static char []abecedarioMinus= {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
    static char[] abecedarioMayus = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};

    static String text;
    static String textEncrypt;
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        encrypt();
        desencrypt();
    }

    public static void encrypt(){
        text = entryText();
        int num = entryInteger();
        textEncrypt = "";
        for(char c : text.toCharArray()){
            boolean encontrado = false;
            if(!encontrado){
                for(int i = 0; i < abecedarioMinus.length; i++){
                    char cc = abecedarioMinus[i];
                    if(cc == c){
                        textEncrypt += "" + abecedarioMinus[i+num];
                        i = abecedarioMinus.length;
                        encontrado = true;
                    }
                }
            }

            if(!encontrado){
                for(int i = 0; i < abecedarioMayus.length; i++){
                    char cc = abecedarioMayus[i];
                    if(cc == c){
                        textEncrypt += "" + abecedarioMayus[i+num];
                        i = abecedarioMayus.length;
                        encontrado = true;
                    }
                }
            }

            if(!encontrado){
                textEncrypt += c;
            }
        }
        System.out.println("El texto encriptado es: " + textEncrypt);
    }

    public static void desencrypt(){
        int num = entryInteger();
        String textDesencrypt = "";
        for(int i = 0; i < textEncrypt.length(); i++){
            char caracter = textEncrypt.charAt(i);
            if (Character.isLetter(caracter)) {
                if (Character.isUpperCase(caracter)) {
                    caracter = (char) ((caracter - num - 65 + 26) % 26 + 65);
                } else {
                    caracter = (char) ((caracter - num - 97 + 26) % 26 + 97);
                }
            }
            textDesencrypt += caracter;
        }
        System.out.println("El texto que desencriptado es: " + textDesencrypt);
    }


    public static String  entryText(){
        String text = "";
        boolean salir = false;
        while (!salir) {
            System.out.println("Que frase quieres encriptar?");
            if(sc.hasNextLine()){
                text = sc.nextLine();
                salir = true;
            }else{
                System.out.println("Has introducido texto no valido");
            }
        }
        return text;
    }

    public static int entryInteger(){
        int num = 0;
        boolean salir = false;
        while (!salir) {
            System.out.println("Introduzca un numero entero y positivo:");
            if(sc.hasNextInt()){
                num = sc.nextInt();
                if(num > 0){
                    salir = true;
                }else{
                    System.out.println("Has introducido un numero negativo o que es igual a 0");
                }
            }else{
                System.out.println("Has introducido un numero que no es entero o que no es valido");
            }
        }
        while(num > abecedarioMinus.length){
            num -= abecedarioMinus.length;
        }
        return num;
    }

}