package texto;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import javax.swing.JTextPane;

/**
 *
 * @author Malware Inc.
 */
public class Functions {
    public void copyText(JTextPane textPane) {
        String textoSeleccionado = textPane.getSelectedText();
        if (textoSeleccionado != null) {
            StringSelection seleccion = new StringSelection(textoSeleccionado);
            Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
            clipboard.setContents(seleccion, null);
        }
    }
    public void cutText(JTextPane textPane) {
        String textoSeleccionado = textPane.getSelectedText();
        if (textoSeleccionado != null) {
            StringSelection seleccion = new StringSelection(textoSeleccionado);
            Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
            clipboard.setContents(seleccion, null);
            textPane.replaceSelection(""); // elimina el texto seleccionado
        }
    }
    public void pasteText(JTextPane textPane) {
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        try {
            if (clipboard.isDataFlavorAvailable(DataFlavor.stringFlavor)) {
                String textoPegado = (String) clipboard.getData(DataFlavor.stringFlavor);
                textPane.replaceSelection(textoPegado); // reemplaza si hay selección o inserta
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
}

}
