package dev.boca.uf5.bibliotecas_clases_fundamentales;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Font;
import java.awt.HeadlessException;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class BocanegraAlbertBoton extends JFrame{

    private JPanel panel;
    private JLabel texto;
    private JButton botonNormal;
    private JButton botonEscapar;
    
    public static void main(String[] args) {
        BocanegraAlbertBoton programa = new BocanegraAlbertBoton("¿APROBARE?");
        programa.setVisible(true);
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
        crearTexto();
        botonNormal();
    }

    private void crearPanel(){
        panel = new JPanel();
        Color colorFondo = new Color(hex("578EE6")); // Esto sirve para poner un color en hexadecimal
        panel.setBackground(colorFondo);
        panel.setLayout(null);
        this.getContentPane().add(panel);
    }
    
    private void crearTexto(){
        texto = new JLabel();
        texto.setText("¿Aprobaré el M03?");
        texto.setForeground(Color.WHITE);
        panel.add(texto);
        texto.setBounds(125, 10, 250, 30);
        texto.setFont(new Font("Tahoma", Font.BOLD, 24));
    }
    
    private void botonNormal(){
        botonNormal = new JButton();
        botonNormal.setText("¡JAMÁS!");
        botonNormal.setBounds(100, 75, 50, 25);
        panel.add(botonNormal);
    }
    // Este metodo sirve para poner pasar de String a hexadecimal
    private int hex(String color_hex){
        return Integer.parseInt(color_hex, 16);
    }

}
