package Chimpy.texto;

import java.awt.Color;
import javax.swing.JTextPane;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultStyledDocument;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyleContext;
import java.util.regex.Pattern;

public class Marcador {
    public DefaultStyledDocument doc = new DefaultStyledDocument();
    private static final StyleContext context = StyleContext.getDefaultStyleContext();
    private static final AttributeSet palabrasClave = context.addAttribute(context.getEmptySet(), StyleConstants.Foreground, Color.decode("#e74c3c"));
    private static final AttributeSet tiposDeDatos = context.addAttribute(context.getEmptySet(), StyleConstants.Foreground, Color.decode("#3498db"));
    private static final AttributeSet operadores = context.addAttribute(context.getEmptySet(), StyleConstants.Foreground, Color.decode("#e74c3c"));
    private static final AttributeSet controlDeFlujo = context.addAttribute(context.getEmptySet(), StyleConstants.Foreground, Color.decode("#8e44ad"));
    private static final AttributeSet identificadores = context.addAttribute(context.getEmptySet(), StyleConstants.Foreground, Color.decode("#8e44ad"));
    private static final AttributeSet palabras = context.addAttribute(context.getEmptySet(), StyleConstants.Foreground, Color.decode("#FFFFFF"));
    private static final AttributeSet metodos = context.addAttribute(context.getEmptySet(), StyleConstants.Foreground, Color.decode("#8e44ad"));

    private static final Pattern clave = Pattern.compile("\\b(publico|publica|privado|protegido|clase|clase publica|interfaz|extiende a|extends|break|romper|case|esto|this|package|paquete|public|private|protected|class)\\b");
    private static final Pattern dato = Pattern.compile("\\b(entero|flotante|decimal|cadena|caracter|booleano|String|int|float|char|boolean|double|new|nuevo)\\b");
    private static final Pattern operador = Pattern.compile("\\b(fin|\\(|\\)|\\>|\\<|\\=|:|\\}|\\{)\\b");
    private static final Pattern flujo = Pattern.compile("\\b(si|sino|entonces|caso|no|if|else|else if|cuando|sea)\\b");
    private static final Pattern id = Pattern.compile("\\b(nulo|null|paquete|package|esto|this|hilo|thread|imagen|ImageIcon|Marco|cuadro|JFrame|public\\s+static\\s+void\\s+main\\(String\\[\\]args\\)|principal\\(\\))\\b");
    private static final Pattern metodo = Pattern.compile("\\b(vacio|void|retornar|return|get|set|obtener|valor|salida|salida\\(\\)|leerLinea\\(\\)|leerEntero\\(\\)|setBackground\\(\\)|setForeground\\(\\)|setIcon\\(\\)|pintar\\(\\)|estilo\\(\\)|principal|iniciar|start|parar|stop)\\b");

    public void colors(JTextPane texto) {
        doc = new DefaultStyledDocument() {
            public void insertString(int offset, String str, AttributeSet a) throws BadLocationException {
                super.insertString(offset, str, a);
                aplicarColores();
            }

            public void remove(int offs, int len) throws BadLocationException {
                super.remove(offs, len);
                aplicarColores();
            }

            private void aplicarColores() {
                new Thread(() -> {
                    try {
                        String text = getText(0, getLength());
                        int before = 0;
                        int wordL = before, wordR = before;
                        int after = text.length();

                        while (wordR <= after) {
                            if (wordR == after || String.valueOf(text.charAt(wordR)).matches("\\W")) {
                                String palabra = text.substring(wordL, wordR);

                                if (clave.matcher(palabra).find()) {
                                    setCharacterAttributes(wordL, wordR - wordL, palabrasClave, false);
                                } else if (dato.matcher(palabra).find()) {
                                    setCharacterAttributes(wordL, wordR - wordL, tiposDeDatos, false);
                                } else if (flujo.matcher(palabra).find()) {
                                    setCharacterAttributes(wordL, wordR - wordL, operadores, false);
                                } else if (operador.matcher(palabra).find()) {
                                    setCharacterAttributes(wordL, wordR - wordL, controlDeFlujo, false);
                                } else if (id.matcher(palabra).find()) {
                                    setCharacterAttributes(wordL, wordR - wordL, identificadores, false);
                                } else if (metodo.matcher(palabra).find()) {
                                    setCharacterAttributes(wordL, wordR - wordL, metodos, false);
                                } else {
                                    setCharacterAttributes(wordL, wordR - wordL, palabras, false);
                                }
                                wordL = wordR;
                            }
                            wordR++;
                        }
                    } catch (BadLocationException e) {
                        e.printStackTrace();
                    }
                }).start();
            }
        };

        texto.setStyledDocument(doc);
    }
}