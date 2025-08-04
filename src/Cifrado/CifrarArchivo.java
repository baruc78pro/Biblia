package Cifrado;

import java.util.Scanner;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

/**
 * Clase Cifrado para cifrar y descifrar mensajes utilizando el algoritmo AES.
 */
public class CifrarArchivo {

    // Clave secreta para el cifrado AES
    private SecretKeySpec key;

    /**
     * Constructor de la clase Cifrado.
     *
     * @param llave La llave para el cifrado AES.
     */
    public CifrarArchivo(String llave) {
        // Inicializa la clave secreta utilizando la llave proporcionada y el algoritmo AES
        this.key = new SecretKeySpec(llave.getBytes(), "AES");
    }

    /**
     * Cifra un mensaje utilizando el algoritmo AES.
     *
     * @param mensaje El mensaje a cifrar.
     * @return Un arreglo de bytes que representa el mensaje cifrado.
     * @throws Exception Si ocurre un error durante el cifrado.
     */
    public byte[] cifrar(String mensaje) throws Exception {
        // Obtiene una instancia del cifrador AES y lo inicializa en modo de cifrado
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.ENCRYPT_MODE, key);
        // Cifra el mensaje y devuelve el resultado como un arreglo de bytes
        return cipher.doFinal(mensaje.getBytes());
    }

    /**
     * Descifra un mensaje cifrado utilizando el algoritmo AES.
     *
     * @param campoCifrado El mensaje cifrado en forma de arreglo de bytes.
     * @return El mensaje descifrado como una cadena de caracteres.
     * @throws Exception Si ocurre un error durante el descifrado.
     */
    public String descifrar(byte[] campoCifrado) throws Exception {
        // Obtiene una instancia del cifrador AES y lo inicializa en modo de descifrado
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.DECRYPT_MODE, key);
        // Descifra el mensaje cifrado y devuelve el resultado como una cadena de caracteres
        byte[] campoDecifrado = cipher.doFinal(campoCifrado);
        return new String(campoDecifrado);
    }

    /**
     * Método principal que solicita una llave y un mensaje al usuario para cifrar y descifrar.
     *
     * @param args Los argumentos de la línea de comandos (no se utilizan).
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Solicita al usuario que introduzca una llave para el cifrado AES
        System.out.print("Introduce la llave para el cifrado: ");
        String llave = scanner.nextLine();

        // Ajusta la longitud de la llave a 16 caracteres (128 bits)
        if (llave.length() < 16) {
            while (llave.length() < 16) {
                llave += "0";
            }
        } else if (llave.length() > 16) {
            llave = llave.substring(0, 16);
        }

        try {
            // Crea una instancia de la clase Cifrado con la llave proporcionada
            CifrarArchivo cifrador = new CifrarArchivo(llave);

            // Solicita al usuario que introduzca un mensaje para cifrar
            System.out.print("Introduce el mensaje a cifrar: ");
            String mensaje = scanner.nextLine();

            // Cifra el mensaje y muestra el resultado cifrado
            byte[] campoCifrado = cifrador.cifrar(mensaje);
            System.out.println("Cifrado de tu mensaje: " + new String(campoCifrado));

            // Descifra el mensaje cifrado y muestra el mensaje original
            String mensajeOriginal = cifrador.descifrar(campoCifrado);
            System.out.println("Tu mensaje descifrado: " + mensajeOriginal);
        } catch (Exception e) {
            // Captura y muestra cualquier error que ocurra durante el cifrado o descifrado
            System.out.println("Error al cifrar o descifrar: " + e.getMessage());
            e.printStackTrace();
        } finally {
            // Cierra el objeto Scanner para evitar fugas de recursos
            scanner.close();
        }
    }
}