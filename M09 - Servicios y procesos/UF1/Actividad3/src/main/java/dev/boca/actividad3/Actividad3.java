package dev.boca.actividad3;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;
import javax.swing.JOptionPane;

public class Actividad3 {

    private static final String SECRET_KEY = "1d53fd8eae0943c9";
    private static final String INIT_VECTOR = "9c3e6213f3cc63e8";
    
    public static void main(String[] args) throws Exception {
        String texto = JOptionPane.showInputDialog(null, "INTRODUCE UN TEXTO QUE QUIERAS CIFRAR");
        
        // Encriptar texto
        String textoEncriptado = encriptacion(texto);
        JOptionPane.showMessageDialog(null, "Texto encriptado: " + textoEncriptado);
        
        // Desencriptar texto
        String textoDesencriptado = desencriptacion(textoEncriptado);
        JOptionPane.showMessageDialog(null, "Texto desencriptado: " + textoDesencriptado);
    }
    
    // Metodo para encriptar 
    public static String encriptacion(String texto) throws Exception {
        IvParameterSpec iv = new IvParameterSpec(INIT_VECTOR.getBytes("UTF-8")); // Se crea un objeto IvParameterSpec con el vector de inicializacion definido
        SecretKeySpec keySpec = new SecretKeySpec(SECRET_KEY.getBytes("UTF-8"), "AES"); // Se crea un objeto SecretKeySpec con la clave secreta definida
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING"); // Se obtiene una instancia del crifador utilizando el metodo "getInstance".
        cipher.init(Cipher.ENCRYPT_MODE, keySpec, iv); // Aqui se inicializa el cifrador en modo cifrado con la clave secreta y el vector de inicializacion especificados.
        byte[] encrypted = cipher.doFinal(texto.getBytes()); // Se cifra el texto que devuelve un arreglo de Bytes con el texto cifrado.
        return Base64.getEncoder().encodeToString(encrypted); // Aqui se codifica el arreglo de bytes y se devuelve como una cadena de caracteres.
    }
    
    // Metodo para desencriptar
    public static String desencriptacion(String encryptedText) throws Exception {
        byte[] initVectorBytes = INIT_VECTOR.getBytes("UTF-8"); // Se obtienen los bytes del vector de inicializacion
        byte[] encryptedTextBytes = Base64.getDecoder().decode(encryptedText); // Se obtienes los bytes del texto cifrado decodificado en Base64
        byte[] secretKeyBytes = SECRET_KEY.getBytes("UTF-8"); // Se obtienen los bytes de la clave secreta en UTF-8

        SecretKeySpec secretKeySpec = new SecretKeySpec(secretKeyBytes, "AES"); // Se crea un objeto SecretKeySpec con la clave secreta
        IvParameterSpec ivParameterSpec = new IvParameterSpec(initVectorBytes); // Se crea un objeto IvParameterSpec con el vector de inicializacion

        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING"); // Se crea un objeto Cypher con el algoritmo de cifrado AES
        cipher.init(Cipher.DECRYPT_MODE, secretKeySpec, ivParameterSpec); // Se inicializa el modo de descifrado con la clave secreta y el vector de incializacion

        byte[] decryptedBytes = cipher.doFinal(encryptedTextBytes); // Descifra el texto cifrado que devuelve un arreglo de bytes.
        return new String(decryptedBytes); // Se convierte el arreglo de bytes descifrado en una cadena de caracteres.
    }

}
