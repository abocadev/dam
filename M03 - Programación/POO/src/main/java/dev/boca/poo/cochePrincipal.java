package dev.boca.poo;

public class cochePrincipal {
    public static void main(String[] args) {
        Coche fiesta = new Coche();
        Coche s600 = new Coche();

        fiesta.marca = "Ford";
        fiesta.kms = 100000;
        fiesta.color = "rojo";

        s600.color = "blanco";
        s600.marca = "fiat";
        s600.kms = 200000;

        fiesta.arranca();
        fiesta.acelerar();
        fiesta.frena();

        System.out.println("Marca: " + fiesta.marca);
    }
}
