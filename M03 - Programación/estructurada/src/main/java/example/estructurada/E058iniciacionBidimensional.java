package example.estructurada;

import java.util.Scanner;

public class E058iniciacionBidimensional {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        //variable para almacenar filas
        int numFilas = 0;
        
        // lectura de filas
        while (numFilas <= 0){
            System.out.println("Cuantas filas tendra la tabla?");
            if(entrada.hasNextInt()){
                numFilas = entrada.nextInt();
            }else{
                entrada.next();
                System.out.println("Valor incorrecto");
            }
        }
        entrada.nextLine();
        
        // lectura de columnas
        int numCol = 0;
        
        while (numCol <= 0){
            System.out.println("Cuantas columnas tendra la tabla?");
            if(entrada.hasNextInt()){
                numCol= entrada.nextInt();
            }else{
                entrada.next();
                System.out.println("Valor incorrecto");
            }
        }
        entrada.nextLine();
        
        // inicializacion
        
        // declara array bidimensional
        int [][] bidimensional = new int [numFilas][numCol];
        
        // atributo length
        System.out.println("Hay " + bidimensional.length + " filas");
        System.out.println("Hay " + bidimensional[0].length + " columnas"); 
        for (int i = 0; i<numFilas;i++){
            System.out.print("Fila " + i + " { ");
            for(int j = 0; j<numCol;j++){
                System.out.print(bidimensional[i][j] + " ");
            }
            System.out.println("}");
        }
    }
    
}
