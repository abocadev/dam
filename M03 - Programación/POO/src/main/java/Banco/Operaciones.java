package Banco;

import java.util.Scanner;

public class Operaciones {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        String nombre, num;
        double importe;
        
        CC cuentaMaria = new CC();
        
        System.out.println("Nombre: ");
        nombre = entrada.nextLine();
        System.out.println("Numero de cuenta: ");
        num  = entrada.nextLine();
        System.out.println("Saldo: ");
        importe = entrada.nextDouble();
        
        cuentaMaria.setNombre(nombre);
        cuentaMaria.setNumCuenta(num);
        cuentaMaria.setSaldo(importe);
        CC cuentaPepe = new CC("Pepe", "12345678", 325);
        
        System.out.println("DATOS DE LA CUENTA DE MARIA");
        System.out.println("nombre del titular: " + cuentaMaria.getNombre());
        System.out.println("Numero de cuenta: " + cuentaMaria.getNumCuenta());
        System.out.println("Saldo: " + cuentaMaria.getSaldo());
        
        // ingreso de mi cuenta
        cuentaMaria.ingreso(5000);
        
        // imprimir el saldo de maria
        System.out.println("Saldo:  " + cuentaMaria.getSaldo());
        
        
        System.out.println("DATOS DE LA CUENTA DE PEPE");
        System.out.println("nombre del titular: " + cuentaPepe.getNombre());
        System.out.println("Numero de cuenta: " + cuentaPepe.getNumCuenta());
        System.out.println("Saldo: " + cuentaPepe.getSaldo());
    }
    
}
