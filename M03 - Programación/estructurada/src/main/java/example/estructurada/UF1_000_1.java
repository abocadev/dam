package example.estructurada;
import javax.swing.JOptionPane;
public class UF1_000_1 {
    public static void main(String[] args) {
        // Pedimos el primer número
        int y = Integer.parseInt(JOptionPane.showInputDialog(null, "Introduce un número:"));
        // Pedimos el segundo número
        int x = Integer.parseInt(JOptionPane.showInputDialog(null, "Introduce otro número:"));
        // Imprimimos por pantalla los dos números
        JOptionPane.showConfirmDialog(null, "Has introducido los números " + y + " y " + x);
    }
}
