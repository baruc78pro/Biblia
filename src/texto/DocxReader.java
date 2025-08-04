package texto;

import java.io.File;
import java.io.FileInputStream;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextPane;
import javax.swing.SwingUtilities;
import javax.swing.SwingWorker;
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
    
    public static class DocxLoadWorker extends SwingWorker<Void, Void> {
        private final JTextPane textArea;
        private final JFrame frame;
        
        public DocxLoadWorker(JTextPane textArea, JFrame frame) {
            this.textArea = textArea;
            this.frame = frame;
        }
        
        @Override
        protected Void doInBackground() throws Exception {
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setFileFilter(new FileNameExtensionFilter("DOCX Files", "docx"));
            
            int seleccion = fileChooser.showOpenDialog(frame);
            if (seleccion != JFileChooser.APPROVE_OPTION) return null;
            
            File archivo = fileChooser.getSelectedFile();
            if (!archivo.getName().toLowerCase().endsWith(".docx")) {
                SwingUtilities.invokeLater(() -> {
                    JOptionPane.showMessageDialog(frame, 
                        "Por favor selecciona un archivo .docx", 
                        "Formato no compatible", 
                        JOptionPane.WARNING_MESSAGE);
                });
                return null;
            }
            
            try (FileInputStream fis = new FileInputStream(archivo);
                 XWPFDocument document = new XWPFDocument(fis)) {
                
                SwingUtilities.invokeLater(() -> {
                    frame.setTitle(archivo.getName());
                    textArea.setText("");
                });
                
                StyledDocument doc = textArea.getStyledDocument();
                
                // Procesar contenido del documento
                for (IBodyElement element : document.getBodyElements()) {
                    if (element.getElementType() == BodyElementType.PARAGRAPH) {
                        XWPFParagraph paragraph = (XWPFParagraph) element;
                        SwingUtilities.invokeLater(() -> {
                            try {
                                doc.insertString(doc.getLength(), paragraph.getText() + "\n", null);
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        });
                    }
                }
                
                // Procesar imágenes
                List<XWPFPictureData> pictures = document.getAllPictures();
                for (XWPFPictureData picture : pictures) {
                    byte[] bytes = picture.getData();
                    ImageIcon imageIcon = new ImageIcon(bytes);
                    
                    SwingUtilities.invokeLater(() -> {
                        Style style = textArea.addStyle("ImageStyle", null);
                        StyleConstants.setIcon(style, imageIcon);
                        try {
                            doc.insertString(doc.getLength(), " ", style);
                            doc.insertString(doc.getLength(), "\n", null);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    });
                }
            } catch (Exception e) {
                SwingUtilities.invokeLater(() -> {
                    JOptionPane.showMessageDialog(frame, 
                        "Error al cargar el archivo: " + e.getMessage(), 
                        "Error", 
                        JOptionPane.ERROR_MESSAGE);
                });
            }
            return null;
        }
    }
    
    public void loadWordDocument(JTextPane textArea, JFrame frame) {
        new DocxLoadWorker(textArea, frame).execute();
    }
}