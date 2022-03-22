package herencia;
public class Herencia {
    public static void main(String[] args) {
        Estudiante x = new Estudiante("123", 5f, "Pepe", "Garcia", 21);
        x.mostrarNombre();
        System.out.println(x.getEdad());
    }   
}