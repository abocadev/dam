package flota;

public abstract class Gasolina extends Vehiculo {
    public abstract void ruedas();

    public void acelerar(){
        System.out.println("Los vehiculos de gasolina aceleran");
    }
}
