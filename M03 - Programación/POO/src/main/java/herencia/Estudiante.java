package herencia;
public class Estudiante extends Persona{
    private String codEstudiante;
    private float nota;
    
    // constructor de estudiante

    public Estudiante(String codEstudiante, float nota, String nombre, String apellidos, int edad) {
        super(nombre, apellidos, edad);
        this.codEstudiante = codEstudiante;
        this.nota = nota;
    }

    public String getCodEstudiante() {
        return codEstudiante;
    }

    public float getNota() {
        return nota;
    }
    
    public void mostrarNombre(){
        //System.out.println("Nombre: " + this.nombre);
        // Es un atributo privado, por eso no se puede acceder con this
        System.out.println("Nombre: " + this.getNombre() + " " + this.getApellidos());
        
    }
}