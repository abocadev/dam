package boca.dev.Screens;

import boca.dev.Objects.Coches;
import boca.dev.Events.EventosPantallaContract;
import java.awt.*;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;
import javax.swing.*;

public class PantallaContract extends JFrame{

    // Datos cogidos
    public static String nombre, modelo, marca, color, gasolina, contrato, hour;
    static float precio;

    public static JPanel PanelPantallaContrato;
    static JLabel lNombre, lModelo, lMarca, lPrecio, lColor, lGasolina, lFirma, lCoche;
    static JTextField iNombre, iModelo, iMarca, iPrecio, iColor, iGasolina;
    static JButton bDownload;
    static JTextArea tContrato;
    
    public static void start(){
        PantallaContract p = new PantallaContract("Contrato: " + marca + " "+ modelo);
        p.setVisible(true);
    }
    
    public PantallaContract (String s) throws HeadlessException{
        super(s);
        setSize(700, 500);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        CrearComponentes();
    }

    
    public void CrearComponentes(){
        makeContract();
        CrearPanel();
        CrearEtiquetas();
        CrearInputs();
        crearTextArea();
        crearButtons();
        eventos();
    }

    public void CrearPanel(){
        PanelPantallaContrato = new JPanel();
        PanelPantallaContrato.setBackground(Color.gray);
        PanelPantallaContrato.setLayout(null);
        PanelPantallaContrato.setVisible(true);
        this.getContentPane().add(PanelPantallaContrato);
    }

    
    // Creamos las etiquetas de texto
    public void CrearEtiquetas() {
        // Label Nombre
        lNombre = new JLabel("Nombre:");
        lNombre.setBounds(20, 10, 150, 50);
        lNombre.setFont(new Font("Arial", Font.BOLD, 14));
        PanelPantallaContrato.add(lNombre);

        // Label Modelo
        lModelo = new JLabel("Modelo:");
        lModelo.setBounds(20, 50, 150, 50);
        lModelo.setFont(new Font("Arial", Font.BOLD, 14));
        PanelPantallaContrato.add(lModelo);
	
        // Label Marca
        lMarca = new JLabel("Marca:");
        lMarca.setBounds(20, 90, 150, 50);
        lMarca.setFont(new Font("Arial", Font.BOLD, 14));
        PanelPantallaContrato.add(lMarca);

        // Label Precio
        lPrecio = new JLabel("Precio:");
        lPrecio.setBounds(350, 10, 150, 50);
        lPrecio.setFont(new Font("Arial", Font.BOLD, 14));
        PanelPantallaContrato.add(lPrecio);

        // Label color
        lColor = new JLabel("Color:");
        lColor.setBounds(350, 50, 150, 50);
        lColor.setFont(new Font("Arial", Font.BOLD, 14));
        PanelPantallaContrato.add(lColor);

        // Label Gasolina
        lGasolina = new JLabel("Gasolina:");
        lGasolina.setBounds(350, 90, 150, 50);
        lGasolina.setFont(new Font("Tahoma", Font.BOLD, 14));
        PanelPantallaContrato.add(lGasolina);
        
        // Imagen de Firma
        lFirma = new JLabel();
        lFirma.setIcon(new ImageIcon("firma.png"));
        lFirma.setBounds(425, 150, 200, 90);
        PanelPantallaContrato.add(lFirma);
        
        // Imagen del coche exterior
        lCoche = new JLabel();
        int punteroTabla = PantallaInicio.TablaCoches.getSelectedRow();
        String modelo = (String) PantallaInicio.TablaCoches.getValueAt(punteroTabla, 1);
        String ruta = "";
        for(int i = 0; i < Coches.coches.size(); i++){
            String aux = Coches.coches.get(i).getModeloCoche();
            if(aux.equalsIgnoreCase(modelo)) ruta = Coches.coches.get(i).getRutaImagenCocheFuera();
        }
        if(ruta.equals("")) ruta = "ImagenNoDisponible.png";
        lCoche.setIcon(new ImageIcon(ruta));
        lCoche.setBounds(425, 250, 200, 150);
        PanelPantallaContrato.add(lCoche);        
    }
    
