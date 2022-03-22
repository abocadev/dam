package dev.boca.poo;
public class PizzaMain {
    public static void main(String[] args) {
        Pizza p1 = new Pizza("margarita", "mediana");
        Pizza p2 = new Pizza("peperoni", "familiar");
        
        //p1.toString();
        //toString() tiene return, no puedo invocarlo sin variable
        System.out.println(p1.toString());
        
        p1.servir();
        
        System.out.println(p1);
        
        Pizza p3 = new Pizza("barbacoa", "familiar");
        
        p3.servir();
        
        System.out.println("Pizzas pedidas: " + Pizza.getTotalPedidas());
        System.out.println("Pizzas servidas: " + Pizza.getTotalServidas());        
    }
    
}
