package example.estructurada;

import javax.swing.JOptionPane;

public class UF1_008_1 {
    public static void main(String[] args) {
        int num1 = Integer.parseInt(JOptionPane.showInputDialog(null, "Inserta un numero:"));
        int num2 = Integer.parseInt(JOptionPane.showInputDialog(null, "Inserta otro numero:"));
        int num3 = Integer.parseInt(JOptionPane.showInputDialog(null, "Inserta otro numero:"));
        if (num1>num2 && num1>num3){
            JOptionPane.showConfirmDialog(null, "El numero " + num1 + " es el mayor que el resto");
        } else if(num2 > num1 && num2 > num3){
            JOptionPane.showConfirmDialog(null, "El numero " + num2 + " es mayor que el resto");
        }else if(num3 > num1 && num3 > num2){
            JOptionPane.showConfirmDialog(null, "El numero " + num3 + " es mayor que el resto");
        } else if(num1 == num2 && num2 == num3){
            JOptionPane.showConfirmDialog(null, "El numero " + num1 + " lo has repetido 3 veces.");
        } else{
            JOptionPane.showConfirmDialog(null, "¡ERROR!");
        }
    }
    
}
