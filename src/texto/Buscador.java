package texto;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTextPane;

public class Buscador {

    public void activarResumenParentesis(JTextPane textPane) {
        textPane.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int pos = textPane.getCaretPosition();
                try {
                    String texto = textPane.getText(0, textPane.getDocument().getLength());
                    int inicio = texto.lastIndexOf("(", pos);
                    int fin = texto.indexOf(")", inicio);

                    if (inicio != -1 && fin != -1 && fin > inicio) {
                        String comandoResumen = texto.substring(inicio, fin + 1).trim();

                        if (comandoResumen.matches("^\\([\\w\\s,;:\\-\\.!?]+\\)$")) {
                            TextoResumen motor = new TextoResumen();
                            //motor.sinonimos.put(comandoResumen, texto);
                            System.out.println("Texto válido encontrado: " + comandoResumen);
                        }
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
    }
}