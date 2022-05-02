package dev.boca.uf5.bibliotecas_clases_fundamentales;

import java.awt.HeadlessException;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class E013listener extends JFrame {

    private JPanel panel;
    private JTextField caja;
    private JTextArea area;
    private JButton boton;
    
    public E013listener(String title) throws HeadlessException{
        super(title);
        setSize(500, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        crearComponentes();
    }
    
    private void crearComponentes(){
        crearPanel();
        crearCajaTexto();
        crearAreaTexto();
        crearBoton();
    }
    
    private void crearPanel(){
        panel = new JPanel();
        panel.setLayout(null);
        this.getContentPane().add(panel);
    }
    
    private void crearCajaTexto(){
        caja = new JTextField();
        caja.setBounds(20, 20, 150, 30);
        panel.add(caja);
        
        eventoTeclado();
    }
    
    private void crearAreaTexto(){
        area = new JTextArea();
        area.setBounds(200, 20, 250, 300);
        panel.add(area);
    }
    
    private void crearBoton(){
        boton = new JButton();
        boton.setBounds(20, 250, 100, 30);
        panel.add(boton);
    }
    
    private void eventoTeclado(){
        // añadir el evento
        KeyListener objeto = new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                area.append("Has presionado alguna tecla unicode - KeyTiped\n");
            }

            @Override
            public void keyPressed(KeyEvent e) {
                area.append("Has presionado cualquier tecla - KeyPressed\n");
            }

            @Override
            public void keyReleased(KeyEvent e) {
                //area.append("Has liberado cualquier tecla - KeyReleased\n");
                if(e.getKeyChar() == 'p'){
                    area.append("Letra p \n");
                }else{
                    area.append("espacio p \n");
                }
            }
        };
        caja.addKeyListener(objeto);
    }
}
