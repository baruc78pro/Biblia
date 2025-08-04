package texto;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import javax.swing.JTextPane;
import javax.swing.SwingUtilities;
import javax.swing.SwingWorker;

/**
 *
 * @author Malware Inc.
 */
public class Functions {
    public void copyText(JTextPane textPane) {
        new ClipboardWorker("COPY", textPane).execute();
    }
    
    public void cutText(JTextPane textPane) {
        new ClipboardWorker("CUT", textPane).execute();
    }
    
    public void pasteText(JTextPane textPane) {
        new ClipboardWorker("PASTE", textPane).execute();
    }
    
    private static class ClipboardWorker extends SwingWorker<Void, Void> {
        private final String operation;
        private final JTextPane textPane;
        
        public ClipboardWorker(String operation, JTextPane textPane) {
            this.operation = operation;
            this.textPane = textPane;
        }
        
        @Override
        protected Void doInBackground() {
            Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
            
            switch (operation) {
                case "COPY":
                    String textoSeleccionado = textPane.getSelectedText();
                    if (textoSeleccionado != null) {
                        StringSelection seleccion = new StringSelection(textoSeleccionado);
                        clipboard.setContents(seleccion, null);
                    }
                    break;
                    
                case "CUT":
                    String textoCortar = textPane.getSelectedText();
                    if (textoCortar != null) {
                        StringSelection seleccion = new StringSelection(textoCortar);
                        clipboard.setContents(seleccion, null);
                        SwingUtilities.invokeLater(() -> textPane.replaceSelection(""));
                    }
                    break;
                    
                case "PASTE":
                    try {
                        if (clipboard.isDataFlavorAvailable(DataFlavor.stringFlavor)) {
                            String textoPegado = (String) clipboard.getData(DataFlavor.stringFlavor);
                            SwingUtilities.invokeLater(() -> textPane.replaceSelection(textoPegado));
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;
            }
            return null;
        }
    }
}