package dev.boca.uf5.bibliotecas_clases_fundamentales;

import java.awt.Dimension;
import java.awt.HeadlessException;
import javax.swing.JFrame;

public class E002titulo extends JFrame {
    public E002titulo (String string) throws HeadlessException{
        super(string);
        Dimension d = new Dimension(300, 300);
        this.setSize(d);
        
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}
