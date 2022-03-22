package Fauna;

public class Sobreescritura {
    public static void main(String[] args) {
        Animal a = new Animal();
        Gato g = new Gato();
        Pajaro p = new Pajaro();

        a.comer();
        
        g.comer();  // ejecutando el metodo sobreescrito de Animal
        g.correr(); 

        p.comer();
        p.volar();
    }
}
