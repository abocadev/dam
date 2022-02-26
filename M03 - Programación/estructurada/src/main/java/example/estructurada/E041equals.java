package example.estructurada;
public class E041equals {
    public static void main(String[] args) {
        // comprobar si en el array args existe argumentos
        // tiene argumenos?
        if(args.length > 0){
            // recorrer el array
            for(int i = 0; i < args.length; i++){
                if(args[i].equals("hola")){
                    System.out.println("El argumento " + (i+1) + " es \"hola\"");
                } else{
                    System.out.println("El argumento " + (i+1) + " no es \"hola\"");
                }
            }
        }
    }
    
}
