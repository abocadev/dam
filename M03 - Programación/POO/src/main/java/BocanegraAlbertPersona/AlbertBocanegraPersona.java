package BocanegraAlbertPersona;
public class AlbertBocanegraPersona {
    // arrray de caracteres para la letra del dni
    char letras[] = {'T', 'R', 'W', 'A', 'G', 'M', 'Y', 'F', 'P', 'D', 'X', 'B', 'N', 'J', 'Z', 'S', 'Q', 'V', 'H', 'L', 'C', 'K', 'E'};
    
    private String name;
    private int edad;
    private int numDNI;
    private char letraDni;
    private char sexo = 'O'; // H: Hombre | M: Mujer | O: Otro (opcion por defecto)
    private double peso;
    private double altura;

    public AlbertBocanegraPersona(String name, int edad, int numDNI, char sexo, double peso, double altura) {
        this.name = name;
        this.edad = edad;
        this.numDNI = numDNI;
        this.sexo = sexo;
        this.peso = peso;
        this.altura = altura;
    }
    
    public AlbertBocanegraPersona(){
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public int getNumDNI() {
        return numDNI;
    }

    public void setNumDNI(int numDNI) {
        this.numDNI = numDNI;
    }

    public char getLetraDni() {
        int saberLetra = numDNI % 23;
        setLetraDni(letras[saberLetra]);
        return letraDni;
    }

    public void setLetraDni(char letraDni) {
        this.letraDni = letraDni;
    }

    public char getSexo() {
        return sexo;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }
    
    public int calcularPeso(){
        double calculo = Math.round((peso/(altura*altura)) * 100.0)/100.0;
        System.out.println(calculo);
        int resultado;
        if(calculo < 20){
            resultado = -1;
        }else if(calculo > 25){
            resultado = 1;
        }else{
            resultado = 0;
        }
        
        return resultado;
    }
    
    public boolean comprobarEdad(){
        if(edad < 18){
            return false;
        }else{
            return true;
        }
    }
}
