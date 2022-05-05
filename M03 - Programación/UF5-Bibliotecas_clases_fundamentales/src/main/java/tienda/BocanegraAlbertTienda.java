package tienda;

import java.awt.Color;
import java.awt.Font;
import java.awt.HeadlessException;
import java.util.ArrayList;
import javafx.scene.control.ComboBox;
import javax.swing.ComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class BocanegraAlbertTienda extends JFrame{
    
    private JPanel panel;
    private JLabel textArticulo, textPrecio, textImporteParcial;
    private JTextField insertArticulo, insertPrecio;
    private JTextArea contenido;
    private JButton botonSiguiente, botonEliminar, botonTotal;
    private JComboBox cajaArticulos;
    
    private static ArrayList<String> articulos = new ArrayList<String>();
    private static ArrayList<Double> precios = new ArrayList<Double>();
    private static double precioFinal = 0;
    
    public BocanegraAlbertTienda(String string) throws HeadlessException {
        super(string);
        setSize(750, 650);
        setLocationRelativeTo(null);
        //setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        crearComponentes();
    }
 
    private void crearComponentes(){
        crearPanel();
        crearEtiquetas();
        crearTextField();
        crearTextArea();
        crearBotones();
        crearComboBox();
    }
    
    private void crearPanel(){
        panel = new JPanel();
        panel.setBackground(Color.CYAN);
        panel.setLayout(null);
        this.getContentPane().add(panel);
    }
    
    private void crearEtiquetas(){
        textArticulo = new JLabel("Articulo:");
        textPrecio = new JLabel("Precio:");
        textImporteParcial = new JLabel(devolverPrecioTotal());
        
        textArticulo.setBounds(20, 10, 150, 50);
        textPrecio.setBounds(400, 10, 150, 50);
        textImporteParcial.setBounds(550, 150, 150, 50);
        
        panel.add(textArticulo);
        panel.add(textPrecio);
        panel.add(textImporteParcial);
        
        textArticulo.setFont(new Font("Tahoma", Font.BOLD, 24));
        textPrecio.setFont(new Font("Tahoma", Font.BOLD, 24));
        textImporteParcial.setFont(new Font("Tahoma", Font.BOLD, 14));
        
        textArticulo.setForeground(Color.WHITE);
        textPrecio.setForeground(Color.WHITE);
        textImporteParcial.setForeground(Color.WHITE);
    }
    
    private void crearTextField(){
        insertArticulo = new JTextField();
        insertPrecio = new JTextField();
        
        insertArticulo.setBounds(175, 20, 150 , 35);
        insertPrecio.setBounds(500, 20, 150 , 35);
        
        panel.add(insertArticulo);
        panel.add(insertPrecio);
    }
    
    private void crearTextArea(){
        contenido = new JTextArea("Articulos comprados:\n");
        contenido.setBounds(30, 100, 500, 400);
        contenido.setEditable(false);
        contenido.setFont(new Font("Tahoma", Font.ITALIC, 18));
        contenido.setForeground(new Color(165, 173, 167));
        panel.add(contenido);
    }
    
    private void crearBotones(){
        botonSiguiente = new JButton("Siguiente Articulo");
        botonEliminar = new JButton("Eliminar");
        botonTotal = new JButton("Total");
        
        botonSiguiente.setBackground(new Color(130, 197, 217));
        botonTotal.setBackground(new Color(130, 197, 217));
        
        botonEliminar.setBackground(new Color(214, 69, 69));
        
        botonSiguiente.setBounds(550, 100, 150, 50);
        botonEliminar.setBounds(550, 300, 150, 50);
        botonTotal.setBounds(550, 400, 150, 50);
        
        panel.add(botonSiguiente);
        panel.add(botonEliminar);
        panel.add(botonTotal);
    }
    
    private void crearComboBox(){
        String[] aux = new String[articulos.size()];
        aux = articulos.toArray(aux);
        cajaArticulos = new JComboBox(aux);
        cajaArticulos.setBounds(550, 200, 150, 50);
        panel.add(cajaArticulos);
    }
    
    private String devolverPrecioTotal(){
        return "Importe parcial: " + precioFinal + "€";
    }
}