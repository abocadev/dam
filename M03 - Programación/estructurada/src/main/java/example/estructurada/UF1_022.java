package example.estructurada;
import java.util.Scanner;
public class UF1_022 {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        System.out.println("Introduce un numero de personas:");
        int N = entrada.nextInt();
        double suma = 0;
        while(N<=0){
            System.out.println("Introduce un numero de personas:");
            N = entrada.nextInt();
        }
        double altura[] = new double[N];
        for(int i = 0; i<N;i++){
            System.out.println("Introduce la altura de la persona " + i + ":");
            altura[i] = entrada.nextDouble();
            suma += altura[i];
        }
        double media = suma/N;
        for(int i = 0; i<N;i++){
            if(media <altura[i]){
                System.out.println("La persona " + (i + 1) + " ha superado la altura de la media");
            } else{
                System.out.println("La persona " + (i + 1) + " es inferior a la altura de la media");
            }
        }
    }
    
}
