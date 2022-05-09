package tienda;

import java.awt.Color;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class BocanegraAlbertTienda extends JFrame {
    
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
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        crearComponentes();
    }

    private void crearComponentes() {
        crearPanel();
        crearEtiquetas();
        crearTextField();
        crearTextArea();
        crearBotones();
        crearComboBox();
        eventos();
    }

    private void crearPanel() {
        panel = new JPanel();
        panel.setBackground(new Color(50, 107, 199));
        panel.setLayout(null);
        panel.setVisible(true);
        this.getContentPane().add(panel);
    }

    private void crearEtiquetas() {
        textArticulo = new JLabel("Articulo:");
        textPrecio = new JLabel("Precio:");
        textImporteParcial = new JLabel("Importe parcial: " + precioFinal + "€");

        textArticulo.setBounds(20, 10, 150, 50);
        textPrecio.setBounds(400, 10, 150, 50);
        textImporteParcial.setBounds(535, 120, 200, 100);

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

    private void crearTextField() {
        insertArticulo = new JTextField();
        insertPrecio = new JTextField();

        insertArticulo.setBounds(175, 20, 150, 35);
        insertPrecio.setBounds(500, 20, 150, 35);

        panel.add(insertArticulo);
        panel.add(insertPrecio);
    }

    private void crearTextArea() {
        contenido = new JTextArea("Articulos comprados:\n");
        contenido.setBounds(30, 100, 500, 400);
        contenido.setEditable(false);
        contenido.setFont(new Font("Tahoma", Font.ITALIC, 18));
        contenido.setForeground(new Color(165, 173, 167));
        panel.add(contenido);
    }

    private void crearBotones() {
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
    
    private void crearComboBox() {
        String[] aux = new String[articulos.size()];
        aux = articulos.toArray(aux);
        cajaArticulos = new JComboBox(aux);
        cajaArticulos.setBounds(550, 200, 150, 50);
        panel.add(cajaArticulos);
    }
    
    private void siguienteArticulo(){
        try {
            Double precio = Double.parseDouble(insertPrecio.getText());
            precio = Math.round(precio * 100.0) / 100.0;
            String articulo = insertArticulo.getText();
            precioFinal += precio;
            articulos.add(articulo);
            precios.add(precio);
            
            System.out.println("Articulo: " + articulo);
            System.out.println("Precio: " + precio);
            System.out.println("--------------------------------------");
            
            mostContTextArea();
            cajaArticulos.addItem(insertArticulo.getText());
            getPrecioTotal();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No puedes insertar valores que sean distintos a Double");
        }
    }

    private void getPrecioTotal() {
        textImporteParcial.setText("Importe parcial: \n" + precioFinal + "€");
    }

    private void mostContTextArea() {
        String aux = "Articulos Comprados:\n";
        for (int i = 0; i < articulos.size(); i++) {
            aux += "    " + articulos.get(i) + "      " + precios.get(i) + "€\n";
        }
        contenido.setText(aux);
    }

    private void eliminarArticulo() {
        int opcion = cajaArticulos.getSelectedIndex();
        precioFinal = precioFinal -  precios.get(opcion);
        articulos.remove(opcion);
        precios.remove(opcion);
        cajaArticulos.removeItemAt(opcion);
        mostContTextArea();
        getPrecioTotal();
    }

    private void total() {
        ArrayList<String> auxArticulos = new ArrayList<String>();
        ArrayList<Integer> auxCantArticulos = new ArrayList<Integer>();
        ArrayList<Double> auxPrecioArticulos = new ArrayList<Double>();
        
        for (int i = 0; i < articulos.size(); i++) {
            boolean esta = false;
            for (int j = 0; j < auxArticulos.size(); j++) {
                if (articulos.get(i).equals(auxArticulos.get(j))) {
                    esta = true;
                }
            }
            if (!esta) {
                auxArticulos.add(articulos.get(i));
                auxPrecioArticulos.add(precios.get(i));
            }
        }

        for (int i = 0; i < auxArticulos.size(); i++) {
            int contador = 0;
            for (int j = 0; j < articulos.size(); j++) {
                if (auxArticulos.get(i).equals(articulos.get(j))) {
                    contador++;
                }
            }
            auxCantArticulos.add(contador);
        }

        String aux = "Nombre Articulo - Cantidad - Euro/Unidad - IVA-Unidad\n";
        double iva = 0;
        for (int i = 0; i < auxArticulos.size(); i++) {
            iva += auxPrecioArticulos.get(i)*0.21;
            aux += "\nArticulo: " + auxArticulos.get(i) + " (x " + auxCantArticulos.get(i) + ")     " + auxPrecioArticulos.get(i) + "€/u    " + (auxPrecioArticulos.get(i)*0.21) + "€/u";
            
        }
        iva = Math.round(iva * 100.0) / 100.0;
        aux += "\n Total: " + precioFinal + "\n     IVA Total: " + iva + "\n    Total sin IVA: " + (precioFinal - iva);
        contenido.setText(aux);
    }

    private void eventos() {
        MouseListener siguienteArticulo;
        siguienteArticulo = new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (!(insertArticulo.getText().equals("")) && !(insertPrecio.getText().equals(""))) {
                    siguienteArticulo();
                }
            }

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {
            }
        };
        botonSiguiente.addMouseListener(siguienteArticulo);

        MouseListener eliminar = new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                eliminarArticulo();
            }

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {
            }
        };
        botonEliminar.addMouseListener(eliminar);

        MouseListener Total = new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                total();
            }

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {
            }
        };
        botonTotal.addMouseListener(Total);
    }
}