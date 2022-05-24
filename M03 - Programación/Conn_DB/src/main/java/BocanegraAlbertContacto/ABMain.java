package BocanegraAlbertContacto;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Scanner;

public class ABMain{
    
    private ArrayList<ABContacto> TodosContactos = new ArrayList<ABContacto>();
    private ABContacto aux;
    private Scanner entrada = new Scanner(System.in);
    private static boolean bandera = false;
    
    public static void main(String[] args) {
        ABMain programaMain = new ABMain();
        ABContacto programaContacto = new ABContacto();
        
        while(!bandera){
            programaMain.mostrarOpciones();
            programaMain.opciones();
        }
        System.out.println("MUCHAS GRACIAS POR HABER UTILIZADO EL PROGRAMA");
                
    }
    
    public void mostrarOpciones(){
        System.out.println("Tienes " + TodosContactos.size() + " contactos.");
        System.out.println("Selecciona una de estas opciones:");
        System.out.println("    [1] Añadir contactos");
        System.out.println("    [2] Buscar contactos");
        System.out.println("    [3] Borrar contactos");
        System.out.println("    [4] Mostrar contactos");
        System.out.println("    [5] Salir");
        System.out.println("Introduce un numero del 1 al 5:");
        
    }
    
    public int escogerOpcion(){
        int auxOpcion = 0;
        boolean auxBandera = false;
        
        while(!auxBandera){
            if(entrada.hasNextInt()){
                auxOpcion = entrada.nextInt();
                if(auxOpcion > 0 && auxOpcion < 6){
                    auxBandera = true;
                }else{
                    System.out.println("Tienes que introducir un numero del 1 al 5.");
                }
            }else{
                entrada.nextLine();
                System.out.println("Has introducido un valor incorrecto.");
                mostrarOpciones();
            }
        }
        return auxOpcion;
    }
    

    private void opciones() {
        int opcion = escogerOpcion();
        switch (opcion) {
            case 1:
                addContactos();
                break;
            case 2:
                searchContactos();
                break;
            case 3:
                delContactos();
                break;
            case 4:
                mostrarContactos();
                break;
            case 5:
                bandera = true;
                break;
            default:
                System.out.println("ERROR");
                break;
        }
    }
    
    private void addContactos(){
        String auxNombre = "", auxEmpresa = "", auxEmail = "";
        int auxTelefono = 0;

        boolean auxBandera = false;
        while(!auxBandera){
            System.out.println("Introduce el nombre: ");
            if(entrada.hasNext()){
                auxNombre = entrada.next();
                auxBandera = true;
            }else{
                entrada.nextLine();
                System.out.println("Has introducido un dato incorrecto.");
            }
        }

        auxBandera = false;

        while(!auxBandera){
            System.out.println("Introduce el nombre de la empresa: ");
            if(entrada.hasNext()){
                auxEmpresa = entrada.next();
                auxBandera = true;
            }else{
                entrada.nextLine();
                System.out.println("Has introducido un valor incorrecto.");
            }
        }

        auxBandera = false;

        while(!auxBandera){
            System.out.println("Introduce el correo electronico: ");
            if(entrada.hasNext()){
                auxEmail = entrada.next();
                auxBandera = true;
            }else{
                entrada.nextLine();
                System.out.println("Has introducido un valor incorrecto.");
            }
        }

        auxBandera = false;

        while(!auxBandera){
            System.out.println("Introduce el numero de telefono: ");
            if(entrada.hasNext()){
                auxTelefono = entrada.nextInt();
                auxBandera = true;
            }else{
                entrada.nextLine();
                System.out.println("Has introducido un valor incorrecto.");
            }
        }

        aux = new ABContacto(auxNombre, auxEmpresa, auxEmail, auxTelefono);
        TodosContactos.add(aux);
        escribirArchivo();
    }
    
    private void mostrarContactos(){
        for(int i = 0; i<TodosContactos.size(); i++){
            System.out.println("Contacto " + (i+1) + ":");
            System.out.println("    Nombre: " + TodosContactos.get(i).getNombre());
            System.out.println("    Email: " + TodosContactos.get(i).getEmail());
            System.out.println("    Empresa: " + TodosContactos.get(i).getEmpresa());
            System.out.println("    Telefono: " + TodosContactos.get(i).getTelefono());
        }
    }
    
    private void searchContactos(){
        
    }
    
    private void delContactos(){
        if(TodosContactos.size() > 0){
            mostrarContactos();
            boolean auxBandera = false;
            int opcion = 0;
            while(!auxBandera){
                System.out.println("Introduce el numero de contacto que quieres eliminar:");
                if(entrada.hasNextInt()){
                    opcion = entrada.nextInt();
                    if(0 < opcion && opcion < TodosContactos.size()){
                        auxBandera = true;
                        opcion--;
                    }else{
                        System.out.println("Tienes que introducir un numero entre 1 y " + TodosContactos.size());
                    }
                }else{
                    entrada.nextLine();
                    System.out.println("Has introducido un valor no valido");
                }
            }
            TodosContactos.remove(opcion);
            escribirArchivo();
        }else{
            System.out.println("No hay ningun contacto introducido.");
        }
        
    }
    
    private void escribirArchivo(){
        try (
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("BocanegraAlbert.bin"));
        ){                
            for(int i = 0; i<TodosContactos.size(); i++){
                oos.writeObject(TodosContactos.get(i));
            }
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }
}