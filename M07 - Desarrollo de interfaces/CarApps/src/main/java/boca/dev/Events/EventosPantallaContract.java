package boca.dev.Events;

import boca.dev.Screens.PantallaContract;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import javax.swing.JOptionPane;

public class EventosPantallaContract {
    // Este evento es para descargar el fichero del contrato
    public static MouseListener DownloadFile(){
        MouseListener l = new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                
                try {
                    String sFichero = "Contrato" + PantallaContract.marca + "" + PantallaContract.modelo + ".txt"; // Creamos el nombre para el archivo
                    File fichero = new File(sFichero);
                    
                    if(fichero.exists()){ // Comprobamos si existe un fichero con ese nombre y si existe que el usuario le ponga un nombre
                        sFichero = JOptionPane.showInputDialog("El nombre ya existe indiquele otro nombre: ") + ".txt";
                        fichero = new File(sFichero);
                    }
                    
                    BufferedWriter bw = new BufferedWriter(new FileWriter(sFichero));
                    bw.write(PantallaContract.contrato); // Escribimos el contrato en el fichero
                    bw.close();
                    JOptionPane.showMessageDialog(null, "EL FICHERO SE HA CREADO CORRECTAMENTE 👍\nSe llama: " + sFichero);                    
                } catch (Exception ex) {
                }
            }
            @Override public void mousePressed(MouseEvent e) {}
            @Override public void mouseReleased(MouseEvent e) {}
            @Override public void mouseEntered(MouseEvent e) {}
            @Override public void mouseExited(MouseEvent e) {}
        };
        return l;
    }
}
