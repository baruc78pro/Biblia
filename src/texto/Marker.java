package texto;

import java.awt.Color;
import javax.swing.JTextPane;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultStyledDocument;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyleContext;

public class Marker {
    public int marcarString(String text, int index){
        while(--index >= 0){
            //\\W = [A-Za-Z0-9]
            if(String.valueOf(text.charAt(index)).matches("\\W")){
                break;
            }
        }
        return index;
    }
    public int primerPalabra(String text, int index){
        while(index < text.length()){
            if(String.valueOf(text.charAt(index)).matches("\\W")){
                break;
            }
            index++;
        }
        return index;
    }
    public void colors(JTextPane texto){
        final StyleContext cont = StyleContext.getDefaultStyleContext();
        final AttributeSet atributoAzul = cont.addAttribute(cont.getEmptySet(), StyleConstants.Foreground, Color.decode("#FFD369"));
        final AttributeSet atributoVerde = cont.addAttribute(cont.getEmptySet(), StyleConstants.Foreground, Color.decode("#FFD369"));
        final AttributeSet atributoCeleste = cont.addAttribute(cont.getEmptySet(), StyleConstants.Foreground, Color.decode("#FFD369"));
        final AttributeSet atributoMorado = cont.addAttribute(cont.getEmptySet(), StyleConstants.Foreground, Color.decode("#FFD369"));
        //Estilo
        DefaultStyledDocument doc = new DefaultStyledDocument(){
        public void insertString(int offset, String str, AttributeSet a) throws BadLocationException{
            super.insertString(offset, str, a);
            String text = getText(0, getLength());
            int before = marcarString(text, offset);
            
            if(before < 0){
                before = 0;
            }
            int after = primerPalabra(text, offset + str.length()),
            wordL = before,
            wordR = before;
            
            while(wordR <= after){
                if(wordR == after || String.valueOf(text.charAt(wordR)).matches("\\W")){
                    if(text.substring(wordL, wordR).matches("(\\W)*(Dios|expansión|cielos|Mares)")){
                        setCharacterAttributes(wordL, wordR - wordL, atributoAzul, false);
                    }
                        if(text.substring(wordL, wordR).matches("(\\W)*(tierra|naturaleza|Gihón|campo|huerto)")){
                        setCharacterAttributes(wordL, wordR - wordL, atributoVerde, false);
                    }
                        if(text.substring(wordL, wordR).matches("(\\W)*(lumbreras|día|acabados|Fructificad|mal|morirás)")){
                        setCharacterAttributes(wordL, wordR - wordL, atributoCeleste, false);
                    }
                        if(text.substring(wordL, wordR).matches("(\\W)*(Adam|pecado|promesa|paseaba|comido|simiente)")){
                        setCharacterAttributes(wordL, wordR - wordL, atributoMorado, false);
                    }
                    wordL = wordR;
                }
                wordR++;
            }
        }
        public void remove(int offs, int len) throws BadLocationException{
            super.remove(offs, len);
            String text = getText(0, getLength());
            int before = marcarString(text, offs);
            if(before < 0){
                before = 0;
            }
        }
        };
        texto.setStyledDocument(doc);
      }
}
