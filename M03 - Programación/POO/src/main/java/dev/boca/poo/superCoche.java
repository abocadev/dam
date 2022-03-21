package dev.boca.poo;

public class superCoche {
    String marca, color;
    float kms;
    
    public static void main(String[] args) {
        superCoche deLorean = new superCoche();

        deLorean.color = "gris";
        deLorean.kms = 0f;
        deLorean.marca = "DMC";
        System.out.println("El color de mi coche es: " + deLorean.color);
        System.out.println("La marca de mi coche es: " + deLorean.marca);
        System.out.println("El kilometraje de mi coche es: " + deLorean + "kms.");

        superCoche granTorino = new superCoche();
        
        granTorino.color = "gris";
        granTorino.marca = "Ford";
        granTorino.kms = 100000f;
    }
}
