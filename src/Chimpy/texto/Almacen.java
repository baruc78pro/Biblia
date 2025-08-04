package Chimpy.texto;

import java.util.HashMap;

public class Almacen {

    public static HashMap<String, String> obtenerPalabras() {
        HashMap<String, String> palabras = new HashMap<>();
        //palabras Chimpy
        String[] chimpy = {
            "intentar", "capturar", "entero", "flotante", "cadena", "caracter", "booleano",
            "clase publica", "vacio", "hilo", "iniciar", "parar", "nuevo", "igual()",
            "publico", "clase", "interfaz", "Cuadro", "privado", "protegido", "final", "estatico",
            "ancho", "extiende a", "{}", "clase publica", "metodo publico", "metodo privado", "principal()",
            "finalizar(0)", "Icono", "pintar", "fuente", "importar", "si", "entonces", "sino",
            "leerLinea()", "leerEntero()", "mientras", "hacer", "cuando", "sea", "romper", "esto",
            "paquete", "Lista<>", "para", "fondo()", "salida", "titulo", "tamaño", "evento", "centrar",
            "boton", "etiqueta", "campo", "caja", "panel", "javax.graficos.*", "java.evento.*;", "agregar"
        };
        //palabras en Java
        String[] java = {
            "try", "catch", "int", "float", "String", "char", "boolean",
            "public class", "void", "thread", "start", "stop", "new", "equals()",
            "public", "class", "interface", "JFrame", "private", "protected", "final", "static",
            "length", "extends", "{}", "clase publica", "metodo publico", "metodo privado", 
            "public static void main(String[]args)", "System.exit(0)", "ImageIcon", "setBackground", 
            "setForeground", "import", "if", "else", "else if", "nextLine()", "nextInt()", "while",
            "do", "switch", "case", "break", "this", "package", "List<>", "for", "setIcon()",
            "System.out.println", "setTitle", "setSize", "addActionListener",
            "setLocationRelativeTo", "JButton", "JLabel", "JTextField", "JTextArea", "JPanel", "javax.swing.*", 
            "import java.awt.event.*;", "add"
        };
        
        // Comprobación de tamaños
        if (chimpy.length == java.length) {
            for (int i = 0; i < chimpy.length; i++) {
                palabras.put(chimpy[i], java[i]);
            }
        } else {
            System.out.println("Error: los arrays no tienen la misma longitud.");
        }
        
        return palabras;
    }
    public static HashMap<String, String> invertirMapa(HashMap<String, String> original) {
        HashMap<String, String> invertido = new HashMap<>();
        for (String clave : original.keySet()) {
            invertido.put(original.get(clave), clave);
        }
        return invertido;
    }
}