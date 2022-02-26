package example.estructurada;

import javax.swing.JOptionPane;

public class UF1_009_1 {
    public static void main(String[] args) {
        int h = Integer.parseInt(JOptionPane.showInputDialog(null, "Inserta la hora:"));
        int m = Integer.parseInt(JOptionPane.showInputDialog(null, "Inserta la hora:"));
        int s = Integer.parseInt(JOptionPane.showInputDialog(null, "Inserta la hora:"));
        
        if (h >= 0 && h <= 24 && m >= 0 && m <= 60 && s >= 0 && s <= 60) {
            JOptionPane.showConfirmDialog(null, h+":"+m+":"+s);
            JOptionPane.showConfirmDialog(null, "La HORA introducida es valida");
        } else {
            JOptionPane.showConfirmDialog(null, "La HORA introducida es erronea.");
        }

    }
    
}
