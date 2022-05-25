package TorresKatlheenContacto;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class KTMain{
    
    private ArrayList<Contacto> TodosContactos = new ArrayList<Contacto>();
    private ABContacto aux;
    private Scanner entrada = new Scanner(System.in);
    private static boolean bandera = false;
    
    public static void main(String[] args) {
        KTMain programaMain = new KTMain();
        programaMain.importarDatosAntiguos();
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
        System.out.println("    [5] Importar contactos");
        System.out.println("    [6] Salir");
        System.out.println("Introduce un numero del 1 al 5:");
        
        int opcion = 0;
        boolean auxBandera = false;
        while(!auxBandera){
            if(entrada.hasNextInt()){
                opcion = entrada.nextInt();
                if(opcion > 0 && opcion < 7){
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
                importarContactos();
                break;
            case 6:
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
        System.out.println("Introduce el nombre: ");
        auxNombre = entrada.next();
        System.out.println("Introduce el nombre de la empresa: ");
        auxEmpresa = entrada.next();
        System.out.println("Introduce el correo electronico: ");
        auxEmail = entrada.next();
        System.out.println("Introduce el numero de telefono: ");
        auxTelefono = entrada.nextInt();

        aux = new ABContacto(auxNombre, auxEmpresa, auxEmail, auxTelefono);
        TodosContactos.add(aux);
        escribirArchivo();
    }
    
    private void searchContactos(){
        // Aqui tienes que introducir el nombre del archivo
        int nResultados = 0;
        try (
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("TorresKatlheen.bin"));
        ){
            String busqueda = "";
            System.out.println("Introduce un nombre del contacto a buscar: ");
            busqueda = entrada.next();

            int nResultados = 0;

            while(true){
                ABContacto aux = (ABContacto)ois.readObject();
                if(busqueda.equals(aux.getNombre())){
                    nResultados++;
                }
            }
        } catch (Exception e) {
        }
        System.out.println("Se han encontrado " + nResultados);
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
                    if(0 < opcion && opcion <= TodosContactos.size()){
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

    private void mostrarContactos(){
        try (
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("TorresKatlheen.bin"));
        ){
            int num  = 1;
            while (true) {
                ABContacto aux = (ABContacto)ois.readObject();
                System.out.println("\n----------------------------------------------------------------------");
                System.out.println("\nContacto " + num + ":");
                System.out.println("    Nombre: " + aux.getNombre());
                System.out.println("    Email: " + aux.getEmail());
                System.out.println("    Empresa: " + aux.getEmpresa());
                System.out.println("    Telefono: " + aux.getTelefono());
                num++;
            }
        } catch (Exception e) {
        }
        System.out.println("----------------------------------------------------------------------");
    }
    
    public void importarContactos(){
        
        try{
            ObjectInputStream ois;
            File archivo = null;
            boolean auxBandera = false;
            while(!auxBandera){
                System.out.println("Inserta el nombre del fichero a impotar: ");
                if(entrada.hasNext()){
                    archivo = new File(entrada.next());
                    if(archivo.exists()){
                       auxBandera = true; 
                    }else{
                        System.out.println("El fichero que has introducido no existe");
                    }
                }
            }
            
            ois = new ObjectInputStream(new FileInputStream(archivo));
            while(true){
                ABContacto aux = (ABContacto)ois.readObject();
                
            }
        }catch(Exception e){
            
        }
    }
    
    private void importarDatosAntiguos(){
        try (
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("TorresKatlheen.bin"));) {
            while (true) {
                ABContacto aux = (ABContacto) ois.readObject();
                aux = new ABContacto(aux.getNombre(), aux.getEmpresa(), aux.getEmail(), aux.getTelefono());
                TodosContactos.add(aux);
            }
        } catch (Exception e) {
        }
        escribirArchivo();
    }
    
    private void escribirArchivo(){
        try{   
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("TorresKatlheen.bin"));
            for(int i = 0; i<TodosContactos.size(); i++){
                oos.writeObject(TodosContactos.get(i));
            }
        } catch (Exception e) {
        }
    }
}