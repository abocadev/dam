package BocanegraAlbertPersona;

public class AlbertBocanegraPersona {
    // arrray de caracteres para la letra del dni
    char letras[] = {'T', 'R', 'W', 'A', 'G', 'M', 'Y', 'F', 'P', 'D', 'X', 'B', 'N', 'J', 'Z', 'S', 'Q', 'V', 'H', 'L', 'C', 'K', 'E'};
    
    // Declaramos los atributos
    // Estos atributos los dara el usuario en el main
    private String name;
    private int edad;
    private int numDNI;
    private char sexo = 'O'; // H: Hombre | M: Mujer | O: Otro (opcion por defecto)
    private double peso;
    private double altura;
    // Estos atributos los calculara el usuario
    private char letraDni;
    private double IMC;

    // Creamos un constructor para introducir los datos que ha introducido el usuario
    public AlbertBocanegraPersona(String name, int edad, int numDNI, char sexo, double peso, double altura) {
        this.name = name;
        this.edad = edad;
        this.numDNI = numDNI;
        this.sexo = sexo;
        this.peso = peso;
        this.altura = altura;
    }
    
    // Creamos el constructor para inicializar sin tener que introducir datos
    public AlbertBocanegraPersona(){
    }
    
    /*
        Ahora lo que hemos hecho ha sido crear Getters y Setters
            Getters => Sirve para devolver el valor de una variable en concreto
            Setters => Sirve para almacenar el valor de una variable en concreto
    */
    
    // Este metodo sirve para que devuelva el valor del atributo Name
    public String getName() {
        return name;
    }
    // Este metodo sirve para que almacene el valor del atributo Name
    public void setName(String name) {
        this.name = name;
    }

    // Este metodo sirve para que devuelva el valor del atributo Edad
    public int getEdad() {
        return edad;
    }
    // Este metodo sirve para que almacene el valor del atributo Edad
    public void setEdad(int edad) {
        this.edad = edad;
    }
    
    // Este metodo sirve para que devuelva el valor del atributo NumDNI
    public int getNumDNI() {
        return numDNI;
    }
    // Este metodo sirve para que almacene el valor del atributo NumDNI
    public void setNumDNI(int numDNI) {
        this.numDNI = numDNI;
    }    
    
    // Este metodo sirve para que devuelva el valor del atributo LetraDNI, pero antes lo que haremos sera llamar a un metodo para poder calcular la letra correspondiente.
    public char getLetraDni() {
        calcularLetra();
        return letraDni;
    }
    // Este metodo sirve para que almacene el valor del atributo LetraDNI
    public void setLetraDni(char letraDni) {
        this.letraDni = letraDni;
    }
    
    // Este metodo sirve para que devuelva el valor del atributo Sexo, pero antes loo que haremos sera llamar al metodo de comprobarSexo()
    public char getSexo() {
        comprobarSexo();
        return sexo;
    }
    // Este metodo sirve para que almacene el valor del atributo Sexo
    public void setSexo(char sexo) {
        this.sexo = sexo;
    }

    // Este metodo sirve para que devuelva el valor del atributo Peso
    public double getPeso() {
        return peso;
    }
    // Este metodo sirve para que almacene el valor del atributo Peso
    public void setPeso(double peso) {
        this.peso = peso;
    }
    
    // Este metodo sirve para que devuelva el valor del atributo Altura
    public double getAltura() {
        return altura;
    }
    // Este metodo sirve para que almacene el valor del atributo Altura
    public void setAltura(double altura) {
        this.altura = altura;
    }
    
    // Este metodo sirve para que devuelva el valor del atributo IMC
    public double getIMC() {
        IMC = Math.round((peso/(altura*altura)) * 100.0)/100.0; // Lo que hace esto es calcular el IMC y redondearlo a que los decimales solo contengan dos cifras.
        return IMC;
    }
    // Este metodo sirve para que almacene el valor del atributo IMC
    public void setIMC(double IMC) {
        this.IMC = IMC;
    }
    
    // Este metodo lo que hace es comprobar si es mayor de edad
    public String comprobarEdad(){
        if(edad < 18){
            return "No";
        }else{
            return "Si";
        }
    }
    
    // Este metodo lo que hace es indicar si su IMC tiene sobrepeso, peso ideal o peso por debajo de lo normal
    public String indicarPeso(){
        String resultado;
        if(IMC < 20){
            resultado = "peso por debajo de lo normal";
        }else if(IMC > 25){
            resultado = "sobrepeso";
        }else{
            resultado = "peso ideal";
        }
        
        return resultado;
    }
    
    // Este metodo lo que hace es calcular la letra
    public void calcularLetra(){
        int saberLetra = numDNI % 23;
        setLetraDni(letras[saberLetra]);
    }
    
    // Este metodo lo que hace es imprimir el sexo correspondiente del usuario.
    public String comprobarSexo(){
        if(!(sexo == 'H') && !(sexo == 'M')){
            sexo = 'O';
        }
        
        // Hacemos un switch para devolver el resultado
        switch (sexo) {
            case 'H':
                return "Hombre";
            case 'M':
                return "Mujer";
            case 'O':
                return "Otro";
            default:
                return "Error";
        }
    }
}