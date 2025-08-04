package Dialogo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TooltipHelper {

    public static void applyTooltips(JTextPane textPane) {
        textPane.addMouseMotionListener(new MouseMotionAdapter() {
            public void mouseMoved(MouseEvent e) {
                String word = getWordAtPosition(textPane, e.getPoint());
                textPane.setToolTipText(getTooltipForWord(word));
            }
        });
    }

    // Método que devuelve el tooltip según la palabra clave
    private static String getTooltipForWord(String word) {
        switch (word) {
            case "Dios":
                return "Creador | Sin principio ni final | No regido bajo las leyes físicas";
            case "Génesis":
                return "Comienzo de";
            case "Pecado":
                return "Herrar el blanco";
            case "Tooltip":
                return "Pequeña ventana emergente que muestra información al pasar el cursor.";
            default:
                return null;
        }
    }

    // Método para obtener la palabra bajo el mouse
    private static String getWordAtPosition(JTextPane textPane, Point point) {
        try {
            int pos = textPane.viewToModel(point);
            String text = textPane.getText();
            int start = pos;
            int end = pos;

            // Buscar el inicio y fin de la palabra
            while (start > 0 && Character.isLetterOrDigit(text.charAt(start - 1))) {
                start--;
            }
            while (end < text.length() && Character.isLetterOrDigit(text.charAt(end))) {
                end++;
            }

            return text.substring(start, end);
        } catch (Exception ex) {
            return "";
        }
    }
}