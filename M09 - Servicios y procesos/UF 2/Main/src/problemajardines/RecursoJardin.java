/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package problemajardines;

/**
 *
 * @author xavie
 */
public class RecursoJardin
{
    //clase que simula las entradas y las salidas al Jard�n
    private int cuenta; //para contar las entradas y salidas al Jard�n
    
    public RecursoJardin()
    {
        cuenta = 50; //inicalmente hay 50 personas en le jard�n
    }
    
    public void incrementaCuenta()
    {
        //m�todo que increamenta en 1 la varibale cuenta
        System.out.println("hilo " + Thread.currentThread().getName()
                + "----- Entra en Jardín");
        //muestra el hilo que entra en el m�todo
        cuenta++;
        System.out.println(cuenta + " en jardín");
        //cuenta cada acceso al jard�n y muestra el n�mero de accesos
    }
    
   public void  decrementaCuenta()
   {
        //m�todo que decrementa en 1 la varibale cuenta
        System.out.println("hilo " + Thread.currentThread().getName()
                + "----- Sale de Jardín");
        //muestra el hilo que sale en el m�todo
        cuenta--;
        System.out.println(cuenta + " en jardín");
        //cuenta cada acceso al jard�n y muestra el n�mero de accesos
    }
}