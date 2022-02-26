package example.estructurada;
public class E004tabla2varialbes {
    public static void main(String[] args) {
        System.out.println("Manera facil pero lenta: ");
        int resultado = 0;
        int tabla = 2;
        int multiplicando = 0;
        System.out.println(tabla + " X " + multiplicando + " = " + resultado);
        multiplicando++;
        resultado = tabla * multiplicando;
        System.out.println(tabla + " X " + multiplicando + " = " + resultado);
        multiplicando++;
        resultado = tabla * multiplicando;
        System.out.println(tabla + " X " + multiplicando + " = " + resultado);
        multiplicando++;
        resultado = tabla * multiplicando;
        System.out.println(tabla + " X " + multiplicando + " = " + resultado);
        multiplicando++;
        resultado = tabla * multiplicando;
        System.out.println(tabla + " X " + multiplicando + " = " + resultado);
        multiplicando++;
        resultado = tabla * multiplicando;
        System.out.println(tabla + " X " + multiplicando + " = " + resultado);
        multiplicando++;
        resultado = tabla * multiplicando;
        System.out.println(tabla + " X " + multiplicando + " = " + resultado);
        multiplicando++;
        resultado = tabla * multiplicando;
        System.out.println(tabla + " X " + multiplicando + " = " + resultado);
        multiplicando++;
        resultado = tabla * multiplicando;
        System.out.println(tabla + " X " + multiplicando + " = " + resultado);
        multiplicando++;
        resultado = tabla * multiplicando;
        System.out.println(tabla + " X " + multiplicando + " = " + resultado);
        multiplicando++;
        resultado = tabla * multiplicando;
        System.out.println(tabla + " X " + multiplicando + " = " + resultado);
        
        System.out.println("Manera bucle: ");
        
        int resultado1 = 0;
        int tabla1 = 2;
        for(int i = 0; i <= 10; i++){
            resultado1 = tabla1 * i;
            System.out.println(tabla1 + " X " + i + " = " + resultado1);
        }
        
        System.out.println("Multiplicacion bucle while: ");
        
        int resultado2 = 0;
        int tabla2 = 2;
        int i2 = 0;
        while (i2 <= 10){
            resultado2 = tabla2 * i2;
            System.out.println(tabla2 + " X " + i2 + " = " + resultado2);
            i2++;
        }
    }
    
}
