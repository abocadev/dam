package boca.dev.Screens;

import java.awt.*;
import javax.swing.*;

public class PantallaContrato extends JFrame{

    // Datos cogidos
    static String nombre, modelo, marca, color, gasolina;
    static float precio;
    
    // Label Color
    // Label Gasolina
    // Label Precio

    public static JPanel PanelPantallaContrato;
    static JLabel lNombre, lModelo, lMarca, lPrecio, lColor, lGasolina;
    static JTextField iNombre, iModelo, iMarca, iPrecio, iColor, iGasolina;
    
    public static void start(){
        PantallaContrato p = new PantallaContrato("Contrato " + modelo);
        p.setVisible(true);
    }
    
    public PantallaContrato(String s) throws HeadlessException{
        super(s);
        setSize(1000, 500);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        CrearComponentes();
    }

    public static void getData(String nombre, String modelo, String marca, String color, String gasolina, float precio){
        PantallaContrato.nombre = nombre;
        PantallaContrato.modelo = modelo;
        PantallaContrato.marca = marca;
        PantallaContrato.color = color;
        PantallaContrato.gasolina = gasolina;
        PantallaContrato.precio = precio;
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
    public void CrearEtiquetas() {
        // Label Nombre
        lNombre = new JLabel("Nombre:");
        lNombre.setBounds(20, 10, 150, 50);
        lNombre.setFont(new Font("Arial", Font.BOLD, 14));
        PanelPantallaContrato.add(lNombre);

        // Label Modelo
        lModelo = new JLabel("Modelo:");
        lModelo.setBounds(20, 50, 150, 50);
        lModelo.setFont(new Font("Arial", Font.BOLD, 14));
        PanelPantallaContrato.add(lModelo);
	
        // Label Marca
        lMarca = new JLabel("Marca:");
        lMarca.setBounds(20, 90, 150, 50);
        lMarca.setFont(new Font("Arial", Font.BOLD, 14));
        PanelPantallaContrato.add(lMarca);

        // Label Precio
        lPrecio = new JLabel("Precio:");
        lPrecio.setBounds(350, 10, 150, 50);
        lPrecio.setFont(new Font("Arial", Font.BOLD, 14));
        PanelPantallaContrato.add(lPrecio);

        // Label color
        lColor = new JLabel("Color:");
        lColor.setBounds(350, 50, 150, 50);
        lColor.setFont(new Font("Arial", Font.BOLD, 14));
        PanelPantallaContrato.add(lColor);

        // Label Gasolina
        lGasolina = new JLabel("Gasolina:");
        lGasolina.setBounds(350, 90, 150, 50);
        lGasolina.setFont(new Font("Tahoma", Font.BOLD, 14));
        PanelPantallaContrato.add(lGasolina);
    }
    
    // Creamos las entradasde texto
    public void crearInputs() {
    
        // Input Nombre
       iNombre = new JTextField();
       iNombre.setBounds(85, 25, 200, 20);
       iNombre.setFont(new Font("Arial", Font.BOLD, 14));
       iNombre.setBackground(new Color(245, 245, 245));
       iNombre.setBorder(null);
       PanelPantallaContrato.add(iNombre);
       
       // Input Modelo
       iModelo = new JTextField();
       iModelo.setBounds(85, 65, 200, 20);
       iModelo.setFont(new Font("Arial", Font.BOLD, 14));
       iModelo.setBackground(new Color(245, 245, 245));
       iModelo.setBorder(null);
       PanelPantallaContrato.add(iModelo);

       // Input Marca
       iMarca = new JTextField();
       iMarca.setBounds(85, 105, 200, 20);
       iMarca.setFont(new Font("Arial", Font.BOLD, 14));
       iMarca.setBackground(new Color(245, 245, 245));
       iMarca.setBorder(null);
       PanelPantallaContrato.add(iMarca);

       // Input Precio
       iPrecio = new JTextField();
       iPrecio.setBounds(425, 25, 200, 20);
       iPrecio.setFont(new Font("Arial", Font.BOLD, 14));
       iPrecio.setBackground(new Color(245, 245, 245));
       iPrecio.setBorder(null);
       PanelPantallaContrato.add(iPrecio);

       // Input Color
       iColor = new JTextField();
       iColor.setBounds(425, 65, 200, 20);
       iColor.setFont(new Font("Arial", Font.BOLD, 14));
       iColor.setBackground(new Color(245, 245, 245));
       iColor.setBorder(null);
       PanelPantallaContrato.add(iColor);

       // Input Gasolina
       iGasolina = new JTextField();
       iGasolina.setBounds(425, 105, 200, 20);
       iGasolina.setFont(new Font("Arial", Font.BOLD, 14));
       iGasolina.setBackground(new Color(245, 245, 245));
       iGasolina.setBorder(null);
       PanelPantallaContrato.add(iGasolina);
    }
    
}
