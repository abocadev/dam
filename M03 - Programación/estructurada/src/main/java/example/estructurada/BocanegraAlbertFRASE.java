package example.estructurada;

// librerias que utilizo para sustituir acentos
import java.text.Normalizer;
// libreria para pdeir 
import java.util.Scanner;

public class BocanegraAlbertFRASE {
    // LO QUE HAREMOS ES COMPROBAR QUE ESTA FRASE SE PUEDE LEER IGUAL DE DERECHA A IZQUIERDA Y DE IZQUIERDA A DERECHA
    public static void main(String[] args) {
        // declaramos el scanner
        Scanner input = new Scanner (System.in);
        System.out.println("Introduciras una frase y el programa te dira si se puede leer.\nIntroduce una frase:");
        // declaramos la bandera del bucle
        boolean validado = false;
        String frase = "";
        // creamos el bucle donde comprobaremos si se ha escrito una frase o si se ha puesto la frase
        do{
            if(input.hasNextLine()){
                frase = input.nextLine();
                // comprobamos si se ha puesto texto o no 
                if(frase.equals("")){
                    System.out.println("No has introducido ninguna frase.\nInserta una frase:");
                }else{
                    validado = true;

                }
            }else{
                System.out.println("La frase que has introducido no es valida.\n Inserta una nueva frase.");
            }
        }while(!validado);
        // lo que hacemos es llamar a una libreria para que sustituya los acentos y las dieresis
        frase = Normalizer.normalize(frase, Normalizer.Form.NFD);
        frase = frase.replaceAll("[^\\p{ASCII}]", "");
        // declaramos las variables para invertir de orden las letras
        String frase1[] = frase.split(" "), frasejunta = "", frasecapicua = "";
        // lo que hacemos es quitar los espacios 
        for(int i = 0; i<frase1.length;i++){
                frasejunta = frasejunta + frase1[i];
        }
        // y lo que hacemos aquí es girar el orden de las letras
        for(int i = 0; i<frasejunta.length(); i++){
                frasecapicua = frasecapicua + frasejunta.charAt((frasejunta.length()-1)-i);
        }
        
        // comprobamos si frasejunta == frasecapicua
        if(frasejunta.equals(frasecapicua)){
            System.out.println("La frase que has introducido se puede leer igual de derecha a izquierda y de izquierda a derecha");
        }else{
            System.out.println("La frase que has introducido no se puede leer igual de derecha a izquierda y de izquierda a derecha");
        }
        
        System.out.println("La frase que has introducido es: " + frasejunta + "\nY la frase girada es: " + frasecapicua);
    }
}