package dev.boca.poo;

public class CocheConLlave {
    // atributos
    String marca;
    String color;
    float kms;

    private boolean acceso = false;
    public void usarLlave(String clave){
        if(clave.equals("12345")){
            acceso = true;
        }else{
            acceso = false;
            System.out.println("Te estan robando el coche");
        }

    }

    public void mando(String accion){
        if(acceso == true){
            if(accion.equals("arranca")){
                arranca();
            }
        }
    }

     // metodos
    public void arranca(){
        System.out.println("metodo arrancado");
    }

    public void acelerar(){
        System.out.println("metodo acelera");
    }

    public void frena(){
        System.out.println("metodo frena");
    }
}
