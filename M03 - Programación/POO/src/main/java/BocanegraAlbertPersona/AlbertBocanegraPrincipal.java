package BocanegraAlbertPersona;
import java.util.Scanner;
public class AlbertBocanegraPrincipal {
    public static void main(String[] args) {
        // Declaramos un objeto de la clase AlbertBocanegraPersona
        AlbertBocanegraPersona p1 = new AlbertBocanegraPersona();
        // Creamos la variable Scanner para poder introducir datos
        Scanner entrada = new Scanner(System.in);
        // Creamos las variables donde almaceneramos las respuestas del usuario
        // Y la hemos inicializado para poder que netbeans no nos salte ningun error
        String name = null;
        int edad = 0;
        int numDni = 0;
        char sexo = 0;
        double peso = 0, altura = 0;
        
        // Creamos la variable salir para poder salir de los bucles
        boolean salir = false;
        
        // Hacemos un bucle para que introduzca nombres y apellidos, con validacion de datos
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
        
        salir = false; // Le volvemos a dar el valor de false a la variable.
        
        // Hacemos un bucle para que introduzca nombres y apellidos, con validacion de datos
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
        
        salir = false; // Le volvemos a dar el valor de false a la variable
        
        // Hacemos un bucle para que introduzca el numero de DNI, con validacion de datos
        while(!salir){
            System.out.println("Introduce tu numero de DNI: ");
            if(entrada.hasNextInt()){
                numDni = entrada.nextInt();
                int aux = numDni;
                int contador = 0;
                // Lo que hacemos en este bucle es contar los digitos que tiene el numero
                while(aux != 0){
                    contador++;
                    aux/=10;
                }
                // Y aqui comprobamos si se han insertado la cantidad exacta de digitos
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
        
        salir = false; // Le volvemos a dar el valor de false a la variable
        
        // Hacemos un bucle para que introduzca el sexo, con validacion de datos
        while(!salir){
            System.out.println("Introduce tu sexo:");
            System.out.println("    [H] -> Hombre");
            System.out.println("    [M] -> Mujer");
            System.out.println("    [O] -> Otro");
            System.out.println("\nIntroduce tu respuesta:");
            if(entrada.hasNext()){
                String aux = entrada.next().toUpperCase();
                // Comprobamos si tiene un digito y en el caso que lo tenga lo almacenamos en una variable tipo "char"
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
        
        salir = false; // Le volvemos a dar el valor de false a la variable
        
        // Hacemos un bucle para que introduzca el peso, con validacion de datos
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
        
        salir = false; // Le volvemos a dar el valor de false a la variable
        
        // Hacemos un bucle para que introduzca la altura, con validacion de datos
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
        // Introducimos los datos utilizando el constructor
        p1 = new AlbertBocanegraPersona(name, edad, numDni, sexo, peso, altura);
        
        // Imprimimos el resultado
        System.out.println("-----------------------------------------------------------------------------");
        System.out.println("Tu nombre es: " + p1.getName());
        System.out.println("Sexo: " + p1.comprobarSexo());
        System.out.println("DNI: " + p1.getNumDNI() + p1.getLetraDni() + '.');
        System.out.println("Pesas " + p1.getPeso() + " y tu indice de masa corporal es " + p1.getIMC() + " y eso significa que " + p1.indicarPeso() + '.');
        System.out.println('¿' + p1.getName() + "es mayor de edad? " + p1.comprobarEdad());
    }
}