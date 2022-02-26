package example.estructurada;

import java.util.Scanner;

public class quitarAcentos {

    public static void main(String[] args) {
          Scanner entrada = new Scanner(System.in);
          final int TAM = 10;
          // declarar array como una constante
          int []valores = new int[TAM];
          // declaramos 
          int tamactual = 0;
          int num = 0;
          
          do{
              System.out.println("Introduce un numero:");
              if(entrada.hasNextInt()){
                  num = entrada.nextInt();
                  if(num>=0){
                      valores[tamactual] = num;
                      tamactual++;
                      if(valores.length >= tamactual){
                          int aux[] = new int[valores.length+TAM];
                          for(int i = 0; i< valores.length; i++){
                              aux[i] = valores[i];
                          }
                          valores = aux;
                      }
                  }
              }else{
                  entrada.nextLine();
              }
                  
          }while(num!=-1);
        for(int i = 0; i<valores.length; i++){
            System.out.println("En la posicion " + i+1 + " el numero es " + valores[i]);
        }
    }
}
