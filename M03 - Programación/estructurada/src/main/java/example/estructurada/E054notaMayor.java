package example.estructurada;

public class E054notaMayor {

    public static void main(String[] args) {
// array de notas
        float[] notas = {2f, 5.5f, 9f, 10f, 4.9f, 8.5f, 7f, 6.6f, 5f, 9.7f};
        // declarar sumatorio 
        float max=0f;
        for (int i = 0; i < notas.length; i++) {
            if(max < notas[i]){
                max=notas[i];
            }
        }
        System.out.println("EL NUMERO MAYOR ES: " + max);
    }

}
