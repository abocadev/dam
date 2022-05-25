package TorresKatlheenContacto;

import java.io.Serializable;

public class Contacto implements Serializable{
    private static final long serialVersionUID = 1L;
    
    private String nombre, empresa, email, origen;
    private int telefono;

    public Contacto(){
    }
    public Contacto(String nombre, String empresa, String email, int telefono) {
        this.nombre = nombre;
        this.empresa = empresa;
        this.email = email;
        this.telefono = telefono;
        this.origen = "AB";
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    @Override
    public String toString() {
        return "Contacto{" + "nombre=" + nombre + ", empresa=" + empresa + ", email=" + email + ", origen=" + origen + ", telefono=" + telefono + '}';
    }
    
    
}