
package TarjetaRegalo;
public class Tarjeta {
    // atributos
    String numero;
    double saldo;
    
    public Tarjeta(double Saldo){
        this.saldo = saldo;
        // GEnerar numero aleatoriamente
        this.numero = "";
        for(int i = 0; i<5;i++){
            this.numero += (int) (Math.random() * 10);
        }
    }
    
    @Override
    public String toString() {
        return "Tarjeta{" + "numero=" + numero + ", saldo=" + saldo + '}';
    }
    
    public void gastar(double gasto){
        if(gasto>saldo){
            System.out.println("No tienes sufieicnete saldo");
        }else{
            saldo -= gasto;
        }
    }

    
}
