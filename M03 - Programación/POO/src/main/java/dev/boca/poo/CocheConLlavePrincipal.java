package dev.boca.poo;

public class CocheConLlavePrincipal {
    public static void main(String[] args) {
        CocheConLlave polo = new CocheConLlave();

        polo.marca = "VW";
        polo.kms = 0;
        polo.color = "red";

        polo.usarLlave("123456");
        polo.mando("arranca");

        polo.arranca();
        polo.acelerar();
        polo.frena();

        System.out.println("Marca: " + polo.marca);
    }
}
