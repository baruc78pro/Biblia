package texto;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JTextPane;


public class Writer {
    public void guardarArchivo(JTextPane textArea, JFrame frame) {
        JFileChooser fileChooser = new JFileChooser();
        int seleccion = fileChooser.showSaveDialog(frame);
        if (seleccion == JFileChooser.APPROVE_OPTION) {
            try {
                File archivo = fileChooser.getSelectedFile();
                FileWriter escritor = new FileWriter(archivo + ".txt");
                escritor.write(textArea.getText());
                escritor.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
}