    // Creamos las entradasde texto
    public void CrearInputs() {
        // Input Nombre
       iNombre = new JTextField(nombre);
       iNombre.setBounds(85, 25, 200, 20);
       iNombre.setFont(new Font("Arial", Font.BOLD, 14));
       iNombre.setBackground(new Color(245, 245, 245));
       iNombre.setBorder(null);
       iNombre.setEditable(false);
       PanelPantallaContrato.add(iNombre);
       
       // Input Modelo
       iModelo = new JTextField(modelo);
       iModelo.setBounds(85, 65, 200, 20);
       iModelo.setFont(new Font("Arial", Font.BOLD, 14));
       iModelo.setBackground(new Color(245, 245, 245));
       iModelo.setBorder(null);
       iModelo.setEditable(false);
       PanelPantallaContrato.add(iModelo);

       // Input Marca
       iMarca = new JTextField(marca);
       iMarca.setBounds(85, 105, 200, 20);
       iMarca.setFont(new Font("Arial", Font.BOLD, 14));
       iMarca.setBackground(new Color(245, 245, 245));
       iMarca.setBorder(null);
       iMarca.setEditable(false);
       PanelPantallaContrato.add(iMarca);

       // Input Precio
       iPrecio = new JTextField("" + precio + "$");
       iPrecio.setBounds(425, 25, 200, 20);
       iPrecio.setFont(new Font("Arial", Font.BOLD, 14));
       iPrecio.setBackground(new Color(245, 245, 245));
       iPrecio.setBorder(null);
       iPrecio.setEditable(false);
       PanelPantallaContrato.add(iPrecio);

       // Input Color
       iColor = new JTextField(color);
       iColor.setBounds(425, 65, 200, 20);
       iColor.setFont(new Font("Arial", Font.BOLD, 14));
       iColor.setBackground(new Color(245, 245, 245));
       iColor.setBorder(null);
       iColor.setEditable(false);
       PanelPantallaContrato.add(iColor);

       // Input Gasolina
       iGasolina = new JTextField(gasolina);
       iGasolina.setBounds(425, 105, 200, 20);
       iGasolina.setFont(new Font("Arial", Font.BOLD, 14));
       iGasolina.setBackground(new Color(245, 245, 245));
       iGasolina.setBorder(null);
       iGasolina.setEditable(false);
       PanelPantallaContrato.add(iGasolina);
    }
    
    public void crearTextArea(){
        tContrato = new JTextArea();
        tContrato.setText(contrato);
        tContrato.setEditable(false);
        tContrato.setLineWrap(true);
        JScrollPane jScrollPane = new JScrollPane(tContrato);
        jScrollPane.setBounds(20, 150, 350, 200);
        PanelPantallaContrato.add(jScrollPane);
    }

    public void crearButtons(){
        bDownload = new JButton("Descargar Documento");
        bDownload.setBounds(20, 350, 250, 40);
        bDownload.setFont(new Font("Arial", Font.BOLD, 14));
        bDownload.setForeground(Color.WHITE);
        bDownload.setBackground(new Color(46, 46, 46));
        PanelPantallaContrato.add(bDownload);
    }
 
    public void eventos(){
        bDownload.addMouseListener(EventosPantallaContract.DownloadFile());
    }
    
    public static void getData(String nombre, String modelo, String marca, String color, String gasolina, float precio){
        PantallaContract.nombre = nombre;
        PantallaContract.modelo = modelo;
        PantallaContract.marca = marca;
        PantallaContract.color = color;
        PantallaContract.gasolina = gasolina;
        PantallaContract.precio = precio;
    }    
    
