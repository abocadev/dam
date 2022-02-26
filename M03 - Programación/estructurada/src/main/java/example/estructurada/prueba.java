/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package example.estructurada;

/**
 *
 * @author Alumno
 */
public class prueba {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String str = "123";
        boolean isNumeric =  str.matches("[+-]?\\d*(\\.\\d+)?");
        System.out.println(isNumeric);
        str = "121xy";
        isNumeric =  str.matches("[+-]?\\d*(\\.\\d+)?");
        System.out.println(isNumeric);
        str = "0x234";
        isNumeric =  str.matches("[+-]?\\d*(\\.\\d+)?");
        System.out.println(isNumeric);
    
    }
    
}
