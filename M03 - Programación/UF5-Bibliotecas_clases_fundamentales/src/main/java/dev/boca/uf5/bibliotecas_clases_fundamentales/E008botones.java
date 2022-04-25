package dev.boca.uf5.bibliotecas_clases_fundamentales;

import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.HeadlessException;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class E008botones extends JFrame{
    
    // trato el panel como un atributo para acceder a el desde otros metodos
    public JPanel panel;
    // constructor
    public E008botones(String string) throws HeadlessException {
        super(string);
        setVisible(true);
        setSize(500, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        crearComponentes();
    }
    
    private void crearComponentes(){
        crearPanel();
        crearBoton();
        crearOpciones();
    }
    
    private void crearPanel(){
        //JPanel panel = new JPanel();
        panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(new Color(189, 223, 179));
        this.getContentPane().add(panel);
    }
    
    private void crearBoton(){
        // instancia de boton de texto
        JButton boton = new JButton("Boton molon");
        //boton.setText("Boton Molon");
        boton.setBounds(20, 50, 150, 50);
        
        boton.setEnabled(true); // false no se puede clicar
        boton.setMnemonic('q');
        boton.setFont(new Font("calibri", Font.PLAIN, 20));
       
        panel.add(boton);
        
        JButton aboton = new JButton("Boton molon");
        //boton.setText("Boton Molon");
        aboton.setBounds(20, 50, 150, 50);
        
        aboton.setEnabled(true); // false no se puede clicar
        aboton.setMnemonic('q');
        aboton.setFont(new Font("calibri", Font.PLAIN, 20));
       
        panel.add(boton);
    }
    
    private void crearOpciones(){
        JRadioButton opcion1 = new JRadioButton("uno", true);
        panel.add(opcion1);
        opcion1.setBounds(20, 100, 100, 50);
        
        JRadioButton opcion2 = new JRadioButton("dos", false);
        panel.add(opcion2);
        opcion2.setBounds(20, 200, 100, 50);
        
        JRadioButton opcion3 = new JRadioButton("tres", false);
        panel.add(opcion3);
        opcion3.setBounds(20, 300, 100, 50);
        
        ButtonGroup opciones = new ButtonGroup();
        
        // añadir los botones existentes a este grupo
        opciones.add(opcion1);
        opciones.add(opcion2);
        opciones.add(opcion3);
    }
}
