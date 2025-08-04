package texto;

import java.io.File;
import java.io.FileWriter;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JTextPane;
import javax.swing.SwingWorker;


public class Writer {
    public static class FileSaveWorker extends SwingWorker<Void, Void> {
        private final JTextPane textArea;
        private final JFrame frame;
        
        public FileSaveWorker(JTextPane textArea, JFrame frame) {
            this.textArea = textArea;
            this.frame = frame;
        }
        
        @Override
        protected Void doInBackground() throws Exception {
            JFileChooser fileChooser = new JFileChooser();
            int seleccion = fileChooser.showSaveDialog(frame);
            if (seleccion != JFileChooser.APPROVE_OPTION) return null;
            
            File archivo = fileChooser.getSelectedFile();
            if (!archivo.getName().toLowerCase().endsWith(".txt")) {
                archivo = new File(archivo.getAbsolutePath() + ".txt");
            }
            
            try (FileWriter escritor = new FileWriter(archivo)) {
                escritor.write(textArea.getText());
            }
            return null;
        }
        
        @Override
        protected void done() {
            try {
                get();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }
    
    public void guardarArchivo(JTextPane textArea, JFrame frame) {
        new FileSaveWorker(textArea, frame).execute();
    }
}