package dev.boca.uf5.bibliotecas_clases_fundamentales;

import java.awt.HeadlessException;

import javax.swing.JFrame;

public class E004ventana extends JFrame {

    public E004ventana(String string) throws HeadlessException{
        super(string);
        /*this.setSize(400, 400);
        this.setLocation(300, 300);*/
        // position y tamaño 
        this.setBounds(300, 300, 400, 400);
        // centrar en la ventana del navegador
        // si el componente al que es relativo es null, considera al padre la ventana del navegador.
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        
    }

    
    
}
