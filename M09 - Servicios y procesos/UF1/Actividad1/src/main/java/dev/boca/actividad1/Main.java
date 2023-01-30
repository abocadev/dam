/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dev.boca.actividad1;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author USUARI
 */
public class Main {
    public static void main(String[] args) {
        
        Pattern numero = Pattern.compile("5");
        Matcher comprobarNegativo = numero.matcher("^-\\d+$");
        System.out.println("El numero es negativo: " + comprobarNegativo.matches());
    }
}
