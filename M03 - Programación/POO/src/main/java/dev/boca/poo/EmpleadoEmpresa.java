package dev.boca.poo;
public class EmpleadoEmpresa {
    public static void main(String[] args) {
        Empleado fernando = new Empleado();
        fernando.setEdad(68);
        
        System.out.println("Edad: " + fernando.getEdad());
        
        fernando.setNombre("Fernando");
    }    
}
