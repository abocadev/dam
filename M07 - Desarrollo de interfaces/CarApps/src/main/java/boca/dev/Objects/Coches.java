package boca.dev.Objects;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class Coches {

    public static ArrayList<CocheObject> coches = new ArrayList<>();
    
    public static void CreateCars(){
        try {
            // Lee el archivo coches.json y lo almacena en una variable String
            String linea, json = "";
            
            BufferedReader br = new BufferedReader(new FileReader("coches.json"));
            JsonParser parser = new JsonParser();
            
            while((linea = br.readLine())!= null){
                json += linea;
            }
            
            JsonArray gsonArr = parser.parse(json).getAsJsonArray();
            
            for(JsonElement obj : gsonArr){
                JsonObject gsonObj = obj.getAsJsonObject();
            
                // Obtiene los valores y los añade en un ArrayList de objetos de Coche 
                String MarcaCoche = gsonObj.get("MarcaCoche").getAsString();
                String ModeloCoche = gsonObj.get("ModeloCoche").getAsString();
                String ColorCoche = gsonObj.get("ColorCoche").getAsString();
                String TipoMotor = gsonObj.get("TipoMotor").getAsString();
                String TipoMarchas = gsonObj.get("TipoMarchas").getAsString();
                String DescripcionVehiculo = gsonObj.get("DescripcionVehiculo").getAsString();
                String RutaImagenCocheFuera = gsonObj.get("RutaImagenCocheFuera").getAsString();
                String RutaImagenCocheDentro = gsonObj.get("RutaImagenCocheDentro").getAsString();
                int VelocidadMaxima = gsonObj.get("VelocidadMaxima").getAsInt();
                int YearCoche = gsonObj.get("YearCoche").getAsInt();
                int NumeroPuertas = gsonObj.get("NumeroPuertas").getAsInt();
                
                coches.add(new CocheObject(
                        MarcaCoche, 
                        ModeloCoche, 
                        VelocidadMaxima, 
                        ColorCoche, 
                        YearCoche, 
                        TipoMotor, 
                        NumeroPuertas, 
                        TipoMarchas, 
                        DescripcionVehiculo, 
                        RutaImagenCocheFuera, 
                        RutaImagenCocheDentro));
                
            }
        } catch (Exception e) {
        }
    }
}