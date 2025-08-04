package texto;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JTextPane;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;



public class AutoGuardado {
    public void autoGuardar(JTextPane text, File archivo){
    text.getDocument().addDocumentListener(new DocumentListener() {
        @Override
        public void insertUpdate(DocumentEvent e) { new Guardado().saveJavaFile(text, archivo); }
        @Override
        public void removeUpdate(DocumentEvent e) { new Guardado().saveJavaFile(text, archivo); }
        @Override
        public void changedUpdate(DocumentEvent e) { new Guardado().saveJavaFile(text, archivo); }
    });
    }
}

class Guardado{
    public void saveJavaFile(JTextPane text, File archivo) {
        try (FileWriter writer = new FileWriter(archivo)) {
            writer.write(text.getText());
            System.out.println("Archivo guardado");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}