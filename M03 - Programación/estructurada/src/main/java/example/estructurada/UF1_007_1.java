package example.estructurada;

import javax.swing.JOptionPane;

public class UF1_007_1 {
    public static void main(String[] args) {
        int dividendo = Integer.parseInt(JOptionPane.showInputDialog(null, "Inserta el primer número:"));
        int divisor = Integer.parseInt(JOptionPane.showInputDialog(null, "Inserta el segundo número:"));
        if(dividendo != 0 && divisor != 0){
            int resultado1 = dividendo / divisor;
            int resultado2 = dividendo % divisor;
            JOptionPane.showConfirmDialog(null, dividendo + "/" + divisor + " = " + resultado1);
            JOptionPane.showConfirmDialog(null, "El residuo de la división es: " + resultado2);
        } else{
            JOptionPane.showConfirmDialog(null, "El divisor o el dividendo es igual a 0");
        }
    }
}
