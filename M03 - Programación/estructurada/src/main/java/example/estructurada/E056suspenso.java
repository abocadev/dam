package example.estructurada;
public class E056suspenso {
    public static void main(String[] args) {
        float[] notas = {2f, 5.5f, 9f, 10f, 4.9f, 8.5f, 7f, 6.6f, 5f, 9.7f};
        int i = 0;
        boolean suspenso = false;
        while((i < notas.length) && !suspenso){
            if(notas[i] < 5){
                suspenso = true;
            }
            i++;
        }
        if(suspenso){
            System.out.println("Alguien ha suspendido");
        }else{
            System.err.println("Nadie ha suspendido");
        }
    }
}