package boca.dev.Screens;

import java.awt.*;
import javax.swing.*;

public class PantallaContract extends JFrame{

    // Datos cogidos
    static String nombre, modelo, marca, color, gasolina;
    static float precio;

    public static JPanel PanelPantallaContrato;
    static JLabel lNombre, lModelo, lMarca, lPrecio, lColor, lGasolina, lFirma, lCoche;
    static JTextField iNombre, iModelo, iMarca, iPrecio, iColor, iGasolina;
    
    public static void start(){
        PantallaContract p = new PantallaContract("Caracteristicas: " + marca + " "+ modelo);
        p.setVisible(true);
    }
    
    public PantallaContract (String s) throws HeadlessException{
        super(s);
        setSize(700, 500);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        CrearComponentes();
    }

    
    public void CrearComponentes(){
        CrearPanel();
        CrearEtiquetas();
        CrearInputs();
    }

    public void CrearPanel(){
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
        
        // Imagen de Firma
        lFirma = new JLabel();
        lFirma.setIcon(new ImageIcon("firma.png"));
        lFirma.setBounds(425, 250, 200, 90);
        PanelPantallaContrato.add(lFirma);
        
        // Imagen del coche exterior
        lCoche = new JLabel();
        String modelo = PantallaInicio.TablaCoches.getVali
                
        
        lCoche.setBounds(20, 250, 200, 90);
        PanelPantallaContrato.add(lCoche);
    }
    
    // Creamos las entradasde texto
    public void CrearInputs() {
        // Input Nombre
       iNombre = new JTextField(nombre);
       iNombre.setBounds(85, 25, 200, 20);
       iNombre.setFont(new Font("Arial", Font.BOLD, 14));
       iNombre.setBackground(new Color(245, 245, 245));
       iNombre.setBorder(null);
       iNombre.setEditable(false);
       PanelPantallaContrato.add(iNombre);
       
       // Input Modelo
       iModelo = new JTextField(modelo);
       iModelo.setBounds(85, 65, 200, 20);
       iModelo.setFont(new Font("Arial", Font.BOLD, 14));
       iModelo.setBackground(new Color(245, 245, 245));
       iModelo.setBorder(null);
       iModelo.setEditable(false);
       PanelPantallaContrato.add(iModelo);

       // Input Marca
       iMarca = new JTextField(marca);
       iMarca.setBounds(85, 105, 200, 20);
       iMarca.setFont(new Font("Arial", Font.BOLD, 14));
       iMarca.setBackground(new Color(245, 245, 245));
       iMarca.setBorder(null);
       iMarca.setEditable(false);
       PanelPantallaContrato.add(iMarca);

       // Input Precio
       iPrecio = new JTextField("" + precio + "$");
       iPrecio.setBounds(425, 25, 200, 20);
       iPrecio.setFont(new Font("Arial", Font.BOLD, 14));
       iPrecio.setBackground(new Color(245, 245, 245));
       iPrecio.setBorder(null);
       iPrecio.setEditable(false);
       PanelPantallaContrato.add(iPrecio);

       // Input Color
       iColor = new JTextField(color);
       iColor.setBounds(425, 65, 200, 20);
       iColor.setFont(new Font("Arial", Font.BOLD, 14));
       iColor.setBackground(new Color(245, 245, 245));
       iColor.setBorder(null);
       iColor.setEditable(false);
       PanelPantallaContrato.add(iColor);

       // Input Gasolina
       iGasolina = new JTextField(gasolina);
       iGasolina.setBounds(425, 105, 200, 20);
       iGasolina.setFont(new Font("Arial", Font.BOLD, 14));
       iGasolina.setBackground(new Color(245, 245, 245));
       iGasolina.setBorder(null);
       iGasolina.setEditable(false);
       PanelPantallaContrato.add(iGasolina);
    }

    public static void getData(String nombre, String modelo, String marca, String color, String gasolina, float precio){
        PantallaContract.nombre = nombre;
        PantallaContract.modelo = modelo;
        PantallaContract.marca = marca;
        PantallaContract.color = color;
        PantallaContract.gasolina = gasolina;
        PantallaContract.precio = precio;
    }    
}