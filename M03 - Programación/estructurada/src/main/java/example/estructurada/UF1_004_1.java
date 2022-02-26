package example.estructurada;

import javax.swing.JOptionPane;

public class UF1_004_1 {
    public static void main(String[] args) {
        String number = JOptionPane.showInputDialog(null, "Inserta un numero de 5 cifras:");
        JOptionPane.showConfirmDialog(null, number.charAt(0));
        JOptionPane.showConfirmDialog(null, number.charAt(0) + "" + number.charAt(1));
        JOptionPane.showConfirmDialog(null, number.charAt(0) + "" + number.charAt(1) + "" + number.charAt(2));
        JOptionPane.showConfirmDialog(null, number.charAt(0) + "" + number.charAt(1) + "" + number.charAt(2) + "" + number.charAt(3));
        JOptionPane.showConfirmDialog(null, number.charAt(0) + "" + number.charAt(1) + "" + number.charAt(2) + "" + number.charAt(3) + "" + number.charAt(4));
    }
    
}
