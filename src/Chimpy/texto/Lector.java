package Chimpy.texto;

import java.io.File;
import java.io.FileReader;
import javax.swing.JFrame;
import javax.swing.JTextPane;
import java.io.BufferedReader;


public class Lector {
    public void abrirArchivo(JTextPane textArea, JFrame frame) {
        try{
            File archivo = new File("Chimpy.java");
            BufferedReader lector = new BufferedReader(new FileReader(archivo));
            StringBuilder contenido = new StringBuilder();
            String vista;
            while((vista = lector.readLine()) != null){
                contenido.append(vista).append("\n");
            }
            lector.close();
            textArea.setText(contenido.toString());
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public void abrirArchivoJava(JTextPane textArea, JFrame frame) {
        try{
            File archivo = new File("Clase.java");
            BufferedReader lector = new BufferedReader(new FileReader(archivo));
            StringBuilder contenido = new StringBuilder();
            String vista;
            while((vista = lector.readLine()) != null){
                contenido.append(vista).append("\n");
            }
            lector.close();
            textArea.setText(contenido.toString());
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
