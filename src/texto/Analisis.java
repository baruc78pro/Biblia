package texto;

import javax.swing.JLabel;
import javax.swing.JTextPane;

public class Analisis {
    
    public static int contadorPalabras(JTextPane pane) {
        String texto = pane.getText().trim();
        if (texto.isEmpty()) return 0;
        String[] palabras = texto.split("\\s+");
        return palabras.length;
    }

    public static int contadorCaracter(JTextPane pane) {
        return pane.getText().trim().length();
    }

    public static int contadorLineas(JTextPane pane) {
        String texto = pane.getText().trim();
        if (texto.isEmpty()) return 0;
        String[] lineas = texto.split("\\r?\\n");
        return lineas.length;
    }

    public static int contadorParrafo(JTextPane pane) {
        String texto = pane.getText().trim();
        if (texto.isEmpty()) return 0;
        String[] parrafos = texto.split("\\r?\\n\\s*\\r?\\n");
        return parrafos.length;
    }
    
    public static int contadorTab(JTextPane pane) {
        String texto = pane.getText().trim();
        if (texto.isEmpty()) return 0;
        String[] parrafos = texto.split("\\t");
        return parrafos.length;
    }
    
    public void imprimir(JTextPane texto, JLabel label1, JLabel label2, JLabel label3, JLabel label4){
        label1.setText("Total de palabras: " + contadorPalabras(texto));
        label2.setText("Total de caracterers: " + contadorCaracter(texto));
        label3.setText("Total de lineas: " + contadorLineas(texto));
        label4.setText("Total de parrafos: " + contadorParrafo(texto));
    }
}