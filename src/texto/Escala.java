package texto;

import java.util.ArrayList;
import javax.swing.JTextPane;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyleContext;


public class Escala {
        public void tamText(int size, ArrayList<JTextPane> list) {
        for (int i = 0; i < list.size(); i++) { // Iterar sobre la lista completa
            list.get(i).selectAll();
            StyleContext sc = StyleContext.getDefaultStyleContext();
            javax.swing.text.AttributeSet aset = sc.addAttribute(SimpleAttributeSet.EMPTY, StyleConstants.FontSize, size);
            list.get(i).setCharacterAttributes(aset, false);
        }
    }
}