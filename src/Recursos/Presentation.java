package Recursos;

import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.event.KeyEvent;
import javax.swing.BorderFactory;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JScrollBar;
import javax.swing.JTextPane;
import javax.swing.KeyStroke;
import javax.swing.text.DefaultCaret;
import scrollbar.ScrollBarCustom;

public class Presentation extends javax.swing.JFrame {
    
    public Presentation() {
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setUndecorated(true);
    initComponents();
    entrarPantallaCompleta();
    registrarTeclas();
    scrollPane.setBorder(BorderFactory.createEmptyBorder());
    textArea.setBorder(null);
    scrollPane.setVerticalScrollBar(new ScrollBarCustom());
    ScrollBarCustom sp = new ScrollBarCustom();
    sp.setOrientation(JScrollBar.HORIZONTAL);
    scrollPane.setHorizontalScrollBar(sp);
    textArea.setBorder(null);
    textArea.getCaret().setBlinkRate(0);
    textArea.setCaret(new DefaultCaret() {
            @Override
            public void paint(Graphics g) {
        // No pintar nada (caret invisible)
            }
        });
    }

    private void entrarPantallaCompleta() {
        GraphicsDevice device = GraphicsEnvironment
            .getLocalGraphicsEnvironment()
            .getDefaultScreenDevice();
        device.setFullScreenWindow(this);
        EventQueue.invokeLater(() -> {
                textArea.setSize(getContentPane().getSize());
            });
    }

    private void registrarTeclas() {
        getRootPane().registerKeyboardAction(
            e -> salirPantallaCompleta(), 
        KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0),
        JComponent.WHEN_IN_FOCUSED_WINDOW
        );
    }

    private void salirPantallaCompleta() {
        GraphicsEnvironment.getLocalGraphicsEnvironment()
            .getDefaultScreenDevice()
            .setFullScreenWindow(null);
        this.dispose();
    }
    public void obtenerTexto(JTextPane pane){
        textArea.setText(pane.getText());
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel = new javax.swing.JPanel();
        scrollPane = new javax.swing.JScrollPane();
        textArea = new javax.swing.JTextPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setExtendedState(6);

        panel.setBackground(new java.awt.Color(45, 45, 45));
        panel.setLayout(new javax.swing.OverlayLayout(panel));

        textArea.setBackground(new java.awt.Color(35, 35, 35));
        textArea.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        textArea.setForeground(new java.awt.Color(220, 220, 220));
        scrollPane.setViewportView(textArea);

        panel.add(scrollPane);

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

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(Presentation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Presentation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Presentation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Presentation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Presentation().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JPanel panel;
    private javax.swing.JScrollPane scrollPane;
    public javax.swing.JTextPane textArea;
    // End of variables declaration//GEN-END:variables
}
