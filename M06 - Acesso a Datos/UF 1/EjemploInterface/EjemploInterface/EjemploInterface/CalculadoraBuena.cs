using System;
using System.Collections.Generic;
using System.Text;

namespace EjemploInterface
{
    public class CalculadoraBuena : ICalculadora
    {
        public int multiplicar(int n1, int n2)
        {
            int valor = n1 * n2;

            return valor;
        }
    }
}
