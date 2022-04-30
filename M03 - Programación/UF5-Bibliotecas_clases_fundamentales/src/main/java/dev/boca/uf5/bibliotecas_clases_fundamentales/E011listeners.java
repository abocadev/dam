package dev.boca.uf5.bibliotecas_clases_fundamentales;

import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class E011listeners extends JFrame {
    
    public JPanel panel;
    public JTextField caja;
    public E011listeners(String string) throws HeadlessException {
        super(string);
        setSize(500, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        crearComponentes();
    }

    public void crearComponentes(){
        crearPanel();
        crearLabel();
        crearCaja();
        crearBoton();
    }

    public void crearPanel(){
        panel = new JPanel();
        panel.setLayout(null);
        this.getContentPane().add(panel);
    }

    private void crearLabel(){
        JLabel texto = new JLabel();
        texto.setText("Como te llamas?");
        texto.setBounds(20, 20, 100, 20);
        panel.add(texto);
    }

    private void crearCaja(){
        caja = new JTextField();
        caja.setBounds(20, 50, 100, 30);
        panel.add(caja);
    }

    private void crearBoton(){
        JButton boton = new JButton("Contestar");
        boton.setBounds(20, 75, 100, 30);
        panel.add(boton);
        
        JLabel respuesta = new JLabel();
        respuesta.setBounds(20, 150, 200, 30);
        respuesta.setFont(new Font("Calibri", Font.BOLD, 20));
        panel.add(respuesta);

        //listener
        //el boton es el que tiene que escuchar la accion
        // necesitamos un objeto del tipo ActionListener, pero es una interfaz
        // crear el objeto
        
        ActionListener ejemploListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Que quiero que pase al clicar el boton
                respuesta.setText("Hola " + caja.getText());
            }            
        } ;
        
        boton.addActionListener(ejemploListener);
    }
    

}

