package boca.dev.Events;

import boca.dev.Objects.Coches;
import boca.dev.Objects.Tablas;
import boca.dev.Screens.PantallaContract;
import boca.dev.Screens.PantallaFeatures;
import boca.dev.Screens.PantallaInicio;
import java.awt.event.MouseAdapter;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
public class EventosPantallaPrincipal {
    
    public EventosPantallaPrincipal() {} // Constructor vacio
    // Apartado de controlar el evento de los Botones    
    public static MouseListener AddButton() { // Eventos para el boton de Leer
        MouseListener l  = new MouseListener() {
            @Override public void mouseClicked(MouseEvent e) {
                
                // Obtenemos los datos de las cajas de texto
                String nombre = PantallaInicio.iNombre.getText();
                String modelo = PantallaInicio.iModelo.getText();
                String marca = PantallaInicio.iMarca.getText();
                float precio = Float.parseFloat(PantallaInicio.iPrecio.getText());
                String color = PantallaInicio.iColor.getText();
                int indexGasolina = PantallaInicio.jCBGasolina.getSelectedIndex();

                // Mostramos un error, por si no han puesto nada
                if(nombre.equalsIgnoreCase("")) JOptionPane.showMessageDialog(null, "NO HAS PUESTO NINGUN NOMBRE");
                else if(modelo.equalsIgnoreCase("")) JOptionPane.showMessageDialog(null, "NO HAS PUESTO NINGUN MODELO");
                else if(marca.equalsIgnoreCase("")) JOptionPane.showMessageDialog(null, "NO HAS PUESTO NINGUNA MARCA");
                else if(precio <= 0) JOptionPane.showMessageDialog(null, "EL PRECIO QUE HAS PUESTO TIENE QUE SER SUPERIOR A 0");
                else if(color.equalsIgnoreCase("")) JOptionPane.showMessageDialog(null, "NO HAS PUESTO NINGUN COLOR");
                else if (indexGasolina == 0) JOptionPane.showMessageDialog(null, "NO HAS SELECCIONADO NINGUN TIPO DE GASOLINA");
                else {
                    // Seleccionamos que gasolina ha escogido
                    String gas = "";
                    switch (indexGasolina) {
                        case 1 -> gas = "Diesel";
                        case 2 -> gas = "Gasolina";
                        case 3 -> gas = "Hibrido";
                        case 4 -> gas = "Hibrido enchufable";
                        case 5 -> gas = "Electrico";
                    }
                    if(comprobarCocheRepetido(nombre, modelo, marca, precio, color, gas)){ // Comprueba si esos datos ya estan en la tabla de coches nuevos o no
                        JOptionPane.showMessageDialog(null, "EL COCHE QUE QUIERES AÑADIR YA ESTA EN LA TABLA");
                    }else{
                        // Añade los datos a la Tabla de Coches Nuevos
                        DefaultTableModel model = (DefaultTableModel) PantallaInicio.TablaNuevosCoches.getModel();
                        model.addRow(new Object[]{nombre,modelo,marca,precio,color,gas});
                        
                        new Tablas().RowsTablaNuevosCoches(); // Sobreescribe el fichero de TablaNuevosCoches.json 
                        
                        // Se vuelven a poner las fuentes como estaban por defecto
                        PantallaInicio.iNombre.setText("");
                        PantallaInicio.iPrecio.setText("0");
                        PantallaInicio.iModelo.setText("");
                        PantallaInicio.iColor.setText("");
                        PantallaInicio.iMarca.setText("");
                        PantallaInicio.jCBGasolina.setSelectedIndex(0);
                    }
                }
            }

            @Override public void mousePressed(MouseEvent e) {}
            @Override public void mouseReleased(MouseEvent e) {}
            @Override public void mouseEntered(MouseEvent e) {}
            @Override public void mouseExited(MouseEvent e) {}

        };
        return l;
    }
    public static MouseListener ReadButton() {
        MouseListener l = new MouseListener() {
            @Override public void mouseClicked(MouseEvent e) {
                try {
                    
                    // Lo que hago es obtener los valores de la tabla de nuevos coches  
                    int punteroTabla = PantallaInicio.TablaNuevosCoches.getSelectedRow();
                    String nombre = (String) PantallaInicio.TablaNuevosCoches.getValueAt(punteroTabla, 0);
                    String modelo = (String) PantallaInicio.TablaNuevosCoches.getValueAt(punteroTabla, 1);
                    String marca = (String) PantallaInicio.TablaNuevosCoches.getValueAt(punteroTabla, 2);
                    float precio = (float) PantallaInicio.TablaNuevosCoches.getValueAt(punteroTabla, 3);
                    String color = (String) PantallaInicio.TablaNuevosCoches.getValueAt(punteroTabla, 4);
                    String gasolina = (String) PantallaInicio.TablaNuevosCoches.getValueAt(punteroTabla, 5);
                    
                    // Añadimos los valores a la tabla de coches
                    DefaultTableModel modelTablaCoches = (DefaultTableModel) PantallaInicio.TablaCoches.getModel();
                    modelTablaCoches.addRow(new Object[]{nombre,modelo,marca,precio,color,gasolina});

                    // Borramos la fila que hemos leido
                    DefaultTableModel modelTablaNuevosCoches = (DefaultTableModel) PantallaInicio.TablaNuevosCoches.getModel();
                    modelTablaNuevosCoches.removeRow(punteroTabla);
                    
                    // Escribimos los ficheros .json
                    new Tablas().RowsTablaCoches();
                    new Tablas().RowsTablaNuevosCoches();
                    
                } catch (Exception exception) {
                    if(PantallaInicio.TablaNuevosCoches.getRowCount() > 0)  JOptionPane.showMessageDialog(null, "No has seleccionado niguna fila"); // Comprobamos si no han seleccionado una fila
                    else JOptionPane.showMessageDialog(null, "No tienes ninguna fila para añadir"); // Comprobamos si tiene filas o no
                }
            }

            @Override public void mousePressed(MouseEvent e) {}
            @Override public void mouseReleased(MouseEvent e) {}
            @Override public void mouseEntered(MouseEvent e) {}
            @Override public void mouseExited(MouseEvent e) {}
        };
        return l;
    }
    
