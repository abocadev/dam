package Banco;
public class CC {
    // atributos
    private String nombre;
    private String numCuenta;
    private double Saldo;
    
    // constructor

    public CC(String nombre, String numCuenta, double Saldo) {
        this.nombre = nombre;
        this.numCuenta = numCuenta;
        this.Saldo = Saldo;
    }

    public CC() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNumCuenta() {
        return numCuenta;
    }

    public void setNumCuenta(String numCuenta) {
        this.numCuenta = numCuenta;
    }

    public double getSaldo() {
        return Saldo;
    }

    public void setSaldo(double Saldo) {
        this.Saldo = Saldo;
    }
    
    public boolean ingreso(double cantidad){
        boolean ingresoOK = true;
        if(cantidad <= 0){
            ingresoOK = false;
        }else{
            Saldo += cantidad;
        }
        return ingresoOK;
    }
    
    public boolean sacar(double cantidad){
        boolean sacarOK = true;
        if(cantidad <= 0){
            sacarOK = false;
        }else if(Saldo >= cantidad){
            Saldo -= cantidad;
        }else{
            sacarOK = false;
        }
        return sacarOK;
    }
}
