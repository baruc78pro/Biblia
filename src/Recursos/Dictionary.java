package Recursos;

import Comandos.CDiccionario;
import com.formdev.flatlaf.FlatDarkLaf;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.rendering.PDFRenderer;
import org.apache.pdfbox.rendering.ImageType;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollBar;
import javax.swing.UIManager;
import javax.swing.filechooser.FileNameExtensionFilter;
import org.apache.pdfbox.Loader;
import scrollbar.ScrollBarCustom;

public class Dictionary extends javax.swing.JFrame {
    public PDDocument document;
    private static final float SCALE_INCREMENT = 0.1f; // Incremento de escala
    private static final float MIN_SCALE = 0.1f; // Escala mínima
    private float scale = 1.0f; // Escala inicial
    private PDFRenderer renderer;
    public int currentPage;
    public static int PAGES_PER_BLOCK = 2;
    
    public Dictionary() {
        initComponents();
        this.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setIconImage(new ImageIcon(getClass().getResource("/Recursos/images/logo.png")).getImage());
        this.setLocationRelativeTo(null);
        this.setTitle("Diccionario");
        this.requestFocusInWindow();
        new CDiccionario().KeyEvent(this);
        this.setFocusable(true);
        this.setFocusTraversalKeysEnabled(false);
        panel.setBackground(Color.decode("#D9D8D7"));
        ver_pdf.setBackground(Color.decode("#F2EDE9"));
        panel1.setBackground(Color.decode("#BF3434"));
        abrir.setForeground(Color.decode("#FFFFFF"));
        mas.setForeground(Color.decode("#FFFFFF"));
        menos.setForeground(Color.decode("#FFFFFF"));
        siguiente.setForeground(Color.decode("#FFFFFF"));
        atras.setForeground(Color.decode("#FFFFFF"));
        scrollPane.setBorder(BorderFactory.createEmptyBorder());
        ScrollBarCustom sp = new ScrollBarCustom();
        sp.setOrientation(JScrollBar.HORIZONTAL);
        scrollPane.setHorizontalScrollBar(sp);
        scrollPane.setVerticalScrollBar(new ScrollBarCustom());
        ver_pdf.setBorder(BorderFactory.createEmptyBorder());
        /*this.addKeyListener(new KeyAdapter() {}*/
        ver_pdf.addMouseListener(new MouseAdapter(){
            @Override
            public void mousePressed(MouseEvent e){
                if(e.getButton() == MouseEvent.BUTTON1){prev();}
                if(e.getButton() == MouseEvent.BUTTON3){ next();}
            }
        });
        ver_pdf.addMouseWheelListener(e -> { if (e.getWheelRotation() > 0) {min();} else {max();}});
            
        botones();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel = new javax.swing.JPanel();
        panel1 = new javax.swing.JPanel();
        mas = new javax.swing.JButton();
        abrir = new javax.swing.JButton();
        menos = new javax.swing.JButton();
        atras = new javax.swing.JButton();
        siguiente = new javax.swing.JButton();
        scrollPane = new javax.swing.JScrollPane();
        ver_pdf = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panel.setBackground(new java.awt.Color(0, 0, 0));

        panel1.setBackground(new java.awt.Color(255, 255, 255));

        mas.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        mas.setForeground(new java.awt.Color(0, 0, 0));
        mas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/max.png"))); // NOI18N
        mas.setBorderPainted(false);
        mas.setContentAreaFilled(false);

        abrir.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        abrir.setForeground(new java.awt.Color(51, 51, 51));
        abrir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/open.png"))); // NOI18N
        abrir.setBorderPainted(false);
        abrir.setContentAreaFilled(false);

        menos.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        menos.setForeground(new java.awt.Color(0, 0, 0));
        menos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/min.png"))); // NOI18N
        menos.setBorderPainted(false);
        menos.setContentAreaFilled(false);

        atras.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        atras.setForeground(new java.awt.Color(0, 0, 0));
        atras.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/next.png"))); // NOI18N
        atras.setBorderPainted(false);
        atras.setContentAreaFilled(false);

        siguiente.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        siguiente.setForeground(new java.awt.Color(0, 0, 0));
        siguiente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/prev.png"))); // NOI18N
        siguiente.setBorderPainted(false);
        siguiente.setContentAreaFilled(false);

        javax.swing.GroupLayout panel1Layout = new javax.swing.GroupLayout(panel1);
        panel1.setLayout(panel1Layout);
        panel1Layout.setHorizontalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(abrir)
            .addComponent(mas, javax.swing.GroupLayout.DEFAULT_SIZE, 77, Short.MAX_VALUE)
            .addComponent(menos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(atras, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(siguiente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        panel1Layout.setVerticalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel1Layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addComponent(abrir)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(mas)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(menos)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(atras)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(siguiente)
                .addContainerGap(239, Short.MAX_VALUE))
        );

        ver_pdf.setBackground(new java.awt.Color(200, 200, 200));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Abre y lee tus archivos pdf sin necesidad");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("de otro software");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("página");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("clic derecho o izquierdo para cambiar de");

        javax.swing.GroupLayout ver_pdfLayout = new javax.swing.GroupLayout(ver_pdf);
        ver_pdf.setLayout(ver_pdfLayout);
        ver_pdfLayout.setHorizontalGroup(
            ver_pdfLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ver_pdfLayout.createSequentialGroup()
                .addGroup(ver_pdfLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ver_pdfLayout.createSequentialGroup()
                        .addGap(114, 114, 114)
                        .addComponent(jLabel1))
                    .addGroup(ver_pdfLayout.createSequentialGroup()
                        .addGap(210, 210, 210)
                        .addGroup(ver_pdfLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addGroup(ver_pdfLayout.createSequentialGroup()
                                .addGap(51, 51, 51)
                                .addComponent(jLabel3)))))
                .addContainerGap(404, Short.MAX_VALUE))
            .addGroup(ver_pdfLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(ver_pdfLayout.createSequentialGroup()
                    .addGap(124, 124, 124)
                    .addComponent(jLabel4)
                    .addContainerGap(395, Short.MAX_VALUE)))
        );
        ver_pdfLayout.setVerticalGroup(
            ver_pdfLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ver_pdfLayout.createSequentialGroup()
                .addGap(199, 199, 199)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addGap(133, 133, 133)
                .addComponent(jLabel3)
                .addContainerGap(199, Short.MAX_VALUE))
            .addGroup(ver_pdfLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ver_pdfLayout.createSequentialGroup()
                    .addContainerGap(358, Short.MAX_VALUE)
                    .addComponent(jLabel4)
                    .addGap(229, 229, 229)))
        );

        scrollPane.setViewportView(ver_pdf);

        javax.swing.GroupLayout panelLayout = new javax.swing.GroupLayout(panel);
        panel.setLayout(panelLayout);
        panelLayout.setHorizontalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelLayout.createSequentialGroup()
                .addComponent(panel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 578, Short.MAX_VALUE))
        );
        panelLayout.setVerticalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(scrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
            .addComponent(panel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    public void botones(){
        abrir.addActionListener(e -> {
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setFileFilter(new FileNameExtensionFilter("PDF Files", "pdf"));
            int option = fileChooser.showOpenDialog(this);
            
            if (option == JFileChooser.APPROVE_OPTION) {
                File file = fileChooser.getSelectedFile();
                String nombre = file.getName();
                this.setTitle("Archivo " + nombre);
            try {
                document = Loader.loadPDF(file);
            } catch (IOException ex) {
                Logger.getLogger(Dictionary.class.getName()).log(Level.SEVERE, null, ex);
            }
                renderer = new PDFRenderer(document);
                currentPage = 0;
                renderPages();
            }
            this.requestFocusInWindow();
        });
        
        mas.addActionListener(e -> {max();});
        
        menos.addActionListener(e -> {min();});
        
        atras.addActionListener(e -> {prev();});
        
        siguiente.addActionListener(e ->{next();});
    }
    private void max(){
        if (document != null) {
            scale += SCALE_INCREMENT; // Incrementamos el factor de escala
            renderPages();
        } else {
            JOptionPane.showMessageDialog(null, "Abrir un documento PDF primero");
        }
        this.requestFocusInWindow();
    }
    
    private void min(){
        if (document != null && scale > MIN_SCALE) {
            scale -= SCALE_INCREMENT; // Disminuimos el factor de escala
            renderPages();
        } else {
            JOptionPane.showMessageDialog(null, "Abrir un documento PDF primero o ya has alcanzado el zoom mínimo");
        }
        this.requestFocusInWindow();
    }
    
    public void next(){
        if (currentPage + PAGES_PER_BLOCK < document.getNumberOfPages()) {
                currentPage++;
                renderPages();
            } else {
                JOptionPane.showMessageDialog(null, "Ya estás en la última página");
            }
            this.requestFocusInWindow();
    }
    public void prev(){
        if (currentPage > 0) {
                currentPage--;
                renderPages();
            } else {
                JOptionPane.showMessageDialog(null, "Ya estás en la primera página");
            }
            this.requestFocusInWindow();
    }
    
    public void renderPages() {
    ver_pdf.removeAll();
    ver_pdf.setLayout(new GridLayout(0, 1));
    try {
        BufferedImage image = renderer.renderImageWithDPI(currentPage, 80 * scale, ImageType.RGB); // Renderiza la página actual
        JLabel label = new JLabel(new ImageIcon(image));
        ver_pdf.add(label);
    } catch (IOException e) {
        e.printStackTrace();
    }
    ver_pdf.revalidate();
    ver_pdf.repaint();
    }
    public static void main(String args[]) {
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
            java.util.logging.Logger.getLogger(Dictionary.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Dictionary.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Dictionary.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Dictionary.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        
        try{UIManager.setLookAndFeel(new FlatDarkLaf());}catch(Exception e){ e.printStackTrace();}
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Dictionary().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton abrir;
    private javax.swing.JButton atras;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JButton mas;
    private javax.swing.JButton menos;
    private javax.swing.JPanel panel;
    private javax.swing.JPanel panel1;
    private javax.swing.JScrollPane scrollPane;
    private javax.swing.JButton siguiente;
    private javax.swing.JPanel ver_pdf;
    // End of variables declaration//GEN-END:variables
}