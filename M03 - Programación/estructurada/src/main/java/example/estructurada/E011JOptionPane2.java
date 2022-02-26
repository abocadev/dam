package example.estructurada;

import javax.swing.JOptionPane;

public class E011JOptionPane2 {
    public static void main(String[] args) {
        String mensaje = JOptionPane.showInputDialog(null, "Introduce tu nombre: ");
        System.out.println(mensaje);
        JOptionPane.showConfirmDialog(null, "Hola, tu nombre es " + mensaje);
    }
    
}
