package texto;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JTextPane;
import javax.swing.SwingUtilities;
import javax.swing.SwingWorker;
import javax.swing.filechooser.FileNameExtensionFilter;


public class Reader {
    public static class FileReadWorker extends SwingWorker<String, Void> {
        private final JTextPane textArea;
        private final JFrame frame;
        
        public FileReadWorker(JTextPane textArea, JFrame frame) {
            this.textArea = textArea;
            this.frame = frame;
        }
        
        @Override
        protected String doInBackground() throws Exception {
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setFileFilter(new FileNameExtensionFilter("TXT Files", "txt"));
            
            int seleccion = fileChooser.showOpenDialog(frame);
            if (seleccion != JFileChooser.APPROVE_OPTION) return null;
            
            File archivo = fileChooser.getSelectedFile();
            if (!archivo.getName().toLowerCase().endsWith(".txt")) {
                archivo = new File(archivo.getAbsolutePath() + ".txt");
            }
            
            SwingUtilities.invokeLater(() -> {
                textArea.setText("");
            });
            
            try (BufferedReader lector = new BufferedReader(new FileReader(archivo))) {
                StringBuilder contenido = new StringBuilder();
                String linea;
                while ((linea = lector.readLine()) != null) {
                    contenido.append(linea).append("\n");
                }
                return contenido.toString();
            }
        }
        
        @Override
        protected void done() {
            try {
                String contenido = get();
                if (contenido != null) {
                    textArea.setText(contenido);
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }
    
    public void abrirArchivo(JTextPane textArea, JFrame frame) {
        new FileReadWorker(textArea, frame).execute();
    }
}