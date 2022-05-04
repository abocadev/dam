package dev.boca.uf5.bibliotecas_clases_fundamentales;

// Importamos las librerias para crear los elementos de la interfaz
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

// Importamos los paquetes para editar la fuente
import java.awt.Color;
import java.awt.Font;

// Importamos los paquetes para los eventos del raton
import java.awt.HeadlessException;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class BocanegraAlbertBoton extends JFrame {
    
    // Creamos el metodo main
    public static void main(String[] args) {
        BocanegraAlbertBoton programa = new BocanegraAlbertBoton("¿APROBARE?");
        programa.setVisible(true); // Le indicamos que la ventana sea visible
    }

    // Inicializamos las variables de la interfaz
    private JPanel panel;
    private JLabel texto;
    private JButton botonNormal, botonEscapar;
    
    // Inicializamos las variables para los metodos 
    private static boolean iniciar = false;
    private static int contador = 0;

    // Creamos un constructor para obtener el titulo de la ventana y mas...
    public BocanegraAlbertBoton(String title) throws HeadlessException {
        super(title); // Indicamos el titulo de la ventana
        setSize(500, 500); // El tamaño de la ventana
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE); // Le decimos que cuando le demos al boton de cerrar se cierre el programa
        setResizable(false); // Le indicamos que la ventana no se puede redimensionar
        
        crearComponentes(); // Llamamos al metodo que crea los objetos.
    }
    
    // Este metodo sirve para llamar a otros metodos para que creen los metodos 
    private void crearComponentes() {
        // Estos metodos son los elementos que se visualizaran en la ventana
        crearPanel();
        crearTexto();
        botones();

        // Este metodo es el de los eventos
        eventos();
    }
    
    // Este es el metodo del panel
    private void crearPanel() {
        panel = new JPanel();
        Color colorFondo = new Color(Integer.parseInt("578EE6", 16)); // Esto sirve para poner un color en hexadecimal
        panel.setBackground(colorFondo); // Insertamos el color de fondo
        panel.setLayout(null); // Le decimos que ya posicionaremos los elementos manualmente
        this.getContentPane().add(panel); // Añadimos para que funcione el panel
    }

    // Creamos el metodo para insertar el panel
    private void crearTexto() {
        texto = new JLabel();
        texto.setText("¿Aprobaré el M03?"); // Le insertamos el texto a la etiqueta
        panel.add(texto); // Añadimos el texto al panel
        texto.setBounds(125, 10, 250, 30); // Le indicamos posicion y tamaño
        texto.setForeground(Color.WHITE); // Le insertamos el color del texto
        texto.setFont(new Font("Tahoma", Font.BOLD, 24)); // Le modificamos la fuente
    }

    // Este es el metodo de los botones
    private void botones() {
        // opciones del botonNormal
        botonNormal = new JButton("¡JAMÁS!"); // Creamos el boton y le insertamos el texto
        botonNormal.setBounds(75, 75, 100, 25); // Le indicamos la posicion y el tamaño
        botonNormal.setFont(new Font("Tahoma", Font.BOLD, 16)); // Le cambiamos la fuente al boton
        
        // opciones del botonEscapar
        botonEscapar = new JButton("¡Y TANTO!"); // Creamos el boton y le insertamos el texto
        botonEscapar.setBounds(300, 75, 125, 25); // Le indicamos la posicion y el tamaño
        botonEscapar.setFont(new Font("Tahoma", Font.BOLD, 16)); // Le cambiamos la fuente al boton
        
        // Añadimos los botones al panel
        panel.add(botonNormal);
        panel.add(botonEscapar);
    }

    // Creamos el metodo para que el boton escape
    private void escapar(){
        
        /*
            Creamos el contador para cuando se le haya pulsado al boton de JAMAS
            Te dice que lo vuelvas a intentar al menos 10 veces y cada vez que escape se incrementa el contador
            Una vez que hayan pasado 10 veces, lo que hace es que se queda quieto para que lo puedas pulsar
        */
        if(contador < 10){
            int randomX = (int) (Math.random() * 400), randomY = (int) (Math.random() * 400); // Creamos dos variables para almacenar el valor X y para el valor Y
            botonEscapar.setBounds(randomX, randomY, 125, 25); // Insertamos en la posicion aleatoria y mantenemos el tamaño del elemento
            
            // Incrementamos el contador si el boolean de iniciar es truef
            if(iniciar){
                contador++;
            }
        }
    }
    
    // Creamos el metodo de evento
    private void eventos() {
        
        // Creamos el MouseListener para que escape el boton
        MouseListener eventoEscapar = new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // En el caso que el usuario le llegue a clickar al boton, porque a aparecido al lado o por el contador le sale un mensaje u otro
                // Y se vuelve a ejecutar el metodo de escapar
                if(contador == 10){
                    JOptionPane.showMessageDialog(null, "VAS A SUPENDER IGUAL");
                    iniciar = false;
                    contador = 0;
                }else{
                    JOptionPane.showMessageDialog(null, "¡LO HAS CONSEGUIDO!\nVas a aprobar");
                }
                escapar();
            }

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {
            }
            
            // Cuando el usuario se posicione encima del boton, ejecutara el metodo de escapar
            @Override
            public void mouseEntered(MouseEvent e) {
                escapar();
            }
        };
        botonEscapar.addMouseListener(eventoEscapar); // Añadimos el Listener al boton de Escapar
        
        // Creamos el listener 
        MouseListener eventoClick = new MouseListener() {
            @Override
            // Cuando cliquemos al boton de JAMAS, aparecera una ventana diciendo que no se rinda
            // Y pondra la variable iniciar como true, para poder iniciar el contador
            public void mouseClicked(MouseEvent e) {
                JOptionPane.showMessageDialog(null, "¡NO TE RINDAS, INTENTALO AL MENOS 10 VECES MAS!");
                iniciar = true;
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
        botonNormal.addMouseListener(eventoClick); // Añadimos el Listener al boton normal
    }
}