package dev.boca.uf5.bibliotecas_clases_fundamentales;

import java.awt.HeadlessException;
import javax.swing.JFrame;

public class E003ventana extends JFrame{

    public E003ventana(String string) throws HeadlessException {
        super(string);
        this.setSize(400, 400);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(rootPaneCheckingEnabled);
        this.setLocation(300, 300);
    }
    
}
