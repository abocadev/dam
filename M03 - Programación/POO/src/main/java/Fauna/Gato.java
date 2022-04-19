package Fauna;
public class Gato extends Animal{
    @Override
    public void comer(){
        System.out.println("Los gatos comen pescado");
    }

    // metodos para que los gatos corran
    public void correr(){
        System.out.println("Los gatos corren");
    }
}
