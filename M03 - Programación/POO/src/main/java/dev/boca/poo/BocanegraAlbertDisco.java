package dev.boca.poo;

import static dev.boca.poo.BocanegraAlbertDiscoMain.main;
import java.util.ArrayList;
import java.util.Scanner;

public class BocanegraAlbertDisco {
    
    BocanegraAlbertDiscoMain programaClassMain = new BocanegraAlbertDiscoMain();
    Scanner entrada = new Scanner(System.in);
    
    private static int totalDiscos = 0;
    
    
    private int opcion;
    
    // atributos
    private static ArrayList<String> nombreAlbum    = new ArrayList<String>(); 
    private static ArrayList<String> nombreArtista  = new ArrayList<String>(); 
    private static ArrayList<Integer> yearAlbum     = new ArrayList<Integer>(); 
    private static ArrayList<Integer> minAlbum      = new ArrayList<Integer>();

    public BocanegraAlbertDisco(int _opcion) {
        this.opcion = _opcion;
    }
    
    public void escogerOpcion(){
        if(opcion == 1){
            if(totalDiscos > 0){
                for(int i = 0; i<totalDiscos; i++){
                    System.out.println("DISCO Nº " + (i+1) + ":");
                    System.out.println("    Nombre del Disco: " + nombreAlbum.get(i));
                    System.out.println("    Nombre del Artista: " + nombreArtista.get(i));
                    System.out.println("    Año del Disco: " + yearAlbum.get(i));
                    System.out.println("    Minutos del Disco: " + minAlbum.get(i));
                }
            }else{
                System.out.println("NO SE HAN INSERTADO DATOS");
            }
            programaClassMain.main(null);
        }else if(opcion == 2){
            introducirDiscos();
            programaClassMain.main(null);
        }else if(opcion == 3){
            for(int i = 0; i<totalDiscos; i++){
                System.out.println("DISCO Nº " + (i+1) + ":");
                    System.out.println("    Nombre del Disco: " + nombreAlbum.get(i));
                    System.out.println("    Nombre del Artista: " + nombreArtista.get(i));
                    System.out.println("    Año del Disco: " + yearAlbum.get(i));
                    System.out.println("    Minutos del Disco: " + minAlbum.get(i));
            }
            int discoBorrado = borrarDisco(totalDiscos);
            nombreAlbum.remove(discoBorrado);
            nombreArtista.remove(discoBorrado);
            yearAlbum.remove(discoBorrado);
            
            programaClassMain.main(null);
        }else if(opcion == 4){
            System.out.println("MUCHAS GRACIAS POR HABER UTILIZADO EL PROGRAMA");
            salirPrograma();
        }else{
            System.out.println("NUMERO NO VALIDO, TIENES QUE INSERTAR UN NUMERO DEL 1 AL 4.");
            programaClassMain.main(null);
        }
    }
    
    
    public void introducirDiscos(){
        boolean salir = false;
        
        while(!salir){
            System.out.println("INTRODUCE UN NOMBRE PARA EL ALBUM:");
            if(entrada.hasNextLine()){
                nombreAlbum.add(entrada.nextLine());
                salir = true;
            }else{
                entrada.nextLine();
                System.out.println("Has introducido un caracter incorrecto");
            }
        }
        
        salir = false;
        
        while(!salir){
            System.out.println("INTRODUCE EL NOMBRE DEL ARTISTA:");
            if(entrada.hasNextLine()){
                nombreArtista.add(entrada.nextLine());
                salir = true;
            }else{
                entrada.nextLine();
                System.out.println("Has introducido un caracter incorrecto");
            }
        }
        
        salir = false;
        
        while(!salir){
            System.out.println("INTRODUCE EL AÑO DEL ALBUM:");
            if(entrada.hasNextInt()){
                yearAlbum.add(entrada.nextInt());
                salir = true;
            }else{
                entrada.nextLine();
                System.out.println("Has introducido un caracter incorrecto");
            }
        }
        
        salir = false;
        
        while(!salir){
            System.out.println("INTRODUCE LA DURACIÓN DEL ALBUM (minutos):");
            if(entrada.hasNextInt()){
                minAlbum.add(entrada.nextInt());
                salir = true;
            }else{
                entrada.nextLine();
                System.out.println("Has introducido un caracter incorrecto");
            }
        }
        
        BocanegraAlbertDisco.totalDiscos++;
    }
    
    public int borrarDisco(int tam){
        int respuesta = 0;
        boolean salir = false;
        while(!salir){
            System.out.println("ESCRIBE EL DISCO A BORRAR: ");
            if(entrada.hasNextInt()){
                respuesta = entrada.nextInt();
                if(respuesta >= 1 && respuesta<=tam){
                    salir = true;
                }else{
                    System.out.println("El numero que tienes que insertar tiene que ser entre 1 y " + tam);
                            
                }
            }else{
                entrada.nextLine();
                System.out.println("Has introducido un valor incorrecto");
            }
        }
        BocanegraAlbertDisco.totalDiscos--;
        return respuesta - 1;
    }
    
    public static void salirPrograma(){
        System.out.println("Este metodo sale del programa");
        System.exit(0);
    }

    public static int getTotalDiscos() {
        return totalDiscos;
    }
}