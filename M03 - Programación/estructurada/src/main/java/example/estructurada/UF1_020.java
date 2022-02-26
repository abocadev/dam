package example.estructurada;
import java.util.Scanner;
public class UF1_020 {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        System.out.println("¿Cuantos alumnos hay?");
        int alumnos = entrada.nextInt();
        double suma = 0;
        String alum[] = new String [alumnos];
        double notas[] = new double [alumnos];
        int i;
        for(i = 0; i < alumnos; i++){
            System.out.println("Introduzca el nombre del alumno:");
            alum[i] = entrada.next();
            System.out.println("Introduzca la nota del alumno:");
            notas[i] = entrada.nextInt();
            suma += notas[i]; 
        }
        double media = suma/alumnos;
        System.out.println("La media del grupo es de " + media + ".");
        
        for(int x = 0; x< alumnos;x++){
            if(notas[x]> media){
                System.out.println("El alumno " + alum[x] + " tiene una nota de " + notas[x] + " que supera a la media.");
            }
        }
        
    }
}