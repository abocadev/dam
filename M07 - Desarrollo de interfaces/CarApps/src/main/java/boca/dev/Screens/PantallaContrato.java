package boca.dev.Screens;

import java.awt.*;
import javax.swing.*;

public class PantallaContrato extends JFrame{

    // Datos cogidos
    static String nombre, modelo, marca, color, gasolina, precio;

    public static JPanel PanelPantallaContrato;
    static JLabel lNombre, lModelo, lMarca, lPrecio, lColor, lGasolina;

    public static void main(String[] args) {
        start();
    }
    
    public static void start(){
        PantallaContrato p = new PantallaContrato("Contrato " + modelo);
        p.setVisible(true);
    }
    
    public PantallaContrato(String s) throws HeadlessException{
        super(s);
        setSize(1000, 500);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(this.EXIT_ON_CLOSE);
        CrearComponentes();
    }

    public static void getData(String nombre, String modelo, String marca, String color, String gasolina, String precio){
        PantallaContrato.nombre = nombre;
        PantallaContrato.modelo = modelo;
        
    }

    public void CrearComponentes(){
        CrearPanel();
        CrearEtiquetas();
    }

    void CrearPanel(){
        PanelPantallaContrato = new JPanel();
        PanelPantallaContrato.setBackground(Color.gray);
        PanelPantallaContrato.setLayout(null);

        PanelPantallaContrato.setVisible(true);
        this.getContentPane().add(PanelPantallaContrato);
    }

    // Creamos las etiquetas de texto
    void CrearEtiquetas(){
        // Label Nombre
        lNombre = new JLabel("");
    }
    
    
}
