package com.mycompany.modular;

import java.util.Scanner;

public class palabraOculta {

    // VARIABLES GLOBALES
    Scanner entrada = new Scanner(System.in);
    
    // ABECEDARIO
    char[] abecedario = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
    int wordLength = 0;
    String secretWord = "";
    String userWord = "";
    boolean wordCorrect = false;
    String respuestaAlUsuario = "";
    boolean partidaGanada = true;
    

    public static void main(String[] args) {
        palabraOculta programa = new palabraOculta();
        programa.inicio();
    }

    public void inicio() {
        genSecretWord();
        questionWord();
    }

    /*
     *  PRIMER NIVEL
     */
    
    // PREGUNTAMOS LA CADENA DE TEXTO
    public void questionWord(){
        System.out.println("Escribe " + wordLength + " letras en minuscula: ");
        userWord = inputUserWord(userWord);
        if(wordCorrect == true){
            analyzeWord();
            comprobacion();
        }
    }
    
    
    
    // ANALIZAMOS LA PALABRA OCULTA
    public void analyzeWord(){
        boolean contiene = false;
        partidaGanada = true;
        respuestaAlUsuario = "";
        for(int i = 0; i<userWord.length();i++){
            if(secretWord.charAt(i) == userWord.charAt(i)){
                respuestaAlUsuario += "0";
            }else{
                for(int x = 0; x<secretWord.length();x++){
                    if(userWord.charAt(i) == secretWord.charAt(x)){
                        contiene = true;
                    }
                }
                
                if(contiene == true){
                    respuestaAlUsuario += "X";
                    partidaGanada = false;
                }else{
                    respuestaAlUsuario += "-";
                    partidaGanada = false;
                }
            }
            contiene = false;
        }
    }
    
    // COMPROBACION LA RESPUESTA
    
    public void comprobacion(){
   
        if(partidaGanada == false){
            System.out.println("La respuesta es [" + respuestaAlUsuario + "]. Sigue intentandolo");
            questionWord();
        }else{
            System.out.println("La respuesta es [" + respuestaAlUsuario + "]. HAS GANADO LA PARTIDA");
        }
    }
    
    // GENERAMOS LA PALABRA SECRETA
    public void genSecretWord(){
        wordLength = genWordLength(wordLength);
        char letterWord = 'a';
        for(int i = 0; i<wordLength;i++){
            letterWord = genLetter(letterWord);
            secretWord = secretWord + letterWord;
        }
        System.out.println(secretWord);
    }
    
    /*
     *  SEGUNDO NIVEL
     */
    
    // Generar el tamanyo de la palabra (de manera aleatoria)
    public int genWordLength(int a){
        a = (int)Math.floor(Math.random()*10+1);
        return a;
    }
    
    // Generamos la letra
    public char genLetter(char letter){
        int num = (int)Math.floor(Math.random()*abecedario.length);
        letter = abecedario[num];
        return letter;
    }
    
    // Preguntamos la palabra
    public String inputUserWord(String word){
        word = "";
        if(entrada.hasNext()){
            word = entrada.next().toLowerCase();
            if(word.length() != wordLength){
                System.out.println("El numero de letras de la palabra no es correcto");
                word = "";
                questionWord();
            }else{
                wordCorrect = true;
            }
        }else{
            System.out.println("Has introducido caracteres no validos");
        }
        return word;
    }
    
}