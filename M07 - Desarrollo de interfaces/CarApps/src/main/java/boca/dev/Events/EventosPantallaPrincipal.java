package boca.dev.Events;
import boca.dev.Screens.PantallaContrato;
import boca.dev.Screens.PantallaPrincipal;

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
                String nombre = PantallaPrincipal.iNombre.getText();
                String modelo = PantallaPrincipal.iModelo.getText();
                String marca = PantallaPrincipal.iMarca.getText();
                float precio = Float.parseFloat(PantallaPrincipal.iPrecio.getText());
                String color = PantallaPrincipal.iColor.getText();
                int indexGasolina = PantallaPrincipal.jCBGasolina.getSelectedIndex();

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
                    DefaultTableModel model = (DefaultTableModel) PantallaPrincipal.TablaNuevosCoches.getModel();
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
                    punteroTabla = PantallaPrincipal.TablaNuevosCoches.getSelectedRow();


                    String nombre = (String) PantallaPrincipal.TablaNuevosCoches.getValueAt(punteroTabla, 0);
                    String modelo = (String) PantallaPrincipal.TablaNuevosCoches.getValueAt(punteroTabla, 1);
                    String marca = (String) PantallaPrincipal.TablaNuevosCoches.getValueAt(punteroTabla, 2);
                    float precio = (float) PantallaPrincipal.TablaNuevosCoches.getValueAt(punteroTabla, 3);
                    String color = (String) PantallaPrincipal.TablaNuevosCoches.getValueAt(punteroTabla, 4);
                    String gasolina = (String) PantallaPrincipal.TablaNuevosCoches.getValueAt(punteroTabla, 5);

                    DefaultTableModel modelTablaCoches = (DefaultTableModel) PantallaPrincipal.TablaCoches.getModel();
                    modelTablaCoches.addRow(new Object[]{
                            nombre,
                            modelo,
                            marca,
                            precio,
                            color,
                            gasolina
                    });

                    DefaultTableModel modelTablaNuevosCoches = (DefaultTableModel) PantallaPrincipal.TablaNuevosCoches.getModel();
                    modelTablaNuevosCoches.removeRow(punteroTabla);
                } catch (Exception exception) {
                    if(PantallaPrincipal.TablaNuevosCoches.getRowCount() > 0) {
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