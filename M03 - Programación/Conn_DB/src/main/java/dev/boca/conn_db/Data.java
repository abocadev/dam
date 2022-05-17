package dev.boca.conn_db;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class Data {
    public static void main(String[] args) {
        try (
                DataOutputStream dos = new DataOutputStream(new FileOutputStream("binario.bin"));
                DataInputStream dis = new DataInputStream(new FileInputStream("binario.bin"));
            )
        {
            // escribir un numero
            dos.writeInt(25);
            
            // escribir una cadena de texto
            dos.writeUTF("adios mundo");
            
            // escribir otro numero
            dos.writeInt(878);
            
            System.out.println(dis.readInt());
            System.out.println(dis.readUTF());
            System.out.println(dis.readInt());
           
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }
}
