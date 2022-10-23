package boca.dev.Events;
import boca.dev.Objects.Coches;
import boca.dev.Screens.PantallaContract;
import boca.dev.Screens.PantallaInicio;
import java.awt.event.MouseAdapter;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
public class EventosPantallaPrincipal {
    public EventosPantallaPrincipal() {
    }
    // Apartado de controlar el evento de los Botones    
    public static MouseListener AddButton() { // Eventos para el boton de Leer
        MouseListener l  = new MouseListener() {
            @Override public void mouseClicked(MouseEvent e) {
                String nombre = PantallaInicio.iNombre.getText();
                String modelo = PantallaInicio.iModelo.getText();
                String marca = PantallaInicio.iMarca.getText();
                float precio = Float.parseFloat(PantallaInicio.iPrecio.getText());
                String color = PantallaInicio.iColor.getText();
                int indexGasolina = PantallaInicio.jCBGasolina.getSelectedIndex();

                if (indexGasolina == 0) JOptionPane.showMessageDialog(null, "No has seleccionado tipo de gasolina");
                else {
                    String gas = "";
                    switch (indexGasolina) {
                        case 1 -> gas = "Diesel";
                        case 2 -> gas = "Gasolina";
                        case 3 -> gas = "Hibrido";
                        case 4 -> gas = "Hibrido enchufable";
                        case 5 -> gas = "Electrico";
                    }
                    DefaultTableModel model = (DefaultTableModel) PantallaInicio.TablaNuevosCoches.getModel();
                    model.addRow(new Object[]{nombre,modelo,marca,precio,color,gas});
                    
                    PantallaInicio.iNombre.setText("");
                    PantallaInicio.iPrecio.setText("");
                    PantallaInicio.iModelo.setText("");
                    PantallaInicio.iColor.setText("");
                    PantallaInicio.iMarca.setText("");
                    PantallaInicio.jCBGasolina.setSelectedIndex(0);
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
                int punteroTabla = 0;
                try {
                    punteroTabla = PantallaInicio.TablaNuevosCoches.getSelectedRow();
                    String nombre = (String) PantallaInicio.TablaNuevosCoches.getValueAt(punteroTabla, 0);
                    String modelo = (String) PantallaInicio.TablaNuevosCoches.getValueAt(punteroTabla, 1);
                    String marca = (String) PantallaInicio.TablaNuevosCoches.getValueAt(punteroTabla, 2);
                    float precio = (float) PantallaInicio.TablaNuevosCoches.getValueAt(punteroTabla, 3);
                    String color = (String) PantallaInicio.TablaNuevosCoches.getValueAt(punteroTabla, 4);
                    String gasolina = (String) PantallaInicio.TablaNuevosCoches.getValueAt(punteroTabla, 5);
                    DefaultTableModel modelTablaCoches = (DefaultTableModel) PantallaInicio.TablaCoches.getModel();
                    modelTablaCoches.addRow(new Object[]{nombre,modelo,marca,precio,color,gasolina});

                    DefaultTableModel modelTablaNuevosCoches = (DefaultTableModel) PantallaInicio.TablaNuevosCoches.getModel();
                    modelTablaNuevosCoches.removeRow(punteroTabla);
                } catch (Exception exception) {
                    if(PantallaInicio.TablaNuevosCoches.getRowCount() > 0)  JOptionPane.showMessageDialog(null, "No has seleccionado niguna fila");
                else JOptionPane.showMessageDialog(null, "No tienes ninguna fila para añadir");
                }
            }

            @Override public void mousePressed(MouseEvent e) {}
            @Override public void mouseReleased(MouseEvent e) {}
            @Override public void mouseEntered(MouseEvent e) {}
            @Override public void mouseExited(MouseEvent e) {}
        };
        return l;
    }
    
    public static MouseListener CompleteButton(){
        MouseListener l = new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                String Modelo = PantallaInicio.iModelo.getText();
                if(Modelo.equalsIgnoreCase("")) JOptionPane.showMessageDialog(null, "TIENES QUE AÑADIR EL MODELO");
                else{
                    int posicion = -1;
                    System.out.println("El modelo puesto es: " + Modelo);
                    for(int i = 0; i < Coches.coches.size(); i++){
                        String aux = Coches.coches.get(i).getModeloCoche();
                        if(Modelo.equalsIgnoreCase(aux)){ 
                            posicion = i;
                            break;
                        }
                    }
                    
                    if(posicion == -1) JOptionPane.showMessageDialog(null, "NO HAY NINGUNA COINCIDENCIA CON EL MODELO, QUE HAS PUESTO");
                    else{
                        String modelo = Coches.coches.get(posicion).getModeloCoche();
                        String marca = Coches.coches.get(posicion).getMarcaCoche();
                        String color = Coches.coches.get(posicion).getColorCoche();
                        String gasolina = Coches.coches.get(posicion).getTipoMotor();
                        
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
                String nombre = null, modelo = null, marca = null,  color = null, gasolina = null;
                float precio = 0;
                int puntero;
                try {
                    puntero = PantallaInicio.TablaCoches.getSelectedRow();
                    nombre = (String) PantallaInicio.TablaCoches.getValueAt(puntero, 0);
                    modelo = (String) PantallaInicio.TablaCoches.getValueAt(puntero, 1);
                    marca = (String) PantallaInicio.TablaCoches.getValueAt(puntero, 2);
                    precio = (float) PantallaInicio.TablaCoches.getValueAt(puntero, 3);
                    color = (String) PantallaInicio.TablaCoches.getValueAt(puntero, 4);
                    gasolina = (String) PantallaInicio.TablaCoches.getValueAt(puntero, 5);
                } catch (Exception ee) {    
                }
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
              
          }  
        };
        return l;
    }
}