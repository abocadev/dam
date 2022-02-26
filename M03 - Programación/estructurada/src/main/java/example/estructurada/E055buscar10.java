package example.estructurada;
public class E055buscar10 {

    public static void main(String[] args) {
        // array de notas
        float[] notas = {2f, 5.5f, 9f, 10f, 4.9f, 8.5f, 7f, 6.6f, 5f, 9.7f};
        // bandera
        boolean encontrado = false;
        // contador de posiciones
        int i = 0;
        //comprobar las posiciones del array
        while ((i<notas.length) && !encontrado) {            
            if(notas[i] == 10){
                encontrado = true;
            }
            i++;
        }
        //¿se ha encontrado un 10?
        if(encontrado){
            System.out.println("Se ha encontrado un 10");
        }else{
            System.out.println("No se ha encontrado un 10");
        }
    }
    
}