package BocanegraAlbertContacto;

import java.io.Serializable;

public class ABContacto implements Serializable{
    private static final long serialVersionUID = 1L;
    
    private String nombre, empresa, email;
    private int telefono;

    public ABContacto(String nombre, String empresa, String email, int telefono) {
        this.nombre = nombre;
        this.empresa = empresa;
        this.email = email;
        this.telefono = telefono;
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

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    @Override
    public String toString() {
        return "ABContacto{ Nombre: " + nombre + "\nEmpresa: " + empresa + "\nEmail: " + email + "\nTelefono: " + telefono + '}';
    }
}