    public void makeContract(){
        Date date = new Date();
        
        ZoneId timeZone = ZoneId.systemDefault();
        ZonedDateTime getLocalDate = date.toInstant().atZone(timeZone);
        
        String dayName = "", monthName = "";
        int dayNum = getLocalDate.getDayOfMonth(),  monthNum = getLocalDate.getMonthValue(), yearNum = getLocalDate.getYear();
        hour = getLocalDate.getHour() + ":" + getLocalDate.getMinute() + ":" + getLocalDate.getSecond();
        String dayOfWeek = getLocalDate.getDayOfWeek().toString();
        
        switch(dayOfWeek){
            case "MONDAY" -> dayName = "Lunes";
            case "TUESDAY" -> dayName = "Martes";
            case "WEDNESDAY" -> dayName = "Miercoles";
            case "THURSDAY" -> dayName = "Jueves";
            case "FRIDAY" -> dayName = "Viernes";
            case "SATURDAY" -> dayName = "Sabado";
            case "SUNDAY" -> dayName = "Domingo";
        }
        
        
        contrato = "CONTRATO DE COMPRAVENTA DE UN VEHICULO:\n\n"
                
                + "En Barcelona " + dayName + ", " + dayNum + " de " + monthName + " de " + yearNum + "     HORA: " + hour
                
                + "VENDEDOR: Albert Bocanegra Barreiro, con NIF 12345678A, y domicilio en Hospitalet de Llobregat, Av. de Josep Tarradellas i Joan, 171.\n"
                + "COMPRADOR: " + nombre + "con NIF 98765432Z, y domicilio en Barcelona, Carrer de Llança, 51.\n\n"
                
                + "Vehiculo:\n"
                + "MARCA: " + marca + "\n"
                + "Matricula: 0789GSC\n"
                + "Kilometros: 170.000 km\n\n"
                
                + "Reunidos vendedor y comprador en la fecha del encabezamiento , manifestan haber acordado formalizar en este documento CONTRATO DE COMPRAVENTA del vehiculo automovil que se especifica, en las siguientes:\n\n"
                + "CONDICIONES\n"
                + "1) El vendedor vende al comprador el vehiculo de su propiedad anteriormente especificado por la cantidad de " + precio + " euros, sin incluir los impuestos correspondientes. que seran a cargo del comnprador.\n"
                + "2) El vendedor declara que no pesa sobre el vehiculo ninguna carga o gravamen ni impuesto, deduda o sancion pendientes de abono en la fecha de la firma de este contrato, comprometiendose en caso contrario a regularizar tal situacion a su exclusivo cargo.\n"
                + "3) El vendedor se compromete a facilitar los distintos documentos relativos al vehiculo, asi como a firmar cuantos documentos aparte de este sean necesarios para que el vehiculo quede correctamente inscrito a nombre del comprador en los correspondientes organismos publicos, siendo todos los gastos a cargo del comprador.\n"
                + "4) Una vez realizada la correspondencia transferencia en Trafico, el vendedor entregara materialmente al comprador  la posesion  del vehiculo, haciendose el comprador cargo de cuantas responsabilidades puedan contraerse por la propiedad del vehiculo y su tenencia y uso a partir de dicho momento de la entrega.\n"
                + "5) El vehiculo dispone de seguro en vigor hasta fecha de " + dayNum +"/" + monthNum + "/" + (yearNum+1) + " y se encuentra al corriente respecto a las obligaciones derivadas de la ITV (Inspeccion Tecnica de Vehiculos).\n"
                + "6) El comprador declara conocer e estado actual del vehiculo, por lo que exime al vendedor de garantia por vicios o defectos que surjan con posterioridad a la entrega, salvo aquellos ocultos que tengan su origen en dolo o mala fe del vendedor.\n"
                + "7) Para cualquier litigio que surja entre las partes de la interpretacion o cumplimiento del presente contrato, estas, con expresa renuncia al fuero que pudiera corresponderles, se someteran a los Juzgados y Tribunales de Barcelona.\n";
    }
}