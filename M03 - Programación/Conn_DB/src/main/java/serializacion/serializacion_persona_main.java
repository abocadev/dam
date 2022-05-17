package serializacion;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class serializacion_persona_main {
    public static void main(String[] args) {
        // Instancias objetos        
        Serializacion_persona antonio = new Serializacion_persona("Antonio", "Lope", 20, 15000);
        Serializacion_persona pilar = new Serializacion_persona("Pilar", "Lopez", 72, 4500);
        
        try (
            ObjectOutputStream oss = new ObjectOutputStream(new FileOutputStream("plantilla.bin"));
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("plantilla.bin"));
        ){
            // escribo en el fichero
            oss.writeObject(antonio);
            oss.writeObject(pilar);
            
            // leer
            // cuando no queden mas objetos, 
            while(true){
                Serializacion_persona aux = (Serializacion_persona)ois.readObject();
                System.out.println(antonio.getApellido());
                System.out.println(aux.getEdad());
                System.out.println(aux.getSalario());
            }
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }
}
