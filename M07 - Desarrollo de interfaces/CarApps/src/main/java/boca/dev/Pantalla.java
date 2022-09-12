package boca.dev;

import javax.swing.*;
import java.awt.*;

public class Pantalla extends JFrame {
    private JPanel panel;
    private JLabel lNombre, lModelo, lMarca, lPrecio, lColor, lGasolina, lIcon;
    private JTextField iNombre, iModelo, iMarcca, iPrecio, iColor, iGasolina;

    private JButton bInput;

    public Pantalla(String s) throws HeadlessException{
        super(s);
        setSize(750, 750);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        crearComponentes();
    }

    public void crearComponentes(){
        crearPanel();
    }

    public void crearPanel(){
        panel = new JPanel();
        panel.setBackground(Color.gray);
        panel.setLayout(null);
        
        panel.setVisible(true);
        this.getContentPane().add(panel);
    }

    public void crearEtiquetas(){
        lNombre = new JLabel("Nombre:");
        lModelo = new JLabel("Modelo:");
        lMarca = new JLabel("Marca:");
        lPrecio = new JLabel("Precio:");
        lColor = new JLabel("Color:");
        lGasolina = new JLabel("Gasolina:");


    }
}
