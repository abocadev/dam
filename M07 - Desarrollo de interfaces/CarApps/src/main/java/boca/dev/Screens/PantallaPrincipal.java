package boca.dev.Screens;

import boca.dev.Events.EventosPantallaPrincipal;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class PantallaPrincipal extends JFrame{
    
    public static void start() {
        PantallaPrincipal h = new PantallaPrincipal("Concesionario de coches");
        h.setVisible(true);
    }
    
    JPanel PanelPantallaPrincipal;
    JLabel lNombre, lModelo, lMarca, lPrecio, lColor, lGasolina, lIcon;
    JTextField iNombre, iModelo, iMarca, iPrecio, iColor;
    JComboBox<String> jCBGasolina;

    JButton bAdd, bRead, bContract, bFeatures;
    JTable TablaNuevosCoches, TablaCoches;
    
    public PantallaPrincipal(){}
    
    public PantallaPrincipal(String s) throws HeadlessException{
        super(s);
        setSize(1000, 500);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        crearComponentes();
    }

    public void crearComponentes(){
        crearPanel();
        crearEtiquetas();
        crearInputs();
        crearButtons();
        crearTableNuevosCoches();
        crearTableCoches();     
        AddButton();
    } 
    
    // Creamos el panel
    public void crearPanel(){
        PanelPantallaPrincipal = new JPanel();
        PanelPantallaPrincipal.setBackground(Color.gray);
        PanelPantallaPrincipal.setLayout(null);

        PanelPantallaPrincipal.setVisible(true);
        this.getContentPane().add(PanelPantallaPrincipal);
    }
    
    // Creamos las etiquetas de texto
    public void crearEtiquetas() {
        // Label Nombre
        lNombre = new JLabel("Nombre:");
        lNombre.setBounds(20, 10, 150, 50);
        lNombre.setFont(new Font("Arial", Font.BOLD, 14));
        PanelPantallaPrincipal.add(lNombre);

        // Label Modelo
        lModelo = new JLabel("Modelo:");
        lModelo.setBounds(20, 50, 150, 50);
        lModelo.setFont(new Font("Arial", Font.BOLD, 14));
        PanelPantallaPrincipal.add(lModelo);
	
        // Label Marca
        lMarca = new JLabel("Marca:");
        lMarca.setBounds(20, 90, 150, 50);
        lMarca.setFont(new Font("Arial", Font.BOLD, 14));
        PanelPantallaPrincipal.add(lMarca);

        // Label Precio
        lPrecio = new JLabel("Precio:");
        lPrecio.setBounds(350, 10, 150, 50);
        lPrecio.setFont(new Font("Arial", Font.BOLD, 14));
        PanelPantallaPrincipal.add(lPrecio);

        // Label color
        lColor = new JLabel("Color:");
        lColor.setBounds(350, 50, 150, 50);
        lColor.setFont(new Font("Arial", Font.BOLD, 14));
        PanelPantallaPrincipal.add(lColor);

        // Label Gasolina
        lGasolina = new JLabel("Gasolina:");
        lGasolina.setBounds(350, 90, 150, 50);
        lGasolina.setFont(new Font("Tahoma", Font.BOLD, 14));
        PanelPantallaPrincipal.add(lGasolina);

        // Icono boca
        lIcon = new JLabel();
        lIcon.setIcon(new ImageIcon("Logo.png"));
        lIcon.setBounds(800, 10, 150, 150);
        PanelPantallaPrincipal.add(lIcon);
    }
    
    // Creamos las entradas de texto
    public void crearInputs() {
       // Input Nombre
       iNombre = new JTextField();
       iNombre.setBounds(85, 25, 200, 20);
       iNombre.setFont(new Font("Arial", Font.BOLD, 14));
       iNombre.setBackground(new Color(245, 245, 245));
       iNombre.setBorder(null);
       PanelPantallaPrincipal.add(iNombre);
       
       // Input Modelo
       iModelo = new JTextField();
       iModelo.setBounds(85, 65, 200, 20);
       iModelo.setFont(new Font("Arial", Font.BOLD, 14));
       iModelo.setBackground(new Color(245, 245, 245));
       iModelo.setBorder(null);
       PanelPantallaPrincipal.add(iModelo);

       // Input Marca
       iMarca = new JTextField();
       iMarca.setBounds(85, 105, 200, 20);
       iMarca.setFont(new Font("Arial", Font.BOLD, 14));
       iMarca.setBackground(new Color(245, 245, 245));
       iMarca.setBorder(null);
       PanelPantallaPrincipal.add(iMarca);

       // Input Precio
       iPrecio = new JTextField();
       iPrecio.setBounds(425, 25, 200, 20);
       iPrecio.setFont(new Font("Arial", Font.BOLD, 14));
       iPrecio.setBackground(new Color(245, 245, 245));
       iPrecio.setBorder(null);
       PanelPantallaPrincipal.add(iPrecio);

       // Input Color
       iColor = new JTextField();
       iColor.setBounds(425, 65, 200, 20);
       iColor.setFont(new Font("Arial", Font.BOLD, 14));
       iColor.setBackground(new Color(245, 245, 245));
       iColor.setBorder(null);
       PanelPantallaPrincipal.add(iColor);

       // ComboBox Gasolina
       String [] TipoGasolina = { "-- TIPO GASOLINA --", "Diesel", "Gasolina", "Hibrido", "Hibrido enchufable", "Electrico"};
       jCBGasolina = new JComboBox<String>(TipoGasolina);
       jCBGasolina.setBounds(425, 105, 200, 20);
       jCBGasolina.setFont(new Font("Arial", Font.PLAIN, 14));
       jCBGasolina.setBackground(new Color(245, 245, 245));
       jCBGasolina.setBorder(null);
       PanelPantallaPrincipal.add(jCBGasolina);
    }

    // Creamos los botones
    public void crearButtons(){
        
        // Button Add
        bAdd = new JButton("Añadir");
        bAdd.setBounds(675, 23, 100, 40);
        bAdd.setFont(new Font("Arial", Font.BOLD, 14));
        bAdd.setForeground(Color.WHITE);
        bAdd.setBackground(new Color(46, 46, 46));
        PanelPantallaPrincipal.add(bAdd);

        // Button Read
        bRead = new JButton("Leer");
        bRead.setBounds(675, 90, 100, 40);
        bRead.setFont(new Font("Arial", Font.BOLD, 14));
        bRead.setForeground(Color.WHITE);
        bRead.setBackground(new Color(46, 46, 46));
        PanelPantallaPrincipal.add(bRead);
        
        // Button Contrato
        bContract = new JButton("Contrato");
        bContract.setBounds(675, 380, 100, 40);
        bContract.setFont(new Font("Arial", Font.BOLD, 14));
        bContract.setForeground(Color.WHITE);
        bContract.setBackground(new Color(46, 46, 46));
        PanelPantallaPrincipal.add(bContract);
        
        // Button Caracteristicas
        bFeatures = new JButton("Caracteristicas");
        bFeatures.setBounds(800, 380, 150, 40);
        bFeatures.setFont(new Font("Arial", Font.BOLD, 14));
        bFeatures.setForeground(Color.WHITE);
        bFeatures.setBackground(new Color(46, 46, 46));
        PanelPantallaPrincipal.add(bFeatures);
    }
     
    public void crearTableNuevosCoches(){
        Object [] columnas = {"Nombre", "Modelo", "Marca", "Precio", "Color", "Gasolina"};
        TablaNuevosCoches = new JTable(new DefaultTableModel(columnas, 0));
        JScrollPane jScrollPanel = new JScrollPane(TablaNuevosCoches);
        jScrollPanel.setBounds(20, 175, 600, 80);
        PanelPantallaPrincipal.add(jScrollPanel);
    }
    
    public void crearTableCoches(){
        Object [] columnas = {"Nombre", "Modelo", "Marca", "Precio", "Color", "Gasolina"};
        TablaCoches = new JTable (new DefaultTableModel(columnas, 0));
        JScrollPane jScrollPanel = new JScrollPane(TablaCoches);
        jScrollPanel.setBounds(20, 300, 600, 120);
        PanelPantallaPrincipal.add(jScrollPanel);
    }
    
    public void eventos(){
        
//        bAdd.addMouseListener(epp.AddButton());
    }
    
    // Apartado de controlar el evento de los Botones    
    public void AddButton(){ // Eventos para el boton de Leer
        MouseListener l;
        l = new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(jCBGasolina.getSelectedIndex() == 0){
                    JOptionPane.showMessageDialog(null, "No has seleccionado tipo de gasolina");
                }else{
                    String gas = "";
                    switch(jCBGasolina.getSelectedIndex()){
                        case 1 -> gas = "Diesel";
                            
                        case 2 -> gas = "Gasolina";
                            
                        case 3 -> gas = "Hibrido";
                            
                        case 4 -> gas = "Hibrido enchufable";
                            
                        case 5 -> gas = "Electrico";
                                        
                    }
                    DefaultTableModel model = (DefaultTableModel)TablaNuevosCoches.getModel();
                    model.addRow(new Object[] {
                        iNombre.getText(),
                        iModelo.getText(),
                        iMarca.getText(),
                        Float.parseFloat(iPrecio.getText()),
                        iColor.getText(),                        
                        gas
                    });
                }
            }

            @Override public void mousePressed(MouseEvent e) {}

            @Override public void mouseReleased(MouseEvent e) {}

            @Override public void mouseEntered(MouseEvent e) {}

            @Override public void mouseExited(MouseEvent e) {}
        };
        bAdd.addMouseListener(l);
    }
    
}

