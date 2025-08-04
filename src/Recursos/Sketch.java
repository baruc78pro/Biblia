package Recursos;

import com.formdev.flatlaf.FlatDarkLaf;
import java.awt.Color;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JScrollBar;
import javax.swing.UIManager;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import javax.swing.filechooser.FileNameExtensionFilter;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import scrollbar.ScrollBarCustom;

public class Sketch extends javax.swing.JFrame {
    
    String parrafo;
    JFileChooser fileChooser = new JFileChooser();
    public Sketch() {
        initComponents();
        this.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setIconImage(new ImageIcon(getClass().getResource("images/logo.png")).getImage());
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.requestFocusInWindow();
        scrollPane.setVerticalScrollBar(new ScrollBarCustom());
        ScrollBarCustom sp = new ScrollBarCustom();
        sp.setOrientation(JScrollBar.HORIZONTAL);
        scrollPane.setHorizontalScrollBar(sp);
        panel1.setBackground(Color.decode("#BF360C"));
        text1.setBackground(Color.decode("#FBE9E7"));
        textArea.setBackground(Color.decode("#FBE9E7"));
        editorPane.setBackground(Color.decode("#FBE9E7"));
        docx.setBackground(Color.decode("#FF5722"));
        abrir.setBackground(Color.decode("#FF5722"));
        buscar.setBackground(Color.decode("#FF5722"));
        liga.setBackground(Color.decode("#FF5722"));
        docx.addActionListener(e -> {saveWord();});
        abrir.addActionListener(e -> {abrirArchivo();});
        this.setFocusable(true);
        this.setFocusTraversalKeysEnabled(false);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        panel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        text1 = new javax.swing.JTextPane();
        abrir = new javax.swing.JButton();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        scrollPane = new javax.swing.JScrollPane();
        textArea = new javax.swing.JTextPane();
        docx = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        editorPane = new javax.swing.JEditorPane();
        buscar = new javax.swing.JButton();
        liga = new javax.swing.JTextField();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panel1.setBackground(new java.awt.Color(60, 60, 60));
        panel1.setForeground(new java.awt.Color(250, 250, 250));
        panel1.setPreferredSize(new java.awt.Dimension(300, 150));
        panel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        text1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        text1.setForeground(new java.awt.Color(0, 0, 0));
        jScrollPane2.setViewportView(text1);

        panel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 440, 550));

        abrir.setForeground(new java.awt.Color(250, 250, 250));
        abrir.setText("abrir archivo txt");
        abrir.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(250, 250, 250), 1, true));
        panel1.add(abrir, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 10, 160, 30));

        jTabbedPane1.setBackground(new java.awt.Color(20, 20, 20));

        textArea.setEditable(false);
        textArea.setBackground(new java.awt.Color(40, 40, 40));
        textArea.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        textArea.setForeground(new java.awt.Color(0, 0, 0));
        scrollPane.setViewportView(textArea);

        jTabbedPane1.addTab("tab1", scrollPane);

        panel1.add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 50, 320, 290));

        docx.setForeground(new java.awt.Color(250, 250, 250));
        docx.setText("guardar docx");
        docx.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(250, 250, 250), 1, true));
        panel1.add(docx, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 10, 130, 30));

        editorPane.setEditable(false);
        editorPane.setBackground(new java.awt.Color(40, 40, 40));
        editorPane.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        editorPane.setForeground(new java.awt.Color(0, 0, 0));
        jScrollPane3.setViewportView(editorPane);

        panel1.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 380, 320, 170));

        buscar.setForeground(new java.awt.Color(250, 250, 250));
        buscar.setText("Buscar");
        buscar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscarActionPerformed(evt);
            }
        });
        panel1.add(buscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 350, 80, 30));

        liga.setBackground(new java.awt.Color(30, 30, 30));
        liga.setForeground(new java.awt.Color(250, 250, 250));
        liga.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        panel1.add(liga, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 350, 230, 20));

        jScrollPane1.setViewportView(panel1);

        jMenu1.setText("Opciones");

        jMenuItem1.setText("Manual");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 766, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 550, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        Manual_bosquejo mb = new Manual_bosquejo();
        mb.setVisible(true);
        mb.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setVisible(true);
        mb.toFront();
        this.requestFocusInWindow();
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void buscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarActionPerformed
        try {
                String url = liga.getText();
                Document doc = Jsoup.connect(url).get();
                Element textoBiblico = doc.selectFirst(".passage-text"); // Selector de la clase que contiene el texto
                if (textoBiblico != null) {
                    String textoPlano = textoBiblico.text(); // Extraer solo el texto plano
                    editorPane.setText(textoPlano);
                } else {
                    editorPane.setText("Error: No se pudo encontrar el texto bíblico.");
                }
            } catch (IOException e) {
                editorPane.setText("Error al obtener el texto: " + e.getMessage());
            }
    }//GEN-LAST:event_buscarActionPerformed
    
    private void abrirArchivo() {
        fileChooser.setFileFilter(new FileNameExtensionFilter("TXT Files", "txt"));
        int seleccion = fileChooser.showOpenDialog(this);
        if (seleccion == JFileChooser.APPROVE_OPTION) {
            try {
                textArea.setText("");
                File archivo = fileChooser.getSelectedFile();
                this.setTitle(archivo.getName());
                BufferedReader lector = new BufferedReader(new FileReader(archivo));
                StringBuilder contenido = new StringBuilder();
                String linea;
                while ((linea = lector.readLine()) != null) {
                    contenido.append(linea).append("\n");
                }
                lector.close();
                textArea.setText(contenido.toString());
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
    
    public void saveWord(){
    parrafo = text1.getText().trim();
    
    JFileChooser fileChooser = new JFileChooser();
    
    int seleccion = fileChooser.showSaveDialog(this); // "this" se refiere al JFrame actual

    if (seleccion == JFileChooser.APPROVE_OPTION) {
        File archivo = fileChooser.getSelectedFile();
        String filePath = archivo.getAbsolutePath();
        
        filePath += ".docx";

        try (FileOutputStream out = new FileOutputStream(filePath)) {
            XWPFDocument document = new XWPFDocument();
            
            XWPFParagraph text = document.createParagraph();
            XWPFRun tituloRun = text.createRun();
            tituloRun.setText(parrafo);
            
            document.write(out);
            
            JOptionPane.showMessageDialog(this, "Archivo guardado exitosamente en: " + filePath);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Sketch.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Sketch.class.getName()).log(Level.SEVERE, null, ex);
        }
    } else if (seleccion == JFileChooser.CANCEL_OPTION) {
        JOptionPane.showMessageDialog(this, "Operación cancelada por el usuario");
    }
    }
    
    public static void main(String args[]){
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Sketch.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Sketch.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Sketch.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Sketch.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Sketch().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton abrir;
    private javax.swing.JButton buscar;
    private javax.swing.JButton docx;
    private javax.swing.JEditorPane editorPane;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextField liga;
    private javax.swing.JPanel panel1;
    private javax.swing.JScrollPane scrollPane;
    private javax.swing.JTextPane text1;
    private javax.swing.JTextPane textArea;
    // End of variables declaration//GEN-END:variables
}