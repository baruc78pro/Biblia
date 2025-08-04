package Comandos;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JTextPane;
import java.util.ArrayList;
import javax.swing.text.BadLocationException;

public class ClipBoard {
    private static ArrayList<String> slots = new ArrayList<>(9); // 9 slots (1-9)
    private JTextPane textPane;

    public ClipBoard() {
        for (int i = 0; i < 9; i++) {
            slots.add("");
        }
    }

    public void configurarAtajos(JTextPane textPane) {
        this.textPane = textPane;

        textPane.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent evt) {
                int keyCode = evt.getKeyCode();
                int slotIndex = -1;
                
                if (keyCode >= KeyEvent.VK_1 && keyCode <= KeyEvent.VK_9) {
                    slotIndex = keyCode - KeyEvent.VK_1;
                } else if (keyCode >= KeyEvent.VK_NUMPAD1 && keyCode <= KeyEvent.VK_NUMPAD9) {
                    slotIndex = keyCode - KeyEvent.VK_NUMPAD1;
                }

                if (slotIndex != -1) {
                    int modifiers = evt.getModifiersEx();
                    boolean ctrl = (modifiers & KeyEvent.CTRL_DOWN_MASK) == KeyEvent.CTRL_DOWN_MASK;
                    boolean alt = (modifiers & KeyEvent.ALT_DOWN_MASK) == KeyEvent.ALT_DOWN_MASK;

                    // Ctrl → guardar
                    if (ctrl) {
                        guardarEnSlot(slotIndex);
                    }

                    // Alt → pegar
                    else if (alt) {
                        pegarDesdeSlot(slotIndex);
                    }
                }
            }
        });
    }

    private void guardarEnSlot(int slotIndex) {
        try {
            String selectedText = getTextoSeleccionado();
            System.out.println("Texto seleccionado: '" + selectedText + "'");
            if (selectedText != null && !selectedText.isEmpty()) {
                slots.set(slotIndex, selectedText);
                System.out.println("Guardado en slot " + (slotIndex + 1) + ": '" + selectedText + "'");
                mostrarSlots();
            } else {
                System.out.println("⚠️ No se seleccionó texto para guardar");
            }
        } catch (BadLocationException e) {
            System.err.println("Error al guardar: " + e.getMessage());
        }
    }

    private void pegarDesdeSlot(int slotIndex) {
        if (!textPane.isFocusOwner()) {
            System.out.println("JTextPane sin foco. No se puede pegar.");
            return;
        }

        String texto = slots.get(slotIndex);
        System.out.println("📋 Slot " + (slotIndex + 1) + ": '" + texto + "'");

        if (!texto.isEmpty()) {
            try {
                int pos = textPane.getCaretPosition();
                textPane.getDocument().insertString(pos, texto, null);
                System.out.println("Texto insertado desde slot " + (slotIndex + 1));
            } catch (Exception e) {
                System.err.println("Error al insertar: " + e.getMessage());
            }
        } else {
            System.out.println("Slot " + (slotIndex + 1) + " está vacío");
        }
    }

    private String getTextoSeleccionado() throws BadLocationException {
        int start = textPane.getSelectionStart();
        int end = textPane.getSelectionEnd();
        return start != end ? textPane.getText(start, end - start) : null;
    }

    public void mostrarSlots() {
        System.out.println("\n📦 ESTADO DE SLOTS:");
        for (int i = 0; i < slots.size(); i++) {
            String contenido = slots.get(i);
            String preview = contenido.length() > 30 ?
                contenido.substring(0, 30) + "..." : contenido;
            System.out.printf("Slot %d: %s%n",
                (i + 1),
                contenido.isEmpty() ? "Vacío" : " " + preview);
        }
    }

    public ArrayList<String> getSlots() {
        return new ArrayList<>(slots); // Copia segura
    }
}