    // Metodo para rellenar los campos automaticamente
    public static MouseListener CompleteButton(){
        MouseListener l = new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                String Modelo = PantallaInicio.iModelo.getText();
                if(Modelo.equalsIgnoreCase("")) JOptionPane.showMessageDialog(null, "TIENES QUE AÑADIR EL MODELO");
                else{
                    // Fragmento para ver si hay algun registro del modelo
                    int posicion = -1;
                    for(int i = 0; i < Coches.coches.size(); i++){
                        String aux = Coches.coches.get(i).getModeloCoche();
                        if(Modelo.equalsIgnoreCase(aux)){ 
                            posicion = i;
                            break;
                        }
                    }
                    
                    if(posicion == -1) JOptionPane.showMessageDialog(null, "NO HAY NINGUNA COINCIDENCIA CON EL MODELO, QUE HAS PUESTO"); // Comprueba si existe o no
                    else{
                        // Obtiene los datos
                        String modelo = Coches.coches.get(posicion).getModeloCoche();
                        String marca = Coches.coches.get(posicion).getMarcaCoche();
                        String color = Coches.coches.get(posicion).getColorCoche();
                        String gasolina = Coches.coches.get(posicion).getTipoMotor();
                        
                        // Rellena los datos
                        PantallaInicio.iModelo.setText(modelo);
                        PantallaInicio.iMarca.setText(marca);
                        PantallaInicio.iColor.setText(color);
                        PantallaInicio.jCBGasolina.setSelectedItem(gasolina);
                    }
                    
                }
            }

