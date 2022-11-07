/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package problemajardines;

public class Main
{
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        RecursoJardin jardin = new RecursoJardin();
        //crea un objeto RecursoJard�n
        for (int i = 1; i <= 40; i++)
        {
            (new EntraJardin("Entra" + i, jardin)).start();
        }//entrada de 10 hilos al jardín
        
        for (int i = 1; i <= 100; i++)
        {
            (new SaleJardin("Sale" + i, jardin)).start();
        }//salida de 15 hilos al jardín
    }
}