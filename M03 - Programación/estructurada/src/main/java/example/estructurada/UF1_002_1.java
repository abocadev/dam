package example.estructurada;

import javax.swing.JOptionPane;

public class UF1_002_1 {
    public static void main(String[] args) {
        int num = Integer.parseInt(JOptionPane.showInputDialog(null, "Introduce un número: "));
        JOptionPane.showConfirmDialog(null, "El doble de " + num + " es " + num*2 + "\nEl triple de " + num + " es " + num*3);
    }
    
}
