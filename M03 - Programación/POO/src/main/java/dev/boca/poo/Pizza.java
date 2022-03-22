package dev.boca.poo;

public class Pizza {
    private static int totalPedidas = 0;
    private static int totalServidas = 0;
    
    // atributos
    private String nombre;
    private String tam;
    private String estado;

    public Pizza(String nombre, String tam){
        this.nombre = nombre;
        this.tam = tam;
        this.estado = "pedida";
        Pizza.totalPedidas++;
    }
  
    public String toString() {
        return "Pizza{" + "nombre=" + nombre + ", tam=" + tam + ", estado=" + estado + "}";
    }
    
    public static int getTotalPedidas() {
        return totalPedidas;
    }

    public static int getTotalServidas() {
        return totalServidas;
    }
    
    // incremento de TotalServidas
    public void servir(){
        if(this.estado.equals("pedida")){
            this.estado = "servida";
            Pizza.totalServidas++;
            System.out.println("Pizza no servida");
        }else{
            System.out.println("Pizza no servida");
        }
    }
}
