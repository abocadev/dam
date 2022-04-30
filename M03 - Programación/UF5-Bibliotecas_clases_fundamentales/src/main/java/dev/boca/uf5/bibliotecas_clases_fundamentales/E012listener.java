package dev.boca.uf5.bibliotecas_clases_fundamentales;

import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class E012listener extends JFrame {
    public JPanel panel;
    public JTextField caja;
    public JTextArea area;
    private JButton boton;
    public E012listener(String title) throws HeadlessException {
        super(title);
        setSize(500, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        crearComponentes();
    }

    public void crearComponentes(){
        crearPanel();
        crearAreaTexto();
        crearBoton();
    }
    
    private void crearAreaTexto(){
        area = new JTextArea();
        panel.add(area);
        area.setBounds(20, 10, 300, 100);
    }
    public void crearPanel(){
        panel = new JPanel();
        panel.setLayout(null);
        this.getContentPane().add(panel);
    }

    private void crearBoton(){
        boton = new JButton("Contestar");
        boton.setBounds(20, 200, 100, 30);
        panel.add(boton);
        
        JLabel respuesta = new JLabel();
        respuesta.setBounds(20, 200, 200, 30);
        respuesta.setFont(new Font("Calibri", Font.BOLD, 20));
        panel.add(respuesta);
        eventListener(respuesta);
        eventoRaton();
        
    }
    
    private void eventListener(JLabel respuesta){
        //listener
        //el boton es el que tiene que escuchar la accion
        // necesitamos un objeto del tipo ActionListener, pero es una interfaz
        // crear el objeto
        
        ActionListener ejemploListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Que quiero que pase al clicar el boton
                respuesta.setText("Hola " + area.getText());
            }            
        } ;
        
        boton.addActionListener(ejemploListener);
    }
    
    private void eventoRaton(){
        MouseListener listenerRaton = new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                area.append("Has hecho un nouseClicked\n");
            }

            @Override
            public void mousePressed(MouseEvent e) {
                area.append("Has hecho un mousePressed\n");
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                area.append("Has hecho un nouseReleased\n");
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                area.append("Has hecho un nouseEntered\n");
            }

            @Override
            public void mouseExited(MouseEvent e) {
                area.append("Has hecho un mouseExited\n");
            }
        };
        boton.addMouseListener(listenerRaton);
    }
}
