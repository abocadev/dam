package example.estructurada;

public class E059bidimensionalNotas {

    public static void main(String[] args) {
        float [][]notas = {
            {5.5f, 6f, 5f, 8f, 0f},
            {10f, 8f, 7.5f, 9.5f, 0f},
            {3f, 2.5f, 4.5f, 6f, 0},
            {6f, 8.5f, 6f, 4f, 0f},
            {9f, 7.4f, 7f, 8f, 0f},
        };
        //media aritmetica del curso para todos los estudiantes
        float sumafinales = 0;
        //recorrida fila por fila, segun i
        //cada fila es un estudiante
        
        //notas.length nos dara el numero de estudiantes
        for(int i = 0; i<notas.length;i++){
            //acumulado de notas de UN estudiante
            float sumaNotasuno = 0;
            
            //recorrido de cada fila - cada estudiante
            // las notas las indexa j
            //notas[i].length evalua el numero de posiciones de la fila
            for(int j= 0; j<notas[i].length;j++){
                //estamos en la ultima posicion de la fila?
                //es importante porque al final de la fila se hara la media
                if(j!=(notas[i].length-1)){
                    //si no es la ultima posicion, seguimos la media
                    sumaNotasuno = sumaNotasuno + notas[i][j];
                }else{
                    // si SI es la ultima posicion, hay que escribir la media
                    float notaMedia = sumaNotasuno/(notas[i].length);
                    notas[i][j]=notaMedia;
                    System.out.println("El estudiante " + i + " ha sacado un " + notaMedia + ".");
                    
                    // se actualiza la suma de las media de todos los estudiantes
                    sumafinales = sumafinales + notaMedia;
                }
            }
            //fin recorrido filas
        }
        //
        float mediaFinal = sumafinales/notas.length;
        System.out.println("La nota media del curso es " + mediaFinal);
    }
    
}
