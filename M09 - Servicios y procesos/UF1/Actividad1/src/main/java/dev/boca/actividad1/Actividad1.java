package dev.boca.actividad1;

import java.util.regex.*;

public class Actividad1 {

    public static void main(String[] args) {
        // Comprobar numero negativo
        Pattern numero = Pattern.compile("-45");
        Matcher comprobarNegativo = numero.matcher("^-\\d+$");
        System.out.println("El numero es negativo: " + comprobarNegativo.matches());

        // Comprobar DNI
        Pattern dni = Pattern.compile("48454948M");
        Matcher comprobarDNI = dni.matcher("^\\d{8}[A-Za-z]$");
        System.out.println("El numero es valido: " + comprobarDNI.matches());

        // Comprobar ISBN13
        Pattern isbn = Pattern.compile("978945945641");
        Matcher comprobarISBN = isbn.matcher("^(978|979)[- ]?\\d{1,5}[- ]?\\d{1,7}[- ]?\\d{1,6}[- ]?\\d$");
        System.out.println("El ISBN es valido: " + comprobarISBN.matches());

        // Comprobar fecha
        Pattern date = Pattern.compile("14/11/1991");
        Matcher comprobarDATE = date.matcher("^\\d{2}/\\d{2}/\\d{4}$");
        System.out.println("El fecha es valida: " + comprobarDATE.matches());

        // Comprobar nombre
        Pattern nombre = Pattern.compile("Jose");
        Matcher comprobarNombre = nombre.matcher("^[A-Za-z ]+$");
        System.out.println("El nombre es valido: " + comprobarNombre.matches());
    }
}
