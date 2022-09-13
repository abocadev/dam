using System;

namespace EjemploInterface
{
    class Program
    {
        static void Main(string[] args)
        {
            ICalculadora calc = new CalculadoraBuena();

            int resultado = calc.multiplicar(1, 2);

            Console.WriteLine(resultado);
        }
    }
}
