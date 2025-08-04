package ListMenu;

import java.util.ArrayList;
import javax.swing.BoxLayout;
import javax.swing.JPanel;
import texto.Writer;

public class TextFunctions extends JPanel{
    private final ArrayList<String> elementos = new ArrayList<>();
    private final String[] etiquetas = {"Copiar","Pegar","Cortar","Traducir a braile", "Guardar como txt"};
    private final Writer escritor = new Writer();

    public TextFunctions() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        for(int i = 0; i < etiquetas.length; i++){
            elementos.add(etiquetas[i]);
        }
    }
}
