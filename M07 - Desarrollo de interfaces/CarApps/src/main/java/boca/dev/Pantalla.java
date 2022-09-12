package boca.dev;

import javax.swing.*;
import java.awt.*;

public class Pantalla extends JFrame {
    private JPanel panel;
    private JLabel lNombre, lModelo, lMarca, lPrecio, lColor, lGasolina, lIcon;
    private JTextField iNombre, iModelo, iMarca, iPrecio, iColor, iGasolina;

    private JButton bInput;

    public Pantalla(String s) throws HeadlessException{
        super(s);
        setSize(1000, 750);
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
    }

    public void crearPanel(){
        panel = new JPanel();
        panel.setBackground(Color.gray);
        panel.setLayout(null);
        
        panel.setVisible(true);
        this.getContentPane().add(panel);
    }

    public void crearEtiquetas() {
        lNombre = new JLabel("Nombre:");
        lNombre.setBounds(20, 10, 150, 50);
        lNombre.setFont(new Font("Arial", Font.BOLD, 14));
        panel.add(lNombre);

        lModelo = new JLabel("Modelo:");
        lModelo.setBounds(20, 50, 150, 50);
        lModelo.setFont(new Font("Arial", Font.BOLD, 14));
        panel.add(lModelo);

        lMarca = new JLabel("Marca:");
        lMarca.setBounds(20, 90, 150, 50);
        lMarca.setFont(new Font("Arial", Font.BOLD, 14));
        panel.add(lMarca);

        lPrecio = new JLabel("Precio:");
        lPrecio.setBounds(350, 10, 150, 50);
        lPrecio.setFont(new Font("Arial", Font.BOLD, 14));
        panel.add(lPrecio);

        lColor = new JLabel("Color:");
        lColor.setBounds(350, 50, 150, 50);
        lColor.setFont(new Font("Arial", Font.BOLD, 14));
        panel.add(lColor);

        lGasolina = new JLabel("Gasolina:");
        lGasolina.setBounds(350, 90, 150, 50);
        lGasolina.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(lGasolina);

        // Icono boca
        lIcon = new JLabel();
        lIcon.setIcon(new ImageIcon("Logo.png"));
        lIcon.setBounds(800, 10, 150, 150);
        panel.add(lIcon);
    }

    public void crearInputs() {
       iNombre = new JTextField();
       iNombre.setBounds(85, 25, 200, 20);
       iNombre.setFont(new Font("Arial", Font.BOLD, 14));
       iNombre.setBackground(new Color(245, 245, 245));
       iNombre.setBorder(null);
       panel.add(iNombre);

       iModelo = new JTextField();
       iModelo.setBounds(85, 65, 200, 20);
       iModelo.setFont(new Font("Arial", Font.BOLD, 14));
       iModelo.setBackground(new Color(245, 245, 245));
       iModelo.setBorder(null);
       panel.add(iModelo);

       iMarca = new JTextField();
       iMarca.setBounds(85, 105, 200, 20);
       iMarca.setFont(new Font("Arial", Font.BOLD, 14));
       iMarca.setBackground(new Color(245, 245, 245));
       iMarca.setBorder(null);
       panel.add(iMarca);

       iPrecio = new JTextField();
       iPrecio.setBounds(425, 25, 200, 20);
       iPrecio.setFont(new Font("Arial", Font.BOLD, 14));
       iPrecio.setBackground(new Color(245, 245, 245));
       iPrecio.setBorder(null);
       panel.add(iPrecio);

       iColor = new JTextField();
       iColor.setBounds(425, 65, 200, 20);
       iColor.setFont(new Font("Arial", Font.BOLD, 14));
       iColor.setBackground(new Color(245, 245, 245));
       iColor.setBorder(null);
       panel.add(iColor);

       iGasolina = new JTextField();
       iGasolina.setBounds(425, 105, 200, 20);
       iGasolina.setFont(new Font("Arial", Font.BOLD, 14));
       iGasolina.setBackground(new Color(245, 245, 245));
       iGasolina.setBorder(null);
       panel.add(iGasolina);
    }

     public void crearButtons(){
        bInput = new JButton("Añadir");
        bInput.setBounds(750, 100, 100, 50);
        bInput.setFont(new Font("Arial", Font.BOLD, 14));
        panel.add(bInput);
    }
}
