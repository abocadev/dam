package example.estructurada;
public class E052potencias2 {
    // iniciación procedural potencia 2
    // array con 20 posiciones
    
    public static void main(String[] args) {
        //declarar array 20 posiciones 
        int [] valores = new int [20];
        // el primer valor lo damos manualmente
        valores [0] = 1;
        // el reto de los valores se inicializa secuencialmente, haciendo los cálculos necesarios 
        for(int i = 1; i<valores.length;i++){
            valores [i] = 2*valores [i-1];
        }
        System.out.print("Se ha generado el siguiente array [");
        for (int i = 0; i < valores.length; i++) {
            System.out.print(valores[i] + " ");
        }
        System.out.print(" ]");   
    }
}
