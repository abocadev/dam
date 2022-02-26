package example.estructurada;

import javax.swing.JOptionPane;

public class E012JOptionPane {
    public static void main(String[] args) {
        //int num = JOptionPane.showInputDialog(null, "Introduce un numero: ");
        // da error porque JOptionPane recibe Strings por defecto.
        // necesitamos hacer una conversión de tipo int.
        
        int num = Integer.parseInt(JOptionPane.showInputDialog(null, "Introduce un numero: "));
        System.out.println(num + 10);
    }
    
}
