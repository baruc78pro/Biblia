package texto;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.JTextPane;


public class TextoResumen {
    
    public Map<String, List<String>> sinonimos = new HashMap<>();
    /*public void instruction(String comando, JTextPane pane) {
    if (comando.startsWith("insertar:")) {
        String[] partes = comando.split(":");
        if (partes.length == 4) {
            String libro = partes[1];
            String archivo = partes[2];
            String versiculo = partes[3];

            // Validación adicional
            if (libro.isEmpty() || archivo.isEmpty() || !versiculo.matches("\\d+")) {
                return;
            }

            String ruta = "/Recursos/Biblia_en_texto/" + libro + "/" + archivo + ".txt";
            String resultado = search(ruta, versiculo);

            if (!resultado.equals("Versículo no encontrado.")) {
                try {
                    int caret = pane.getCaretPosition();
                    String texto = pane.getText(0, pane.getDocument().getLength());
                    int inicio = texto.lastIndexOf(comando, caret);
                    
                    // Verificar que el clic fue en la línea del comando
                    int finLinea = texto.indexOf("\n", inicio);
                    if (finLinea == -1) finLinea = texto.length();
                    
                    if (caret >= inicio && caret <= finLinea) {
                        pane.getDocument().remove(inicio, comando.length());
                        pane.getDocument().insertString(inicio, resultado + "\n", null);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}


    public String search(String rutaRelativa, String versiculo) {
        try (InputStream is = getClass().getResourceAsStream(rutaRelativa);
            BufferedReader reader = new BufferedReader(new InputStreamReader(is))) {

            return reader.lines()
                .filter(line -> line.startsWith(versiculo + " "))
                .findFirst()
                .orElse("Versículo no encontrado.");

        } catch (IOException | NullPointerException e) {
            return "Error al buscar: " + e.getMessage();
        }
    }*/
}
