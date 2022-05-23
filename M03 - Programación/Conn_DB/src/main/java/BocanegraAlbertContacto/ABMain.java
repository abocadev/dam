package BocanegraAlbertContacto;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

public class ABMain{
    
    private ABContacto contacto1 = null, contacto2 = null, contacto3 = null, contacto4 = null, contacto5 = null, contacto6 = null, contacto7 = null, contacto8 = null, contacto9 = null, contacto10 = null;
    private Scanner entrada = new Scanner(System.in);
    private static int contactos = 0;
    private static boolean bandera = false;
    
    public static void main(String[] args) {
        ABMain programa = new ABMain();
        while(!bandera){
            programa.mostrarOpciones();
            programa.opciones();
        }
        System.out.println("MUCHAS GRACIAS POR HABER UTILIZADO EL PROGRAMA");
                
    }
    
    public void mostrarOpciones(){
        System.out.println("Selecciona una de estas opciones:");
        System.out.println("    [1] Añadir contactos");
        System.out.println("    [2] Buscar contactos");
        System.out.println("    [3] Borrar contactos");
        System.out.println("    [4] Añadir contactos automaticamente");
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
                System.out.println("Has introducido un valor incorrecto.");
                mostrarOpciones();
            }
        }
        return auxOpcion;
    }
    

    private void opciones() {
        int opcion = escogerOpcion();
        if(opcion == 1){
            addContactos();
        }else if(opcion == 2){
            searchContactos();
        }else if(opcion == 3){
            delContactos();
        }else if(opcion == 4){
            addAutomaticContactos();
        }else if(opcion == 5){
            bandera = true;
        }
    }
    
    private void addContactos(){
        try (
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("BocanegraAlbert.bin"));
        ){
            String auxNombre = "", auxEmpresa = "", auxEmail = "";
            int auxTelefono = 0;

            boolean auxBandera = false;
            while(!auxBandera){
                System.out.println("Introduce el nombre: ");
                if(entrada.hasNext()){
                    auxNombre = entrada.next();
                    auxBandera = true;
                }else{
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
                    System.out.println("Has introducido un valor incorrecto.");
                }
            }

            if(contacto1 == null){
                contacto1 = new ABContacto(auxNombre, auxEmpresa, auxEmail, auxTelefono);
                oos.writeObject(contacto1);
            }else if(contacto2 == null){
                contacto2 = new ABContacto(auxNombre, auxEmpresa, auxEmail, auxTelefono);
                oos.writeObject(contacto2);
            }else if(contacto3 == null){
                contacto3 = new ABContacto(auxNombre, auxEmpresa, auxEmail, auxTelefono);
                oos.writeObject(contacto3);
            }else if(contacto4 == null){
                contacto4 = new ABContacto(auxNombre, auxEmpresa, auxEmail, auxTelefono);
                oos.writeObject(contacto4);
            }else if(contacto5 == null){
                contacto5 = new ABContacto(auxNombre, auxEmpresa, auxEmail, auxTelefono);
                oos.writeObject(contacto5);
            }else if(contacto6 == null){
                contacto6 = new ABContacto(auxNombre, auxEmpresa, auxEmail, auxTelefono);
                oos.writeObject(contacto6);
            }else if(contacto7 == null){
                contacto7 = new ABContacto(auxNombre, auxEmpresa, auxEmail, auxTelefono);
                oos.writeObject(contacto7);
            }else if(contacto8 == null){
                contacto8 = new ABContacto(auxNombre, auxEmpresa, auxEmail, auxTelefono);
                oos.writeObject(contacto8);
            }else if(contacto9 == null){
                contacto9 = new ABContacto(auxNombre, auxEmpresa, auxEmail, auxTelefono);
                oos.writeObject(contacto9);
            }else if (contacto10 == null){
                contacto10 = new ABContacto(auxNombre, auxEmpresa, auxEmail, auxTelefono);
                oos.writeObject(contacto10);
            }
        }catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }
    
    
    private void searchContactos(){
        
    }
    
    private void delContactos(){
        
    }
    
    private void addAutomaticContactos(){
        
    }
}