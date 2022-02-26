package example.estructurada;

import java.util.Scanner;


public class infinite{
  public static void main(String []args){
    Scanner input = new Scanner (System.in);
    final int TAM = 10;
    int valores[] = new int[TAM];
    int num = 0;
    int tamactual = 0;
    do{
      System.out.println("Inserta un numero, -1 para salir");
      if(input.hasNextInt()){
        num = input.nextInt();
        if(num>=0){
          valores[tamactual] = num;
          tamactual++;
          if(tamactual >= valores.length){
            int aux[] = new int[valores.length+TAM];
            for(int i = 0; i<valores.length;i++){
              aux[i] = valores[i];
            }
            valores=aux;
          }
        }
      }else{
        input.nextLine();
      }
    }while(num!=-1);
    for(int i = 0; i<tamactual; i++){
      System.out.println("En la posicion " + i + " se encuentra el numero " + valores[i]);
    }
  }
}
