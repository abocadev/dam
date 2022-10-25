
package boca.dev.Objects;

import java.util.ArrayList;

public class Coches {

    public static ArrayList<CocheObject> coches = new ArrayList<>();
    
    public static void CreateCars(){
        
        // El Audi A5
        coches.add(new CocheObject( 
                "Audi", // Marca del coche
                "A5", // Modelo del Coche
                180, // Velocidad Maxima
                "Gris Claro", // Color del coche
                2004, // Year del coche
                "Gasolina", // Tipo de motor
                2019, // puertas
                "Automatico", // Tipo de marchas
                "El Audi A5 es un automovil del segmento D producido por el fabricante aleman Audi desde el año 2007. El rango del A5 comprende un cupé, un cabriolet y una versión de 'SportBack' (un cuatro puertas con un techo que asemeja al de un fastback con una inclinación de la ventana trasera muy pronunciada y tapa del maletero integrada) de los modelos Audi A4 sedán y familiar", // Descripcion
                "AudiA5Exterior.jpg", // Ruta imagen Coche Fuera
                "AudiA5Interior.jpg" // Ruta imagen Coche Dentro
        ));
        
        // El Dacia Sandero
        coches.add(new CocheObject(
                "Dacia", // Marca del coche
                "Sandero", // Modelo del Coche
                170, // Velocidad Maxima
                "Azul", // Color del coche
                2021, // Year del coche
                "Gasolina", // Tipo de motor
                5, // Numero de puertas
                "Manual: 5 marchas", // Tipo de marchas
                "Dacia Sandero (tambien denominado Renault Sandero) es un automovil de turismo del segmento B diseñado por el fabricante francés Renault junto su filial rumana Dacia. Fue puesto a la venta desde principios de marzo de 2007 en Brasil, y a lo largo de ese año se fue ofreciendo en otras partes del mundo, bajo las marcas Renault y Dacia.", // Descripcion
                "DaciaSanderoExterior.jpg", // Ruta imagen Coche Fuera
                "DaciaSanderoInterior.jpg" // Ruta imagen Coche Dentro
        ));
        
        // La Ford Tansit
        coches.add(new CocheObject(
                "Ford", // Marca del Coche
                "Transit", // Modelo del Coche
                175, // Velocidad Maxima del Coche
                "Blanco", // Color del coche
                2004,
                "Electrico", // Tipo de motor
                4, // Numeo de puertas,
                "Automatico", // Tipo de marchas
                "Ford Transit es un modelo de vehiculo comercial ligero producido por Ford Motor Company en Europa y en el Cono Sur desde 1953. La variante furgon mediana de la Transit disponible tanto en Vehiculo comercial como turismo es denominada como Ford Transit Custom o como Ford Tourneo Custom.", // Descripcion del vehiculo
                "FordTransitExterior.jpg", // Ruta imagen Coche Fuera
                "FordTransitInterior.jpg" // Ruta imagen Coche Dentro
        ));
        
        // Renualt Captur
        coches.add(new CocheObject(
                "Renault",
                "Captur",
                168,
                "Naranja",
                2020,
                "Hibrido enchufable",
                4,
                "Automatico",
                "El Renault Captur es un automovil todocamino del segmento B que el fabricante frances Renault comenzo a comercializar en el año 2013. Tiene motor delantero transversal, tracción delantera y carrocería de cinco puertas.",
                "RenaultCapturExterior.jpg",
                "RenaultCapturInterior.jpg"
        ));
    }
}
