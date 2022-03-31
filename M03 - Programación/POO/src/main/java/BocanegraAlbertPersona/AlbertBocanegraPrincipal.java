package BocanegraAlbertPersona;
import java.util.Scanner;
public class AlbertBocanegraPrincipal {
    public static void main(String[] args) {
        AlbertBocanegraPersona persona1 = new AlbertBocanegraPersona();
        Scanner entrada = new Scanner(System.in);
        String name = null;
        int edad = 0;
        int numDni = 0;
        char sexo = 0;
        double peso = 0, altura = 0;
        
        boolean salir = false;
        while(!salir){
            System.out.println("Introduce tu nombre y Apellido: ");
            if(entrada.hasNextLine()){
                name = entrada.nextLine();
                salir = true;
            }else{
                entrada.nextLine();
                System.out.println("El valor que has introducido no es correcto.");
            }
        }
        
        salir = false;
        
        while(!salir){
            System.out.println("Introduce tu edad: ");
            if(entrada.hasNextInt()){
                edad = entrada.nextInt();
                salir = true;
            }else{
                entrada.nextLine();
                System.out.println("El valor que has introducido no es correcto.");
            }
        }
        
        salir = false;
        
        while(!salir){
            System.out.println("Introduce tu numero de DNI: ");
            if(entrada.hasNextInt()){
                numDni = entrada.nextInt();
                int aux = numDni;
                int contador = 0;
                while(aux != 0){
                    contador++;
                    aux/=10;
                }
                if(contador == 8){
                    salir = true;
                }else if(contador > 8){
                    System.out.println("Has introducido mas de 8 numeros, tienes que introducir 8");
                }else{
                    System.out.println("Has introducido menos de 8 numeros, tienes que introducir 8");
                }
            }else{
                entrada.nextLine();
                System.out.println("Has introducido un valor no valido.");
            }
        }
        
        salir = false;
        
        while(!salir){
            System.out.println("Introduce tu sexo:");
            System.out.println("    [H] -> Hombre");
            System.out.println("    [M] -> Mujer");
            System.out.println("    [O] -> Otro");
            System.out.println("\nIntroduce tu respuesta:");
            if(entrada.hasNext()){
                String aux = entrada.next().toUpperCase();
                if(aux.length() == 1){
                    sexo = aux.charAt(0);
                    salir = true;
                }else{
                    System.out.println("Has introducido caracteres de mas");
                }
            }else{
                entrada.nextLine();
                System.out.println("Has introducido un valor incorrecto");
            }
        }
        
        salir = false;
        
        while(!salir){
            System.out.println("Introduce tu peso (solo se permiten dos decimales):");
            if(entrada.hasNextDouble()){
                peso = entrada.nextDouble();
                salir = true;
            }else{
                entrada.nextLine();
                System.out.println("Has introducido un valor incorrecto");
            }
        }
        
        salir = false;
        
        while(!salir){
            System.out.println("Introduce tu altura (solo se permiten dos decimales):");
            if(entrada.hasNextDouble()){
                altura = entrada.nextDouble();
                salir = true;
            }else{
                entrada.nextLine();
                System.out.println("Has introducido un valor incorrecto");
            }
        }
        
        persona1 = new AlbertBocanegraPersona(name, edad, numDni, sexo, peso, altura);
        
        //System.out.println("Nombre: " + persona1);
        System.out.println("Los numeros de tu DNI es " + persona1.getNumDNI() + " y la letra de tu DNI es " + persona1.getLetraDni() + '.');
        System.out.println("Pesas " + persona1.getPeso() + " y tu indice de masa corporal es " + persona1.calcularPeso() + '.');
        System.out.println('¿' + persona1.getName() + "es mayor de edad? " + persona1.comprobarEdad());
    }
    
}