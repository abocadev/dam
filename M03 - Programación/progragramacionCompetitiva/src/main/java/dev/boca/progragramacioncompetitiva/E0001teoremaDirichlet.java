//  #################
//  ### ENUNCIADO ###
//  #################

/*
El teorema de Dirichlet indica que dados dos números (a,b) que son dos números relativamente primos, la secuencia que comienza con (a) y se incrementa en (b) contiene un número infinito de números primos. Esto es:

Por ejemplo si a = 2,b = 3 la secuencia que se obtiene es:



que contiene un numero infinito de números primos.

Su tarea es que dado un numero, los números a,b,n imprimir el enésimo número primo de la secuencia.

 

Entrada
La entrada contiene múltiples casos de prueba. Termina cuando no hay más datos. La entrada consiste en tres números (2 ≤ a,b,n ≤ 107) separados por un espacio que vienen en una línea.

Salida
Por cada caso de entrada imprima en la salida el enésimo número primo de la secuencia.

Ejemplo de Entrada:
2 3 4
3 10 3
103 230 1
27 104 185

Ejemplo de Salida
17
23
103
93523
*/

//  ##############
//  ### CÓDIGO ###
//  ##############

package dev.boca.progragramacioncompetitiva;

import java.util.Scanner;

public class E0001teoremaDirichlet {
    
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int a = input.nextInt();
        int b = input.nextInt();
        int n = input.nextInt();
        int[] dirichlet = new int[n+1];
        for(int i = 0; i<n; i++){
          int calculo = a + b;
          dirichlet[i] = calculo;
          a = calculo;
        }
        System.out.println(dirichlet[n-1]);
  }
}
