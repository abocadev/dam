package boca.dev.Events;
import boca.dev.Screens.PantallaContrato;
import boca.dev.Screens.PantallaInicio;
import static boca.dev.Screens.PantallaInicio.TablaCoches;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
public class EventosPantallaPrincipal {
    public EventosPantallaPrincipal() {
    }
    // Apartado de controlar el evento de los Botones    
    public static MouseListener AddButton() { // Eventos para el boton de Leer
        MouseListener l;
        l = new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                String nombre = PantallaInicio.iNombre.getText();
                String modelo = PantallaInicio.iModelo.getText();
                String marca = PantallaInicio.iMarca.getText();
                float precio = Float.parseFloat(PantallaInicio.iPrecio.getText());
                String color = PantallaInicio.iColor.getText();
                int indexGasolina = PantallaInicio.jCBGasolina.getSelectedIndex();

                if (indexGasolina == 0) {
                    JOptionPane.showMessageDialog(null, "No has seleccionado tipo de gasolina");
                } else {
                    String gas = "";
                    switch (indexGasolina) {

                        case 1 -> gas = "Diesel";

                        case 2 -> gas = "Gasolina";

                        case 3 -> gas = "Hibrido";

                        case 4 -> gas = "Hibrido enchufable";

                        case 5 -> gas = "Electrico";

                    }
                    DefaultTableModel model = (DefaultTableModel) PantallaInicio.TablaNuevosCoches.getModel();
                    model.addRow(new Object[]{
                            nombre,
                            modelo,
                            marca,
                            precio,
                            color,
                            gas
                    });
                }
            }

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {
            }
        };
        return l;
    }
    public static MouseListener ReadButton() {
        MouseListener l;
        l = new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
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
                    modelTablaCoches.addRow(new Object[]{
                            nombre,
                            modelo,
                            marca,
                            precio,
                            color,
                            gasolina
                    });

                    DefaultTableModel modelTablaNuevosCoches = (DefaultTableModel) PantallaInicio.TablaNuevosCoches.getModel();
                    modelTablaNuevosCoches.removeRow(punteroTabla);
                } catch (Exception exception) {
                    if(PantallaInicio.TablaNuevosCoches.getRowCount() > 0) {
                        JOptionPane.showMessageDialog(null, "No has seleccionado niguna fila");
                    }else{
                        JOptionPane.showMessageDialog(null, "No tienes ninguna fila para añadir");
                    }
                }
            }

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {
            }
        };
        return l;
    }
    public static MouseListener ContractButton() {
        MouseListener l;
        l = new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
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
                System.out.println("Nombre: " + nombre
                        + "Modelo: " + modelo
                        + "Marca: " + marca
                        + "Color: " + color
                        + "Gasolina: " + gasolina
                        + "Precio: " + precio);
                PantallaContrato.getData( nombre,  modelo,  marca,  color,  gasolina,  precio );
                PantallaContrato.start();
            }

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {
            }
        };
        return l;
    }
    public void FeaturesButton() {
    }
}