            @Override public void mousePressed(MouseEvent e) {}
            @Override public void mouseReleased(MouseEvent e) {}
            @Override public void mouseEntered(MouseEvent e) {}
            @Override public void mouseExited(MouseEvent e) {}
        };
        return l;
    }
    public static MouseListener ContractButton(){
        MouseListener l  = new MouseListener() {
            @Override public void mouseClicked(MouseEvent e) {
                // Obtiene informacion de los campos de la tabla leidos
                String nombre = null, modelo = null, marca = null,  color = null, gasolina = null;
                float precio = 0;
                try {
                    // Obtiene los datos de la tabla
                    int puntero = PantallaInicio.TablaCoches.getSelectedRow();
                    nombre = (String) PantallaInicio.TablaCoches.getValueAt(puntero, 0);
                    modelo = (String) PantallaInicio.TablaCoches.getValueAt(puntero, 1);
                    marca = (String) PantallaInicio.TablaCoches.getValueAt(puntero, 2);
                    precio = (float) PantallaInicio.TablaCoches.getValueAt(puntero, 3);
                    color = (String) PantallaInicio.TablaCoches.getValueAt(puntero, 4);
                    gasolina = (String) PantallaInicio.TablaCoches.getValueAt(puntero, 5);
                } catch (Exception ee) {    
                }
                // Introduce los registros y ejecuta la pantalla de contrato
                PantallaContract.getData( nombre,  modelo,  marca,  color,  gasolina,  precio );
                PantallaContract.start();
            }

            @Override public void mousePressed(MouseEvent e) {}
            @Override public void mouseReleased(MouseEvent e) {}
            @Override public void mouseEntered(MouseEvent e) {}
            @Override public void mouseExited(MouseEvent e) {}
        };
        return l;
    }
    
    public static MouseListener FeaturesButton() {
        MouseListener l = new MouseAdapter() {
          @Override public void mouseClicked(MouseEvent e){
              String modelo = "";
              int puntero;
              try {
                  puntero = PantallaInicio.TablaCoches.getSelectedRow();
                  modelo = (String) PantallaInicio.TablaCoches.getValueAt(puntero, 1);
                  
                  PantallaFeatures pf = new PantallaFeatures();
                  pf.getData(modelo);
                  pf.start();
              } catch (Exception ee) {
              }
          }  
        };
        return l;
    }
    
    public static boolean comprobarCocheRepetido(String nombre, String modelo, String marca, float precio, String color, String gasolina){
        int puntos = 0;
        final int FILAS = PantallaInicio.TablaNuevosCoches.getRowCount();
        final int COLUMNAS = PantallaInicio.TablaNuevosCoches.getColumnCount();
        boolean repetido = false;
        for(int i = 0; i < FILAS; i++){
            String auxNombre = (String) PantallaInicio.TablaNuevosCoches.getValueAt(i, 0);
            String auxModelo = (String) PantallaInicio.TablaNuevosCoches.getValueAt(i, 1);
            String auxMarca = (String) PantallaInicio.TablaNuevosCoches.getValueAt(i, 2);
            float auxPrecio = (float) PantallaInicio.TablaNuevosCoches.getValueAt(i, 3);
            String auxColor = (String) PantallaInicio.TablaNuevosCoches.getValueAt(i, 4);
            String auxGasolina = (String) PantallaInicio.TablaNuevosCoches.getValueAt(i, 5);
            if(auxNombre.equalsIgnoreCase(nombre)) puntos++;
            if(auxModelo.equalsIgnoreCase(modelo)) puntos++;
            if(auxMarca.equalsIgnoreCase(marca)) puntos++;
            if(auxPrecio == precio) puntos++;
            if(auxColor.equalsIgnoreCase(color)) puntos++;
            if(auxGasolina.equalsIgnoreCase(gasolina)) puntos++;
            
            if(puntos == COLUMNAS) repetido = true;
            else puntos = 0;
        }
        return repetido;
    }
}