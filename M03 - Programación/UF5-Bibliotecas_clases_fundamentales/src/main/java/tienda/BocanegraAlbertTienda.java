package tienda;

import java.awt.Color;
import java.awt.HeadlessException;
import java.util.ArrayList;
import javafx.scene.control.ComboBox;
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
    private ComboBox cajaArticulos;
    private ArrayList<String> articulos = new ArrayList<String>();
    private ArrayList<Integer> precios = new ArrayList<Integer>();
    
    public BocanegraAlbertTienda(String string) throws HeadlessException {
        super(string);
        setSize(500, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        crearComponentes();
    }
 
    private void crearComponentes(){
        crearPanel();
        crearEtiquetas();
    }
    
    private void crearPanel(){
        panel = new JPanel();
        panel.setBackground(Color.CYAN);
        panel.setLayout(null);
        this.getContentPane().add(panel);
    }
    
    private void crearEtiquetas(){
        textArticulo = new JLabel("Articulo");
        textPrecio = new JLabel("Precio");
        textImporteParcial = new JLabel("Importe parcial");
        textArticulo.setBounds(0, 0, 100, 50);
        textPrecio.setBounds(0, 50, 100, 50);
        textImporteParcial.setBounds(0, 150, 100, 50);
        panel.add(textArticulo);
        panel.add(textPrecio);
        panel.add(textImporteParcial);
    }
    
}