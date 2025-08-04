package Chimpy.texto;

import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JTextPane;

public class Escritor {
     
    //private static final String FILE_PATH = "C:/ruta/del/proyecto/index.html";
    
    public static void saveTextToHTML(JTextPane textPane, String FILE_PATH) {
        try (FileWriter writer = new FileWriter(FILE_PATH)) {
            writer.write(textPane.getText());
            System.out.println("HTML guardado en " + FILE_PATH);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
