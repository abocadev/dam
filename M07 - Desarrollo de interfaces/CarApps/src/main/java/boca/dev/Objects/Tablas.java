package boca.dev.Objects;

import boca.dev.Screens.PantallaInicio;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

public class Tablas {
    
    // Metodo que se utiliza al abrir la app, para rellenar las tablas
    public void ExecuteApp(){
        // Almacena los valores en un string
        String jsonRead = "";
        try (BufferedReader br = new BufferedReader(new FileReader("TablaNuevosCoches.json"))){
            String linea;
            while((linea = br.readLine()) != null) jsonRead += linea;
        } catch (Exception e) {
        }
        
        JsonParser parser = new JsonParser();
        JsonArray gsonArr = parser.parse(jsonRead).getAsJsonArray();
        
        // Almacena los valores y los introduce en la tabla
        for(JsonElement obj : gsonArr){
            JsonObject gsonObj = obj.getAsJsonObject();
            
            String nombre = gsonObj.get("nombre").getAsString();
            String modelo = gsonObj.get("modelo").getAsString();
            String marca = gsonObj.get("marca").getAsString();
            String color = gsonObj.get("color").getAsString();
            String gasolina = gsonObj.get("gasolina").getAsString();
            float precio = (float) gsonObj.get("precio").getAsFloat();
            
            DefaultTableModel model = (DefaultTableModel) PantallaInicio.TablaNuevosCoches.getModel();
            model.addRow(new Object[]{nombre, modelo, marca, precio, color, gasolina});
        }
        
        // Almacena los valores en un string
        jsonRead = "";
        
        try (BufferedReader br = new BufferedReader(new FileReader("TablaCoches.json"))){
            String linea;
            while((linea = br.readLine()) != null) jsonRead += linea;
        } catch (Exception e) {
        }
        
        parser = new JsonParser();
        gsonArr = parser.parse(jsonRead).getAsJsonArray();
        
        // Almacena los valores y los introduce en la tabla
        for(JsonElement obj : gsonArr){
            JsonObject gsonObj = obj.getAsJsonObject();
            
            String nombre = gsonObj.get("nombre").getAsString();
            String modelo = gsonObj.get("modelo").getAsString();
            String marca = gsonObj.get("marca").getAsString();
            String color = gsonObj.get("color").getAsString();
            String gasolina = gsonObj.get("gasolina").getAsString();
            float precio = (float) gsonObj.get("precio").getAsFloat();
            
            DefaultTableModel model = (DefaultTableModel) PantallaInicio.TablaCoches.getModel();
            model.addRow(new Object[]{nombre, modelo, marca, precio, color, gasolina});
        }
    }
    
   public void RowsTablaNuevosCoches(){
       
       try (BufferedWriter bw = new BufferedWriter(new FileWriter("TablaNuevosCoches.json"))){
           // Almacenamos todos los datos en un objeto de ArrayList
           Gson gson = new Gson();
           ArrayList<TablaObject> TablaNuevosCoches = new ArrayList<>();
           int punteroTabla = 0;
           while(punteroTabla < PantallaInicio.TablaNuevosCoches.getRowCount()){
                String nombre = (String) PantallaInicio.TablaNuevosCoches.getValueAt(punteroTabla, 0);
                String modelo = (String) PantallaInicio.TablaNuevosCoches.getValueAt(punteroTabla, 1);
                String marca = (String) PantallaInicio.TablaNuevosCoches.getValueAt(punteroTabla, 2);
                float precio = (float) PantallaInicio.TablaNuevosCoches.getValueAt(punteroTabla, 3);
                String color = (String) PantallaInicio.TablaNuevosCoches.getValueAt(punteroTabla, 4);
                String gasolina = (String) PantallaInicio.TablaNuevosCoches.getValueAt(punteroTabla, 5);
                
                TablaNuevosCoches.add(new TablaObject(nombre, modelo, marca, color, gasolina, precio));
                punteroTabla++;
           }
           
           // Escribimos los cambios en el fichero TablaNuevosCoches.json
           String jsonWrite = gson.toJson(TablaNuevosCoches);
           bw.write(jsonWrite);
           System.out.println("El fichero ha sobreescrito correctamente");
           bw.close();
       } catch (Exception e) {
       }
   }
   
   public void RowsTablaCoches(){
       try (BufferedWriter bw = new BufferedWriter(new FileWriter("TablaCoches.json"))){
            // Almacenamos todos los datos en un objeto de ArrayList
            Gson gson = new Gson();
            ArrayList<TablaObject> TablaCoches = new ArrayList<>();
            int punteroTabla = 0;
            while(punteroTabla < PantallaInicio.TablaCoches.getRowCount()){
                 String nombre = (String) PantallaInicio.TablaCoches.getValueAt(punteroTabla, 0);
                 String modelo = (String) PantallaInicio.TablaCoches.getValueAt(punteroTabla, 1);
                 String marca = (String) PantallaInicio.TablaCoches.getValueAt(punteroTabla, 2);
                 float precio = (float) PantallaInicio.TablaCoches.getValueAt(punteroTabla, 3);
                 String color = (String) PantallaInicio.TablaCoches.getValueAt(punteroTabla, 4);
                 String gasolina = (String) PantallaInicio.TablaCoches.getValueAt(punteroTabla, 5);
                 
                 TablaCoches.add(new TablaObject(nombre, modelo, marca, color, gasolina, precio));
                 punteroTabla++;
            }

            // Escribimos los cambios en el fichero TablaNuevosCoches.json
            String jsonWrite = gson.toJson(TablaCoches);
            bw.write(jsonWrite);
            System.out.println("El fichero ha sobreescrito correctamente");
            bw.close();
       } catch (Exception e) {
       }
   }
}
