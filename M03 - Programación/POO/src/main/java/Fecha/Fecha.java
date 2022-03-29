package Fecha;

import java.time.LocalDate;

public class Fecha {
    private int mes;
    private int dia;
    private int year;
    
    public boolean ComprobarFecha(){
        if(dia == LocalDate.now().getDayOfMonth() && mes == LocalDate.now().getMonthValue() && year == LocalDate.now().getYear()){
            return true;
        }else{
            return false;
        }
    }
    
    public void DiaSiguiente(){
        if(dia != LocalDate.now().getDayOfMonth()){
            dia = LocalDate.now().getDayOfMonth();
        }
        
        if(mes != LocalDate.now().getMonthValue()){
            mes = LocalDate.now().getMonthValue();
        }
        
        if(year != LocalDate.now().getYear()){
            year = LocalDate.now().getYear();
        }
    }

    public Fecha(int mes, int dia, int anyo) {
        this.dia = dia;
        this.mes = mes;
        this.year = anyo;
    }
    
    public Fecha(){
        // Esto es un constructor vacio
    }

    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return getDia() + "-" + getMes() + "-" + getYear();
    }    
}
