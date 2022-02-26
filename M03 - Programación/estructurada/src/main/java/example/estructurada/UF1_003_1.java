package example.estructurada;

import javax.swing.JOptionPane;

public class UF1_003_1 {
    public static void main(String[] args) {
        int C = Integer.parseInt(JOptionPane.showInputDialog(null, "Introduce grados centigrados"));
        int F = 32 + (9 * C / 5);
        JOptionPane.showConfirmDialog(null, C + "ºC equivale a " + F + "ºF");
    }
    
}
