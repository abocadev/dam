package dev.boca.poo;

import java.util.ArrayList;
import java.util.Scanner;

public class BocanegraAlbertDisco {
    
    // Declaramos un metodo del archivo Main
    BocanegraAlbertDiscoMain programaClassMain = new BocanegraAlbertDiscoMain();
    
    // Creamos una variable para el escaner
    Scanner entrada = new Scanner(System.in);
    
    // Creamos una variable para que cuente cuantos discos hay
    private static int totalDiscos = 0; 
    // Creamos un atributo para que obtenga la opcion
    private int opcion;
    
    // Creamos 4 arrayList estaticos para que se mantengan los cambios del array al cambiar el archivo y 
    // uno almacene el nombre del Album, el nombre del Artista, el año del Album y la duracion del Album en MINUTOS
    private static ArrayList<String> nombreAlbum = new ArrayList<String>(); 
    private static ArrayList<String> nombreArtista = new ArrayList<String>(); 
    private static ArrayList<Integer> yearAlbum = new ArrayList<Integer>(); 
    private static ArrayList<Integer> minAlbum = new ArrayList<Integer>();
    
    // Hacemos un constructor para que se almacene la opcion
    public BocanegraAlbertDisco(int _opcion) {
        this.opcion = _opcion;
    }
    
    // Hacemos otro constructor vacio
    public BocanegraAlbertDisco(){
    }
    // Creamos un metodo para almacenar una opcion
    // En el caso de que haya indicado correctamente el numero te enviara a lo que tu le hayas pedido
    // Y en el caso de que no te devolvera al archivo Main
    public void escogerOpcion(){
        if(opcion == 1){
            listarDiscos();
        }else if(opcion == 2){
            introducirDiscos();
        }else if(opcion == 3){
            borrarDisco();
        }else if(opcion == 4){
            salirPrograma();
        }else{
            System.out.println("NUMERO NO VALIDO, TIENES QUE INSERTAR UN NUMERO DEL 1 AL 4.");
            programaClassMain.main(null);
        }
    }
    
    // Creamos un metodo para listar los discos y no lo haremos con un bucle
    // Y cuando termine nos devolvera al archivo menu (el archivo MAIN)
    public void listarDiscos(){
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
    }
    
    // Lo que hacemos en este metodo es introducir los datos del disco
    // En el caso que hayamos introducido un valor incorrecto nos volvera pedir el valor
    public void introducirDiscos(){
        boolean salir = false;
        
        // Aqui creamos un bucle para insertar el nombre del album y en el caso de que se haya insertado el valor correcto se saldra del bucle
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
        
        // Aqui creamos un bucle para insertar el nombre del artista y en el caso de que se haya insertado el valor correcto se saldra del bucle

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
        
        // Aqui creamos un bucle para insertar el año del album y en el caso de que se haya insertado el valor correcto se saldra del bucle
        
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
        
        // Aqui creamos un bucle para insertar la duracion del album y en el caso de que se haya insertado el valor correcto se saldra del bucle
        
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
        
        // Aqui lo que hacemos es incrementar la cantidad de discos y nos volveremos al menu
        BocanegraAlbertDisco.totalDiscos++;
        programaClassMain.main(null);
    }
    
    // Crearemos un metodo para borrar algun Disco
    public void borrarDisco(){
        
        // Imprimiremos todos los discos que hay, para que sepa los discos que hay
        for(int i = 0; i<totalDiscos; i++){
                System.out.println("DISCO Nº " + (i+1) + ":");
                System.out.println("    Nombre del Disco: " + nombreAlbum.get(i));
                System.out.println("    Nombre del Artista: " + nombreArtista.get(i));
                System.out.println("    Año del Disco: " + yearAlbum.get(i));
                System.out.println("    Minutos del Disco: " + minAlbum.get(i));
        }
        
        // Declaramos dos variables una para saber la respuesta del usuario y otra para salir del bucle
        int respuesta = 0;
        boolean salir = false;
        
        // Creamos un bucle para comprobar que el numero insertado es un valor correcto y esta entre los valores o si no se han añadido discos
        // En el caso de que no haya discos se lo indicaremos al usuario
        if(totalDiscos == 0){
                    System.out.println("NO SE HAN AÑADIDO DISCOS");
        }else{ // En el caso de que haya iniciaremos el bucle para comprobar que el valor es correcto y que se puede borrar el numero del disco
            while(!salir){
                System.out.println("ESCRIBE EL DISCO A BORRAR: ");
                if(entrada.hasNextInt()){
                    respuesta = entrada.nextInt();
                    if(respuesta >= 1 && respuesta<=totalDiscos){
                        salir = true;
                        nombreAlbum.remove(respuesta - 1);
                        nombreArtista.remove(respuesta - 1);
                        yearAlbum.remove(respuesta - 1);
                        BocanegraAlbertDisco.totalDiscos--;
                    } else{
                        System.out.println("El numero que tienes que insertar tiene que ser entre 1 y " + totalDiscos);

                    }
                }else{
                    entrada.nextLine();
                    System.out.println("Has introducido un valor incorrecto");
                }
            }
        }
        // Y volveremos a salir al archivo Main
        programaClassMain.main(null);
    }
    
    // Este metodo lo utilizaremos para salir del programa
    public static void salirPrograma(){
        System.out.println("MUCHAS GRACIAS POR HABER UTILIZADO EL PROGRAMA");
        System.exit(0);
    }
    
    // Este metodo lo utilizaremos para obtener el total de los discos
    public static int getTotalDiscos() {
        return totalDiscos;
    }
}