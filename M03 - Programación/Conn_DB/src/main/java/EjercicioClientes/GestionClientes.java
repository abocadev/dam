package EjercicioClientes;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

public class GestionClientes {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        
        boolean salir = false;
        int opcion = 0;
        String DNI, nombre, telefono;
        Cliente clienteMolon;
        File fichero = new File("clientes.dat");
        
        while(!salir){
            System.out.println("Selecciona una opcion:");
            System.out.println("    [1] Crear fichero");
            System.out.println("    [2] Añadir cliente");
            System.out.println("    [3] Listar clientes");
            System.out.println("    [4] Borrar fichero");
            System.out.println("    [5] Salir");
            
            try {
                System.out.println("Elige una opcion:");
                opcion = entrada.nextInt();
                switch (opcion) {
                    case 1:
                        // evaluar si existe el fichero
                        if(fichero.exists()){
                            System.out.println("El fichero ya existe");
                        }else{
                            fichero.createNewFile();
                            System.out.println("Fichero creado");
                        }
                        break;
                        
                    case 2:
                        System.out.println("Introduce el DNI: ");
                        DNI = entrada.next();
                        
                        // validar DNI
                        
                        System.out.println("Introduce el nombre: ");
                        nombre = entrada.next();
                        
                        System.out.println("Introduce el telefono: ");
                        telefono = entrada.next();
                        
                        clienteMolon = new Cliente(DNI, nombre, telefono);
                        
                        // escribir en el fichero serializado
                        // ojo cabeceras!!
                        
                        ObjectOutputStream oos;
                        if(fichero.length() == 0){
                            oos = new ObjectOutputStream(new FileOutputStream(fichero));
                        }else{
                            oos = new serializacion.MyObjectOutputStream(new FileOutputStream(fichero, true));
                        }
                        
                        oos.writeObject(clienteMolon);
                        break;
                        
                     case 3:
                        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fichero));
                        
                        while(true){
                            clienteMolon = (Cliente)ois.readObject();
                            System.out.println(clienteMolon.toString());
                        }
                        
                        // break;
                        
                    case 4:
                        if(fichero.exists()){
                            fichero.delete();
                            System.out.println("El fichero se ha borrado CORRECTAMENTE");
                        }else{
                            System.out.println("No existe ningun fichero que borrar");
                        }
                        break;
                        
                    case 5:
                        salir = true;
                        break;
                    default:
                        throw new AssertionError();
                }
            } catch (Exception e) {
            }
        }
    }
}
