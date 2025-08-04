package texto;

import javax.swing.JLabel;
import javax.swing.JTextPane;
import javax.swing.SwingUtilities;
import javax.swing.SwingWorker;

public class Analisis {
    
    public static class AnalysisWorker extends SwingWorker<Void, Void> {
        private final JTextPane pane;
        private final JLabel[] labels;
        
        public AnalysisWorker(JTextPane pane, JLabel... labels) {
            this.pane = pane;
            this.labels = labels;
        }
        
        @Override
        protected Void doInBackground() {
            String text = pane.getText().trim();
            
            // Calcular todos los valores en segundo plano
            int palabras = contadorPalabras(text);
            int caracteres = contadorCaracter(text);
            int lineas = contadorLineas(text);
            int parrafos = contadorParrafo(text);
            
            SwingUtilities.invokeLater(() -> {
                labels[0].setText("Total de palabras: " + palabras);
                labels[1].setText("Total de caracteres: " + caracteres);
                labels[2].setText("Total de lineas: " + lineas);
                labels[3].setText("Total de parrafos: " + parrafos);
            });
            
            return null;
        }
        
        private int contadorPalabras(String texto) {
            if (texto.isEmpty()) return 0;
            return texto.split("\\s+").length;
        }

        private int contadorCaracter(String texto) {
            return texto.length();
        }

        private int contadorLineas(String texto) {
            if (texto.isEmpty()) return 0;
            return texto.split("\\r?\\n").length;
        }

        private int contadorParrafo(String texto) {
            if (texto.isEmpty()) return 0;
            return texto.split("\\r?\\n\\s*\\r?\\n").length;
        }
    }
    
    public void imprimir(JTextPane texto, JLabel... labels) {
        new AnalysisWorker(texto, labels).execute();
    }
}