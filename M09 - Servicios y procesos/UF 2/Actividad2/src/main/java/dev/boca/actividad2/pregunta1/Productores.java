/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dev.boca.actividad2.pregunta1;
public class Productores extends Thread{
    
    GestorAlmacen ga;
    
    public Productores(GestorAlmacen ga){
        this.ga = ga;
    }
    @Override
    public void run(){
        try {
            ga.agregar(5);
        } catch (InterruptedException e) {
        }
    }
}
