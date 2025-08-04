package texto;

import java.io.File;
import java.io.FileInputStream;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;
import org.apache.poi.xwpf.usermodel.BodyElementType;
import org.apache.poi.xwpf.usermodel.IBodyElement;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFPictureData;

public class DocxReader {
    public void loadWordDocument(JTextPane textArea, JFrame frame) {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileFilter(new FileNameExtensionFilter("DOCX Files", "docx"));
        int seleccion = fileChooser.showOpenDialog(frame);
        textArea.setText("");
        File archivo = fileChooser.getSelectedFile();
        if (!archivo.getName().toLowerCase().endsWith(".docx")) {
            JOptionPane.showMessageDialog(null, "Por favor selecciona un archivo .docx", "Formato no compatible", JOptionPane.WARNING_MESSAGE);
            return;
    }
    try (FileInputStream fis = new FileInputStream(archivo);
     XWPFDocument document = new XWPFDocument(fis)) {
        frame.setTitle(archivo.getName());
    
    StyledDocument doc = textArea.getStyledDocument();

    // Iterar sobre los elementos del cuerpo del documento
    for (IBodyElement element : document.getBodyElements()) {
        if (element.getElementType() == BodyElementType.PARAGRAPH) {
            XWPFParagraph paragraph = (XWPFParagraph) element;
            doc.insertString(doc.getLength(), paragraph.getText() + "\n", null);
        } else if (element.getElementType() == BodyElementType.TABLE) {
            // Opcional: Manejar tablas si es necesario
        }
    }

        // Manejar imágenes incrustadas
        List<XWPFPictureData> pictures = document.getAllPictures();
    for (XWPFPictureData picture : pictures) {
        byte[] bytes = picture.getData();
        ImageIcon imageIcon = new ImageIcon(bytes);

        // Convertir la imagen en un atributo para StyledDocument
        Style style = textArea.addStyle("ImageStyle", null);
        StyleConstants.setIcon(style, imageIcon);

        // Insertar la imagen en el documento
        doc.insertString(doc.getLength(), " ", style);
        doc.insertString(doc.getLength(), "\n", null);
    }
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Error al cargar el archivo: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
