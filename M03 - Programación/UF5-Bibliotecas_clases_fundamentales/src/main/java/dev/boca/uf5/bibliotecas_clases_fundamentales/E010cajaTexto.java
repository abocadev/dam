package dev.boca.uf5.bibliotecas_clases_fundamentales;

import java.awt.HeadlessException;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class E010cajaTexto extends JFrame{

    public JPanel panel;
            
    public E010cajaTexto(String string) throws HeadlessException {
        super(string);
        setSize(500, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        crearComponentes();        
    }
    
    private void crearComponentes(){
        crearPanel();
       // crearCajaTexto();
        //crearAreaTexto();
        crearLista();
    }
    
    private void crearPanel(){
        panel = new JPanel();
        // desactivar el layout que procede
        panel.setLayout(null);
        this.getContentPane().add(panel);
    }

    private void crearCajaTexto(){
        // caja para una sola linea
        JTextField texto = new JTextField();
        texto.setText("Hola mundo");
        texto.setBounds(20, 20, 100, 30);
        panel.add(texto);
        System.out.println("El texto de la caja:" + texto.getText());
    }

    private void crearAreaTexto(){
        JTextArea area = new JTextArea();
        area.setText("Area de texto");
        area.append("\nTexto añadido por el usuario");
        System.out.println("Texto de la area de texto: " + area.getText());
        area.setEditable(true);
        area.setBounds(20, 20, 300, 200);
        panel.add(area);
    }
    
    private void crearLista(){
        String[] frutas = {"manzana", "pera", "fresa", "uvas", "melon"};
        JComboBox lista = new JComboBox(frutas);
        lista.addItem("sandia");
        lista.setSelectedItem("pera");
        lista.setBounds(20, 20, 100, 30);
        panel.add(lista);
    }
}
