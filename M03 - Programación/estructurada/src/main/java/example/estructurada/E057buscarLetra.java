package example.estructurada;

public class E057buscarLetra {

    public static void main(String[] args) {
        char [] letras = {'a', 'h', 'd', 's', 'q', 'w', 'e', 'r', 't', 'y', 'z', 'x', 'c', 'v', 'm'};
        boolean encontrado = false;
        int i = 0;
        while((i<letras.length) && !encontrado){
            if(letras[i]== 'm'){
                encontrado = true;
            }
            i++;
        }
        if(encontrado){
            System.out.println("Se ha encontrado una 'm'");
        }else{
            System.out.println("No hay ninguna manera 'm'");
        }
    }
    
}
