package Comandos;

import Instancia.AbrirInstancia;
import Recursos.BibleMp3;
import Recursos.Bible;
import Recursos.Sketch;
import Recursos.Search;
import Recursos.Converter;
import Recursos.Dictionary;
import Recursos.Tools;
import Recursos.Maps;
import Recursos.News;
import Recursos.Agend;
import Recursos.Commentary;
import Recursos.Images;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.HashMap;
import javax.swing.JFrame;
import javax.swing.JTextPane;


public class CText {
    // Mapa de comandos
    private static final HashMap<Integer, Runnable> keyBindings = new HashMap<>();
    public JTextPane pane;

    static {
        //Teclas
        keyBindings.put(KeyEvent.VK_B, () -> new AbrirInstancia().instancia(new Bible()));
        keyBindings.put(KeyEvent.VK_D, () -> new AbrirInstancia().instancia(new Dictionary()));
        keyBindings.put(KeyEvent.VK_T, () -> new AbrirInstancia().instancia(new Agend()));
        keyBindings.put(KeyEvent.VK_C, () -> new AbrirInstancia().instancia(new Commentary()));
        keyBindings.put(KeyEvent.VK_N, () -> new AbrirInstancia().instancia(new News()));
        keyBindings.put(KeyEvent.VK_V, () -> new AbrirInstancia().instancia(new Converter()));
        keyBindings.put(KeyEvent.VK_S, () -> new AbrirInstancia().instancia(new Sketch()));
        keyBindings.put(KeyEvent.VK_H, () -> new AbrirInstancia().instancia(new Tools()));
        keyBindings.put(KeyEvent.VK_F, () -> new AbrirInstancia().instancia(new BibleMp3()));
        keyBindings.put(KeyEvent.VK_R, () -> new AbrirInstancia().instancia(new Search()));
        keyBindings.put(KeyEvent.VK_I, () -> new AbrirInstancia().instancia(new Images()));
        keyBindings.put(KeyEvent.VK_L, () -> new AbrirInstancia().instancia(new Maps()));
    }

    public void KeyEvent(JFrame frame) {
        frame.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent evt) {
                int modifiers = evt.getModifiersEx();

                // Verificar Ctrl + Shift
                if ((modifiers & (KeyEvent.CTRL_DOWN_MASK | KeyEvent.SHIFT_DOWN_MASK)) == (KeyEvent.CTRL_DOWN_MASK | KeyEvent.SHIFT_DOWN_MASK)) {
                    // Ejecutar acción
                    Runnable action = keyBindings.get(evt.getKeyCode());
                    if (action != null) {
                        action.run();
                    }
                }
            }
        });
    }
    public void buscador(JTextPane textPane) {
    // Cambiar de CaretListener a MouseListener
    textPane.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            if (e.getClickCount() == 1) { // Solo clic simple
                int pos = textPane.getCaretPosition();
                try {
                    String texto = textPane.getText(0, textPane.getDocument().getLength());
                    int inicio = texto.lastIndexOf("insertar:", pos);
                    
                    if (inicio != -1) {
                        int fin = texto.indexOf("\n", inicio);
                        if (fin == -1) fin = texto.length();
                        
                        String comandoBuscador = texto.substring(inicio, fin).trim();
                        
                        if (comandoBuscador.matches("insertar:\\w+:\\w+:\\d+")) {
                            BibliaEnginer motor = new BibliaEnginer();
                            motor.instruction(comandoBuscador, textPane);
                        }
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        }
    });
}
}
/*Biblia: Ctrl + B
Comentario: Ctrl + C
Convertidor: Ctrl + V (como la tecla de pegar, pero para el convertidor)
Bosquejo: Ctrl + S (por "Sketch" o bosquejo)
Manual: Ctrl + M
Mapas: Ctrl + P (de "Planos" o "Mapas")
Extras: Ctrl + E
Herramientas: Ctrl + H
Diccionario (visor de PDF): Ctrl + D
Compendio: Ctrl + Q (es una letra poco común, pero siempre está disponible)
Noticias: Ctrl + N
Acerca de: Ctrl + A
Biblia en audio: Ctrl + F (de "Audio" o "Fono")
Buscador de versículos: Ctrl + R (de "Research" o "Buscar")
Visor de imágenes: Ctrl + I*/