package com.mycompany.modular;

import java.util.Scanner;

public class E004temperatura {
    
    // declaracion de constantes
    private static final int SEMANAS = 42;
    
    // declaracion de variables globales
    private int numTemperaturas = 0;
    private float[] temperaturas = new float[SEMANAS*7];
    private Scanner entrada = new Scanner(System.in);
    
    private String option = "";
    private int dia = 1;
    private int mes = 1;


    public static void main(String[] args) {
        E004temperatura programa = new E004temperatura();
        programa.inicio();
    }
    
    public void inicio(){
        System.out.println("Bienvenido al registro de temperaturas");
        mostrarMenu();
    }
    
    public void mostrarMenu(){
        System.out.println("-------------------------------------\n[RT] Registrar temperaturas semanales\n[MD] Consultar la media\n[DF] Consultar la diferencia maxima\n[FIN] Salir");
        System.out.print("Opcion: ");
        tratarOpcion();
    }
    
    public void tratarOpcion(){
        option = entrada.nextLine();
        if(option.equals("RT")){
            registroTemperaturaSemanal();
        }else if(option.equals("MD")){
            mostrarMedia();
        }else if(option.equals("DF")){
            mostrarDiferencia();
        }else if(option.equals("FIN")){
            finalizarPrograma();
        }else{
            System.out.println("Opcion no valida");
            entrada.next();
            mostrarMenu();
        }
    }
    
    public void registroTemperaturaSemanal(){
        // comprobar qye eb ek array caben 7 registros        
        if((numTemperaturas + 7) >= temperaturas.length){
            System.out.println("No queda espacio para otra semana de temperaturas");
        }else{
            leerTemperatura();
            actualizarFecha();
        }
        mostrarMenu();
    }

    public void mostrarMedia(){
        if(numTemperaturas > 0){
            System.out.print("\nHasta hoy ");
            mostrarFecha();
            System.out.print(" la media ha sido de ");
            calcularMedia();
            System.out.println(" grados.");
        }else{
            System.out.println("No hay temperaturas registradas.");
        }
    }

    public void mostrarDiferencia(){
        if(numTemperaturas > 0){
            System.out.print("\nHasta hoy ");
            mostrarFecha();
            System.out.print(" la media ha sido de ");
            calcularMedia();
            System.out.println(" grados.");
        }
    }
    
    public void leerTemperatura(){
        System.out.println("Escribe las temperaturas de esta semana:");
        int numLeidas = 0;
        while(numLeidas < 7){
            if(entrada.hasNextFloat()){
                temperaturas[numTemperaturas] = entrada.nextFloat();
                numLeidas++;
                numTemperaturas++;
            }else{
                entrada.next();
            }
        }
        entrada.nextLine();
    }
    
    public void actualizarFecha(){
        // Cuantos dias tiene este mes?
        int diasmesActual = 0;
        if (mes == 2){
            diasmesActual = 28;
        }else if((mes == 4) || (mes ==6) || (mes==9) || (mes==11)){
            diasmesActual = 30;
        }else{
            diasmesActual = 31;
        }
        
        dia+=7;
        // cambio de mes
        if(dia > diasmesActual){
            dia = dia - diasmesActual;
            mes++;
            //cambio de ano
            if(mes > 12){
                mes = 1;
            }
        }
    }
    
    public void mostrarFecha(){
        System.out.println(dia + " de ");
        switch(mes){
            case 1:
            System.out.println("enero");
            break;
            case 2:
            System.out.println("febrero");
            break;
            case 3:
            System.out.println("marzo");
            break;
            case 4:
            System.out.println("abril");
            break;
            case 5:
            System.out.println("mayo");
            break;
            case 6:
            System.out.println("junio");
            break;
            case 7:
            System.out.println("julio");
            break;
            case 8:
            System.out.println("agosto");
            break;
            case 9:
            System.out.println("septiembre");
            break;
            case 10:
            System.out.println("octubre");
            break;
            case 11:
            System.out.println("noviembre");
            break;
            case 12:
            System.out.println("diciembre");
            break;
        }
        mostrarFecha();
    }
    
    public void calcularMedia(){
        float acumulador = 0;
        for (int i= 0; i<numTemperaturas;i++){
            acumulador = acumulador + temperaturas[i];
        }
        mostrarFecha();
    }
    
    public void calcularDiferencia(){
        float max = temperaturas[0];
        float min = temperaturas[0];
        for(int i = 0; i<numTemperaturas; i++){
            if(temperaturas[i]<min){
                min = temperaturas[i];
            }
            if(temperaturas[i]>max){
                max = temperaturas[i];
            }
        }
        System.out.println(max - min);
        mostrarMenu();
    }
    
    public void finalizarPrograma(){
        System.exit(0);
    }
}
