package texto;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JTextPane;
import javax.swing.filechooser.FileNameExtensionFilter;


public class Reader {
    public void abrirArchivo(JTextPane textArea, JFrame frame) {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileFilter(new FileNameExtensionFilter("TXT Files", "txt"));
        int seleccion = fileChooser.showOpenDialog(frame);
        if (seleccion == JFileChooser.APPROVE_OPTION) {
            try {
                textArea.setText("");
                File archivo = fileChooser.getSelectedFile();
                if (!archivo.getName().toLowerCase().endsWith(".txt")) {
                    archivo = new File(archivo.getAbsolutePath() + ".txt");
                }
                new AutoGuardado().autoGuardar(textArea, archivo);
                frame.setTitle(archivo.getName());
                BufferedReader lector = new BufferedReader(new FileReader(archivo));
                StringBuilder contenido = new StringBuilder();
                String linea;
                while ((linea = lector.readLine()) != null) {
                    contenido.append(linea).append("\n");
                }
                lector.close();
                textArea.setText(contenido.toString());
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
}
