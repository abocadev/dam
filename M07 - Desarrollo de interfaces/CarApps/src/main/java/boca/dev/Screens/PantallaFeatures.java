package boca.dev.Screens;

import boca.dev.Objects.Coches;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.HeadlessException;
import javax.swing.*;

public class PantallaFeatures extends JFrame {
    
    // Datos codigos
    static String Marca, Modelo, color, TipoMotor, TipoMarchas, DescripcionVehiculo, RutaImagenCocheFuera, RutaImagenCocheDentro;
    static int VelocidadCoche, YearCoche, NumeroPuertas;
    
    // Panel
    JPanel PanelPantallaFeatures;
    JLabel lMarca, lModelo, lColor, lTipoMotor, lTipoMarchas;
    JTextField iMarca, iModelo, iColor, iTipoMotor, iTipoMarchas;
    JTextArea tDescripcionVehiculo;
    
    JLabel imgCocheDentro, imgCocheFuera;
    
    public void start(){
        PantallaFeatures p = new PantallaFeatures("Caracteristicas: " + Marca + " " + Modelo);
        p.setVisible(true);
    }
    
    public PantallaFeatures(){}
    
    public PantallaFeatures(String s) throws HeadlessException{
        super(s);
        setSize(700, 500);
        setResizable(true);
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
        PanelPantallaFeatures = new JPanel();
        PanelPantallaFeatures.setBackground(Color.GRAY);
        PanelPantallaFeatures.setLayout(null);
        PanelPantallaFeatures.setVisible(true);
        this.getContentPane().add(PanelPantallaFeatures);
    }
    
    public void CrearEtiquetas(){
        // Label Marca
        lMarca = new JLabel("Marca:");
        lMarca.setBounds(20, 10, 150, 50);
        lMarca.setFont(new Font("Arial", Font.BOLD, 14));
        PanelPantallaFeatures.add(lMarca);
        
        // Label Modelo
        lModelo = new JLabel("Modelo:");
        lModelo.setBounds(20, 50, 150, 50);
        lModelo.setFont(new Font("Arial", Font.BOLD, 14));
        PanelPantallaFeatures.add(lModelo);
        
        // Label Color
        lColor = new JLabel("Color:");
        lColor.setBounds(200, 90, 150, 50);
        lColor.setFont(new Font("Arial", Font.BOLD, 14));
        PanelPantallaFeatures.add(lColor);
        
        // Label TipoMotor
        lTipoMotor = new JLabel("Tipo Motor:");
        lTipoMotor.setBounds(350, 10, 150, 50);
        lTipoMotor.setFont(new Font("Arial", Font.BOLD, 14));
        PanelPantallaFeatures.add(lTipoMotor);
        
        // Label TipoMarchas
        lTipoMarchas = new JLabel("Tipo Marchas:");
        lTipoMarchas.setBounds(350, 50, 150, 50);
        lTipoMarchas.setFont(new Font("Arial", Font.BOLD, 14));
        PanelPantallaFeatures.add(lTipoMarchas);        
    }
    
    public void CrearInputs(){
        // Input Marca
        iMarca = new JTextField(Marca);
        iMarca.setBounds(85, 25, 200, 20);
        iMarca.setFont(new Font("Arial", Font.BOLD, 14));
        iMarca.setBackground(new Color(245, 245, 245)); 
        iMarca.setBorder(null);
        iMarca.setEditable(false);
        PanelPantallaFeatures.add(iMarca);
        
        // Input Modelo
        iModelo = new JTextField(Modelo);
        iModelo.setBounds(85, 65, 200, 20);
        iModelo.setFont(new Font("Arial", Font.BOLD, 14));
        iModelo.setBackground(new Color(245, 245, 245));
        iModelo.setBorder(null);
        iModelo.setEditable(false);
        PanelPantallaFeatures.add(iModelo);
        
        // Input Color
        iColor = new JTextField(color);
        iColor.setBounds(85, 105, 200, 20);
        iColor.setFont(new Font("Arial", Font.BOLD, 14));
        iColor.setBackground(new Color(245, 245, 245));
        iColor.setBorder(null);
        iColor.setEditable(false);
        PanelPantallaFeatures.add(iColor);
        
        // Input TipoMotor
        iTipoMotor = new JTextField(TipoMotor);
        iTipoMotor.setBounds(425, 25, 200, 20);
        iTipoMotor.setFont(new Font("Arial", Font.BOLD, 14));
        iTipoMotor.setBackground(new Color(245, 245, 245));
        iTipoMotor.setBorder(null);
        iTipoMotor.setEditable(false);
        PanelPantallaFeatures.add(iTipoMotor);
        
        // Input TipoMarchas
        iTipoMarchas = new JTextField(TipoMarchas);
        iTipoMarchas.setBounds(425, 65, 200, 20);
        iTipoMarchas.setFont(new Font("Arial", Font.BOLD, 14));
        iTipoMarchas.setBackground(new Color(245, 245, 245));
        iTipoMarchas.setBorder(null);
        iTipoMarchas.setEditable(false);
        PanelPantallaFeatures.add(iTipoMarchas);

    }
    // Metodo de obtener los datos necesarios
    public void getData(String modelo){
        int contador = 0;
        
        while (contador < Coches.coches.size()){
            if(modelo.equalsIgnoreCase(Coches.coches.get(contador).getModeloCoche())) break;
            else contador++;
        }
        Marca = Coches.coches.get(contador).getMarcaCoche();
        Modelo = Coches.coches.get(contador).getModeloCoche();
        color = Coches.coches.get(contador).getColorCoche();
        TipoMotor = Coches.coches.get(contador).getTipoMotor();
        TipoMarchas = Coches.coches.get(contador).getTipoMarchas();
        DescripcionVehiculo = Coches.coches.get(contador).getDescripcionVehiculo();
        RutaImagenCocheFuera = Coches.coches.get(contador).getRutaImagenCocheFuera();
        RutaImagenCocheDentro = Coches.coches.get(contador).getRutaImagenCocheDentro();
        VelocidadCoche = Coches.coches.get(contador).getVelocidadMaxima();
        YearCoche = Coches.coches.get(contador).getYearCoche();
        NumeroPuertas = Coches.coches.get(contador).getNumeroPuertas();
    }
}