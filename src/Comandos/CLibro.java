package Comandos;

import Instancia.AbrirInstancia;
import Recursos.BibleMp3;
import Recursos.Sketch;
import Recursos.Search;
import Recursos.Converter;
import Recursos.Dictionary;
import Recursos.Tools;
import Recursos.Book;
import Recursos.Maps;
import Recursos.News;
import Recursos.Agend;
import Recursos.Commentary;
import Recursos.Notes;
import Recursos.Images;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.HashMap;
import javax.swing.JFrame;

public class CLibro {

    // Mapa de comandos
    private static final HashMap<Integer, Runnable> keyBindings = new HashMap<>();

    static {
        //Teclas
        keyBindings.put(KeyEvent.VK_D, () -> new AbrirInstancia().instancia(new Dictionary()));
        keyBindings.put(KeyEvent.VK_T, () -> new AbrirInstancia().instancia(new Agend()));
        keyBindings.put(KeyEvent.VK_C, () -> new AbrirInstancia().instancia(new Commentary()));
        keyBindings.put(KeyEvent.VK_N, () -> new AbrirInstancia().instancia(new News()));
        keyBindings.put(KeyEvent.VK_V, () -> new AbrirInstancia().instancia(new Converter()));
        keyBindings.put(KeyEvent.VK_S, () -> new AbrirInstancia().instancia(new Sketch()));
        keyBindings.put(KeyEvent.VK_P, () -> new AbrirInstancia().instancia(new Maps()));
        keyBindings.put(KeyEvent.VK_H, () -> new AbrirInstancia().instancia(new Tools()));
        keyBindings.put(KeyEvent.VK_F, () -> new AbrirInstancia().instancia(new BibleMp3()));
        keyBindings.put(KeyEvent.VK_R, () -> new AbrirInstancia().instancia(new Search()));
        keyBindings.put(KeyEvent.VK_I, () -> new AbrirInstancia().instancia(new Images()));
        keyBindings.put(KeyEvent.VK_L, () -> new AbrirInstancia().instancia(new Notes()));
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
                // Verificar Ctrl + Flecha
                else if ((modifiers & KeyEvent.CTRL_DOWN_MASK) == KeyEvent.CTRL_DOWN_MASK) {
                    if (evt.getKeyCode() == KeyEvent.VK_LEFT) {
                        new Book().retrocederCapitulo();
                    } else if (evt.getKeyCode() == KeyEvent.VK_RIGHT) {
                        new Book().avanzarCapitulo();
                    }
                }
            }
        });
    }
}