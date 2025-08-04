package Recursos;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

public class Converter extends javax.swing.JFrame {

    public Converter() {
        initComponents();
        this.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        setIconImage(new ImageIcon(getClass().getResource("images/logo.png")).getImage());
        panel.setBackground(Color.decode("#7986CB"));
        png.setBackground(Color.decode("#1A237E"));
        jpg.setBackground(Color.decode("#1A237E"));
        webp.setBackground(Color.decode("#1A237E"));
        png.setForeground(Color.decode("#E8EAF6"));
        jpg.setForeground(Color.decode("#E8EAF6"));
        webp.setForeground(Color.decode("#E8EAF6"));
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel = new javax.swing.JPanel();
        jpg = new javax.swing.JButton();
        png = new javax.swing.JButton();
        webp = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panel.setBackground(new java.awt.Color(51, 51, 51));
        panel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jpg.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jpg.setText("png a jpg");
        jpg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jpgActionPerformed(evt);
            }
        });
        panel.add(jpg, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 170, 50));

        png.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        png.setText("jpg a png");
        png.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pngActionPerformed(evt);
            }
        });
        panel.add(png, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, 170, 50));

        webp.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        webp.setText("webp a png");
        webp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                webpActionPerformed(evt);
            }
        });
        panel.add(webp, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 220, 170, 50));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(220, 220, 220));
        jLabel1.setText("Convertidor de formato");
        panel.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 70, -1, -1));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(220, 220, 220));
        jLabel2.setText("de imagen a otras");
        panel.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 90, -1, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(220, 220, 220));
        jLabel3.setText("    Source Forge");
        panel.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 180, 110, -1));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(220, 220, 220));
        jLabel4.setText("  Módulo código abierto en");
        panel.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 160, 190, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel, javax.swing.GroupLayout.DEFAULT_SIZE, 401, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel, javax.swing.GroupLayout.DEFAULT_SIZE, 311, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jpgActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jpgActionPerformed
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileFilter(new FileNameExtensionFilter("PNG Files", "png"));
        int option = fileChooser.showOpenDialog(this);
        
        if (option == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
        try {
            BufferedImage input = ImageIO.read(file);
            String outputFileName = file.getAbsolutePath().replace(".png", "_converted.jpg");
             BufferedImage rgbImage = new BufferedImage(
            input.getWidth(),
            input.getHeight(),
            BufferedImage.TYPE_INT_RGB // Convertir a imagen sin transparencia
        );

        // Dibujar la imagen original en la nueva
        rgbImage.getGraphics().drawImage(input, 0, 0, null);
            File out = new File(outputFileName);
            ImageIO.write(input, "jpg", out);
            
            System.out.println("Conversión completada: " + out.getAbsolutePath());
        } catch (IOException ex) {
            Logger.getLogger(Converter.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println("Error durante la conversión: " + ex.getMessage());
        }
        }
    }//GEN-LAST:event_jpgActionPerformed

    private void pngActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pngActionPerformed
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileFilter(new FileNameExtensionFilter("JPG Files", "jpg"));
        int option = fileChooser.showOpenDialog(this);
        
        if (option == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
        try {
            BufferedImage input = ImageIO.read(file);
            String outputFileName = file.getAbsolutePath().replace(".jpg", "_converted.png");
            File out = new File(outputFileName);
            ImageIO.write(input, "png", out);
            
            System.out.println("Conversión completada: " + out.getAbsolutePath());
        } catch (IOException ex) {
            Logger.getLogger(Converter.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println("Error durante la conversión: " + ex.getMessage());
        }
        }
    }//GEN-LAST:event_pngActionPerformed

    private void webpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_webpActionPerformed
        /*JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileFilter(new FileNameExtensionFilter("WEBP Files", "webp"));
        int option = fileChooser.showOpenDialog(this);

        if (option == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            try {
                // Leer la imagen WebP usando ImageIO
                BufferedImage input = ImageIO.read(file);
                
                // Crear nombre para el archivo de salida
                String outputFileName = file.getAbsolutePath().replace(".webp", "_converted.png");
                File out = new File(outputFileName);

                // Escribir la imagen en formato PNG
                boolean result = ImageIO.write(input, "PNG", out);

                if (result) {
                    System.out.println("Conversión completada: " + out.getAbsolutePath());
                } else {
                    System.err.println("Error: no se pudo escribir la imagen en formato PNG.");
                }
            } catch (IOException ex) {
                Logger.getLogger(Convertidor.class.getName()).log(Level.SEVERE, null, ex);
                System.err.println("Error durante la conversión: " + ex.getMessage());
            }
        }*/
        JOptionPane.showMessageDialog(null, "En experimentación :)."
                + "\nAún sin funcionamiento");
    }//GEN-LAST:event_webpActionPerformed

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
            java.util.logging.Logger.getLogger(Converter.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Converter.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Converter.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Converter.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Converter().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JButton jpg;
    private javax.swing.JPanel panel;
    private javax.swing.JButton png;
    private javax.swing.JButton webp;
    // End of variables declaration//GEN-END:variables
}
