package example.estructurada;

import javax.swing.JOptionPane;

public class UF1_001_1 {
    public static void main(String[] args) {
        String name = JOptionPane.showInputDialog(null, "¿Como te llamas?");
        JOptionPane.showConfirmDialog(null, "Buenos días, " + name);
    }
    
}
