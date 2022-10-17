package dev.boca.Ejercicios.Ejercicio3;

public class HiloEnvio extends Thread{
    private Bolsa bolsa;
    public HiloEnvio(Bolsa bolsa){
        super();
        this.bolsa = bolsa;
    }

    @Override
    public void run(){
        if(bolsa.estaLlena() != true){
            try {
                synchronized(bolsa){
                    bolsa.wait();

                }
            }catch (InterruptedException e){
                System.out.println("Enviando la bolsa con " + bolsa.getSize() + "elementos");
            }
        }
    }
}
