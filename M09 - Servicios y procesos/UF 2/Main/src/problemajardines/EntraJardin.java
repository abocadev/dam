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
public class EntraJardin extends Thread
{
//clase derivada de Thread que define un hilo
    private RecursoJardin jardin;
    
    public EntraJardin(String nombre, RecursoJardin j)
    {
        this.setName(nombre);
        this.jardin = j;
    }

  
    
    @Override
    public void run()
    {
        jardin.incrementaCuenta();
        //invoca al método que incrementa la cuenta de accesos al jardín
    }
}