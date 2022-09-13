using System;
using System.Collections.Generic;
using System.Text;

namespace EjemploInterface
{
    public class CalculadoraMala : ICalculadora
    {
        public int multiplicar(int n1, int n2)
        {
            int valor = 0;
            for(int i = 0; i<(n1 + n2); i++)
            {
                valor++;
            }
            return valor;
        }
    }
}
