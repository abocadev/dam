package dev.boca.uf5.bibliotecas_clases_fundamentales;

import java.awt.Dimension;
import java.awt.HeadlessException;
import javax.swing.JFrame;

public class E001ventana extends JFrame {

    // constructor
    public E001ventana() throws HeadlessException {
        Dimension d = new Dimension(500, 500);
        this.setSize(d);
    }
    
    public void setSize(int width, int height){
        super.setSize(width,height);
    }
    
}
