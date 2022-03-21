package dev.boca.poo;
public class PerroProtectora {
    public static void main(String[] args) {
        Perro[] perros = new Perro[5];
        
        perros[0] = new Perro("Milu", "blanco", "Fox Terrier");
        perros[1] = new Perro("Patan", "marron", "Russell");
        perros[2] = new Perro("Scoby Doo", "marron", "Gran Danes");
        perros[3] = new Perro("Odi", "amarillo", "perro cualquiera");
        perros[4] = new Perro("Hong Kong Phooey", "naranja", "ni idea");

        System.out.println("Registro de perros");
        
        for(int i = 0; i<5;i++){
            System.out.println("Perro n: " + (i+1));
            System.out.println("Nombre: " + perros[i].getNombre());
            System.out.println("Color: " + perros[i].getColor());
            System.out.println("Raza: " + perros[i].getRaza());
            System.out.println("***************************************");
            

        }
                
    }
    
}
