package texto;

import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import javax.swing.JTextPane;

/**
 *
 * @author Cooler Master
 */
public class BraileTraductor {
    
    public static String traducir(JTextPane pane) {
        String texto = pane.getText().toLowerCase();
        HashMap<String, String> palabras = ListaBraile.obtenerPalabras();
        
        for (String braile : palabras.keySet()) {
            texto = texto.replace(braile, palabras.get(braile));
        }
        generarArchivoBraile(texto, "braile");
        return texto;
    }
    public static void generarArchivoBraile(String texto, String nombreClase) {
        try {
            FileWriter fileWriter = new FileWriter(nombreClase + ".txt");
            fileWriter.write(texto);
            fileWriter.close();
            System.out.println("El archivo " + nombreClase + ".txt se ha generado correctamente.");
        } catch (IOException e) {
            System.out.println("Error al generar el archivo: " + e.getMessage());
        }
    }
}