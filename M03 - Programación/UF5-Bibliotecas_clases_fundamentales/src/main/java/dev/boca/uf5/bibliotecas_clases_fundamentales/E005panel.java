package dev.boca.uf5.bibliotecas_clases_fundamentales;

import java.awt.Color;
import java.awt.HeadlessException;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class E005panel extends JFrame{
    public E005panel (String string) throws HeadlessException{
        super(string);
        setVisible(true);
        setSize(500,500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        // llamar al metodo que crea componentes
        crearComponentes();
    }
    
    // NUEVO METODO
    private void crearComponentes(){
        // crear un JPanel
        JPanel panel = new JPanel();
        // No esta sobre la ventana
        this.getContentPane().add(panel);
        // poner color
        panel.setBackground(Color.yellow);
    }
}
