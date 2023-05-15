package com.mycompany.ejercicio3;

import java.security.*;
import java.util.*;
import javax.crypto.*;

public class EncriptacionRSABocanegraBarreiroAlbert {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        
        // Generar un par de claves pública y privada RSA
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
        keyPairGenerator.initialize(512);
        KeyPair keyPair = keyPairGenerator.generateKeyPair();
        PublicKey publicKey = keyPair.getPublic();
        PrivateKey privateKey = keyPair.getPrivate();

        // Crear un objeto Cipher para encriptar y desencriptar el texto
        Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");

        // Encriptar el texto
        System.out.println("Escribe el texto que quieras encriptar:");
        String texto = sc.nextLine();
        cipher.init(Cipher.ENCRYPT_MODE, publicKey);
        byte[] textoEncriptado = cipher.doFinal(texto.getBytes("UTF-8"));
        String textoEncriptadoBase64 = Base64.getEncoder().encodeToString(textoEncriptado);
        System.out.println("Texto encriptado: " + textoEncriptadoBase64);

        // Desencriptar el texto
        byte[] textoEncriptadoBytes = Base64.getDecoder().decode(textoEncriptadoBase64);
        cipher.init(Cipher.DECRYPT_MODE, privateKey);
        byte[] textoDesencriptadoBytes = cipher.doFinal(textoEncriptadoBytes);
        String textoDesencriptado = new String(textoDesencriptadoBytes, "UTF-8");
        System.out.println("Texto desencriptado: " + textoDesencriptado);
    }
}
