package Chimpy.texto;

import static Chimpy.texto.Almacen.invertirMapa;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import javax.swing.JTextPane;

public class Traductor {

    public static String traducirJava(JTextPane pane) {
        String texto = pane.getText();
        HashMap<String, String> palabras = Almacen.obtenerPalabras();
        
        for (String palabraChimpy : palabras.keySet()) {
            texto = texto.replace(palabraChimpy, palabras.get(palabraChimpy));
        }
        generarArchivoJava(texto, "Chimpy");
        return texto;
    }
    
    public static String traducirChimpy(JTextPane pane){
        String texto = pane.getText();
        HashMap<String, String> palabras = invertirMapa(Almacen.obtenerPalabras());

        for (String java : palabras.keySet()) {
            texto = texto.replace(java, palabras.get(java));
        }
        generarArchivoJava(texto, "Clase");
        return texto;
    }

    public static void generarArchivoJava(String texto, String nombreClase) {
        try {
            // Crear el archivo .java
            FileWriter fileWriter = new FileWriter(nombreClase + ".java");
            fileWriter.write(texto);
            fileWriter.close();
            System.out.println("El archivo " + nombreClase + ".java se ha generado correctamente.");
        } catch (IOException e) {
            System.out.println("Error al generar el archivo: " + e.getMessage());
        }
    }
}