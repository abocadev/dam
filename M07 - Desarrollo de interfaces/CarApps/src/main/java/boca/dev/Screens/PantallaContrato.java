package boca.dev.Screens;

import java.awt.*;
import javax.swing.*;

public class PantallaContrato extends JFrame{

    // Datos cogidos
    static String nombre, modelo, marca, color, gasolina;
    static float precio;

    public static JPanel PanelPantallaContrato;
    static JLabel lNombre, lModelo, lMarca, lPrecio, lColor, lGasolina;

    public static void main(String[] args) {
        start();
    }
    public static void start(){
        //
        // getData();
        PantallaContrato p = new PantallaContrato("Contrato " + modelo);
        p.setVisible(true);
    }
    
    public PantallaContrato(String s) throws HeadlessException{
        super(s);
        setSize(1000, 500);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        CrearComponentes();
    }

    static void getData(){
        try {
            int puntero = PantallaPrincipal.TablaCoches.getSelectedRow();
            nombre = (String) PantallaPrincipal.TablaCoches.getValueAt(puntero, 0);
            modelo = (String) PantallaPrincipal.TablaCoches.getValueAt(puntero, 1);
            marca = (String) PantallaPrincipal.TablaCoches.getValueAt(puntero, 2);
            precio = Float.parseFloat((String) PantallaPrincipal.TablaCoches.getValueAt(puntero, 3));
            color = (String) PantallaPrincipal.TablaCoches.getValueAt(puntero, 4);
            gasolina = (String) PantallaPrincipal.TablaCoches.getValueAt(puntero, 5);
        }catch (Exception e){
            e.printStackTrace();
        }
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
        lNombre = new JLabel("       ");
    }
}
