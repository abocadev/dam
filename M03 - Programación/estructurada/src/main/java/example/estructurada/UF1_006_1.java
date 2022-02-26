package example.estructurada;

import javax.swing.JOptionPane;

public class UF1_006_1 {
    public static void main(String[] args) {
        int num = Integer.parseInt(JOptionPane.showInputDialog(null, "Inserta un numero del 1 al 100:"));
        if (num%2 == 0 && num <= 100 && num>=1){
            JOptionPane.showConfirmDialog(null, "El numero " + num + " es par");
        } else if(num <= 100 && num>=1){
            JOptionPane.showConfirmDialog(null, "El numero " + num + " es impar");
        } else{
            JOptionPane.showConfirmDialog(null, "El numero que has introducido no es mayor que 1 o no es menor a 100");
        }
    }
    
}
