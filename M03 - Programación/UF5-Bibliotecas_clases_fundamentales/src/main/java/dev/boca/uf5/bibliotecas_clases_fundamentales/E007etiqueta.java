package dev.boca.uf5.bibliotecas_clases_fundamentales;

import java.awt.Color;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class E007etiqueta extends JFrame{
    public E007etiqueta (String string) throws HeadlessException{
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
        //JLabel etiqueta = new JLabel();
        // etiqueta.setText("Etiqueta espectacular");
        //JLabel etiqueta = new JLabel("Etiqueta molona");
        JLabel etiqueta = new JLabel("Etiqueta flipante", SwingConstants.CENTER);
        panel.add(etiqueta);
        
        etiqueta.setBounds(100, 100, 200, 30); // tras deshabilitar el layout del panel
        
        // cambiar el color de la fuente
        etiqueta.setForeground(Color.yellow);
        // deshabilitar el layout por defecto de la etiqueta para cambiar el color de fondo
        etiqueta.setOpaque(true);
        etiqueta.setBackground(Color.red);
        
        // MODIFICAR FUETE DE TAMAÑO DEL TEXTO
        etiqueta.setFont(new Font("arial", Font.ITALIC, 30));
        /*
        //JLabel etiquetaImagen = new JLabel(new ImageIcon("imagen.png"));
        
        JLabel etiquetaImagen = new JLabel(img);
        panel.add(etiquetaImagen);
        etiquetaImagen.setBounds(200, 200, 512, 512);
        */
        // PARA REDIMENSIONAR LA IMAGEN HAY QUE CAMBIAR DE CONSTRUCTOR
        // COMENTO LO ANTERIO
        
        JLabel nuevaImagen = new JLabel();
        ImageIcon img = new ImageIcon("imagen.png");
        nuevaImagen.setBounds(30, 100, 300, 300);
        nuevaImagen.setIcon(new ImageIcon(img.getImage().getScaledInstance(nuevaImagen.getWidth(), nuevaImagen.getHeight(), Image.SCALE_SMOOTH)));
    }
}