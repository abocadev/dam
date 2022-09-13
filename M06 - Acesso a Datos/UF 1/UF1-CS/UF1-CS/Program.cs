using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;

namespace UF1_CS
{
    class Program
    {
        static void Main(string[] args)
        {
            // P1. Gestion del sistema de archivos
            DirectoryInfo directoryInfo = new DirectoryInfo("C:\\"); // Tambien lo podriamos poner de la siguiente manera:
            // DirectoryInfo directoryInfo = new DirectoryInfo(@"C:\");

            var directorios = directoryInfo.GetDirectories().ToList();

            foreach (DirectoryInfo carpetaHija in directoryInfo.GetDirectories().OrderBy(x => x.Name.StartsWith("a")))
            {
                Console.WriteLine(carpetaHija);
            }

            Console.WriteLine("\r\n");
            Console.WriteLine("Archivos");

            foreach (var archivo in directoryInfo.GetFiles().OrderBy(x => x.Name))
            {
                Console.WriteLine(archivo.Name);
            }


            // P2. Gestion del contenido de los ficheros
            // Ejemplo 1: Lee el archivo y lo duplica
            var contenido = File.ReadAllText("C:\\Lorem.txt");

            contenido += contenido;
            // File.WriteAllText("C:\\duplicate.txt", contenido);

            // Ejemplo 2: Lee el archivo y pone una linea en mayuscula y otras no
            var lineas = File.ReadAllLines(@"C:\Lorem.txt");
            Boolean minusculas = false;
            string nuevoContenido = "";
            foreach (var linea in lineas)
            {
                // Se puede hacer esto:
                /*
                if (minusculas)
                {
                    nuevoContenido += linea.ToLower();
                }
                else
                {
                    nuevoContenido += linea.ToUpper();
                }
                */

                // O tambien se puede hacer lo siguiente:
                nuevoContenido += minusculas ? linea.ToLower() : linea.ToUpper();
                minusculas = !minusculas;
            }
            File.WriteAllText("C:\\Users\\Alumno\\Desktop\\duplicateMayusMinus.txt", nuevoContenido);


            // P3. Persistencia de objeto en arhchivos
            List<Cliente> clientes = new List<Cliente>();
            Cliente cliente = new()
            {
                Id = 1,
                Nombre = "Aitor Tilla",
                Direccion = "Su casa",
                FechaNacimiento = "Hoy",
                Activo = false
            };

            clientes.Add(cliente);

            cliente = new Cliente()
            {
                Id = 2,
                Nombre = "Susana acabado las xuxes",
                Direccion = "Xuxeria",
                FechaNacimiento = "Ayer",
                Activo = true
            };

            clientes.Add(cliente);

            var json = Newtonsoft.Json.JsonConvert.SerializeObject(clientes);
            File.WriteAllText("C:\\Users\\Alumno\\Desktop\\Cliente1.json", json);
        }
    }
}