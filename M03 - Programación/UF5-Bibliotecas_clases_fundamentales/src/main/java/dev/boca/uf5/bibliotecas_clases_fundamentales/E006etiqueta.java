package dev.boca.uf5.bibliotecas_clases_fundamentales;

import java.awt.Color;
import java.awt.HeadlessException;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class E006etiqueta extends JFrame{
    public E006etiqueta (String string) throws HeadlessException{
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
        // deshabilitar el layout por defecto
        panel.setLayout(null);
        this.getContentPane().add(panel);
        panel.setBackground(Color.cyan);
        
        // CREAR LABEL
        JLabel etiqueta = new JLabel();
        etiqueta.setText("Etiqueta espectacular");
        //JLabel etiqueta = new JLabel("Etiqueta molona");
        panel.add(etiqueta);
        
        etiqueta.setBounds(100, 100, 200, 30); // tras deshabilitar el layout del panel
        
        // cambiar el color de la fuente
        etiqueta.setForeground(Color.yellow);
        // deshabilitar el layout por defecto de la etiqueta para cambiar el color de fondo
        etiqueta.setOpaque(true);
        etiqueta.setBackground(Color.red);
        
    }
}
