package texto;

import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import javax.swing.JTextPane;
import javax.swing.SwingWorker;

public class BraileTraductor {
    
    public static class TranslationWorker extends SwingWorker<String, Void> {
        private final JTextPane pane;
        
        public TranslationWorker(JTextPane pane) {
            this.pane = pane;
        }
        
        @Override
        protected String doInBackground() throws Exception {
            String texto = pane.getText().toLowerCase();
            HashMap<String, String> palabras = ListaBraile.obtenerPalabras();
            
            for (String braile : palabras.keySet()) {
                texto = texto.replace(braile, palabras.get(braile));
            }
            
            generarArchivoBraile(texto, "braile");
            return texto;
        }
        
        @Override
        protected void done() {
            try {
                String translatedText = get();
                pane.setText(translatedText);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        
        private void generarArchivoBraile(String texto, String nombreClase) {
            try (FileWriter fileWriter = new FileWriter(nombreClase + ".txt")) {
                fileWriter.write(texto);
                System.out.println("El archivo " + nombreClase + ".txt se ha generado correctamente.");
            } catch (IOException e) {
                System.out.println("Error al generar el archivo: " + e.getMessage());
            }
        }
    }
    
    public static void traducir(JTextPane pane) {
        new TranslationWorker(pane).execute();
    }
}