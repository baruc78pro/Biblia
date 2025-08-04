package texto;

import java.util.HashMap;

/**
 *
 * @author Cooler Master
 */
public class ListaBraile {
    public static HashMap<String, String> obtenerPalabras() {
        HashMap<String, String> palabras = new HashMap<>();
        
        String[] caracteres = {
            "a", "b", "c", "d", "e", "f", "g", "h", "i", "j",
            "k", "l", "m", "n", "o", "p", "q", "r", "s", "t",
            "u", "v", "w", "x", "y", "z",
            "1", "2", "3", "4", "5", "6", "7", "8", "9", "0",
            "á", "é", "í", "ó", "ú", "ñ",
            "Á", "É", "Í", "Ó", "Ú", "Ñ"
        };

        String[] braille = {
            "⠁", "⠃", "⠉", "⠙", "⠑", "⠋", "⠛", "⠓", "⠊", "⠚",
            "⠅", "⠇", "⠍", "⠝", "⠕", "⠏", "⠟", "⠗", "⠎", "⠞",
            "⠥", "⠧", "⠺", "⠭", "⠽", "⠵",
            "⠁", "⠃", "⠉", "⠙", "⠑", "⠋", "⠛", "⠓", "⠊", "⠚",
            "⠷", "⠿", "⠾", "⠽", "⠳", "⠻",
            "⠠⠷", "⠠⠿", "⠠⠾", "⠠⠽", "⠠⠳", "⠠⠻"
        };

        if (braille.length == caracteres.length) {
            for (int i = 0; i < braille.length; i++) {
                palabras.put(caracteres[i], braille[i]);
            }
        } else {
            System.out.println("Error: los arrays no tienen la misma longitud.");
        }
        return palabras;
    }
}