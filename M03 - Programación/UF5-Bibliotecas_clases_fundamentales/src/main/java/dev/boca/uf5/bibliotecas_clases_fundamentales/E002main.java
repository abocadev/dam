package dev.boca.uf5.bibliotecas_clases_fundamentales;

public class E002main {
    public static void main(String[] args) {
        E002titulo ventana = new E002titulo("Titulo Molon");
        
        ventana.setVisible(true);
        
        E002titulo ventanaProceso = new E002titulo("Este es el identificador de mi proceso actual: " + getPID());
    }
    
    public static String getPID(){
        return java.lang.management.ManagementFactory.getRuntimeMXBean().getName();
    }
}
