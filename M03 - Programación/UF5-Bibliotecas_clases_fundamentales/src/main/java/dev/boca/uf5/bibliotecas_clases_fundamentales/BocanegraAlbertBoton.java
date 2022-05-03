package dev.boca.uf5.bibliotecas_clases_fundamentales;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.Color;
import java.awt.HeadlessException;

public class BocanegraAlbertBoton extends JFrame{

    private JPanel panel;
    private JTextField caja;
    private JButton botonNormal;
    private JButton botonEscapar;
    public static void main(String[] args) {
        BocanegraAlbertBoton programa = new BocanegraAlbertBoton("¿APROBARE?");
    }

    public BocanegraAlbertBoton(String title) throws HeadlessException{
        super(title);
        setSize(500, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setVisible(true);
        crearComponentes();
    }

    private void crearComponentes(){
        crearPanel();
    }

    private void crearPanel(){
        panel = new JPanel();
        panel.setBackground(Color.blue);
        this.getContentPane().add(panel);
    }


}
