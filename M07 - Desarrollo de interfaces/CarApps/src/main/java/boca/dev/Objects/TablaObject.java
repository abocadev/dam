package boca.dev.Objects;
public class TablaObject {
    
    // Objeto de los valores de las tablas
    String nombre, modelo, marca, color, gasolina;
    float precio;

    public TablaObject(String nombre, String modelo, String marca, String color, String gasolina, float precio) {
        this.nombre = nombre;
        this.modelo = modelo;
        this.marca = marca;
        this.color = color;
        this.gasolina = gasolina;
        this.precio = precio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getGasolina() {
        return gasolina;
    }

    public void setGasolina(String gasolina) {
        this.gasolina = gasolina;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }
    
}