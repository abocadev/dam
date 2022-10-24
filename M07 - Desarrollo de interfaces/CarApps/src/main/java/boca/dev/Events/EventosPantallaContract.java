package boca.dev.Events;

import boca.dev.Screens.PantallaContract;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import javax.swing.JOptionPane;

public class EventosPantallaContract {
    public static MouseListener  DownloadFile(){
        MouseListener l = new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    String sFichero = "Contrato" + PantallaContract.marca + "" + PantallaContract.modelo + ".txt";
                    File fichero = new File(sFichero);
                    if(fichero.exists()){
                        sFichero = JOptionPane.showInputDialog("El nombre ya existe indiquele otro nombre: ") + ".txt";
                        fichero = new File(sFichero);
                    }
                    BufferedWriter bw = new BufferedWriter(new FileWriter(sFichero));
                    bw.write(PantallaContract.contrato);
                    bw.close();
                    JOptionPane.showMessageDialog(null, "EL FICHERO SE HA CREADO CORRECTAMENTE 👍");                    
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
