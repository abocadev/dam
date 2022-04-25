/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package dev.boca.uf5.bibliotecas_clases_fundamentales;

/**
 *
 * @author USUARI
 */
public class E003main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException{
        E003ventana ventana = new E003ventana("Ventana increible");
        for(int i = 0; i< 10;i++){
            Thread.sleep(200);
            ventana.setLocation(i*30, i*30);
        }
    }
    
}
