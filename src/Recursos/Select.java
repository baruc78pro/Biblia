package Recursos;

import Instancia.AbrirFrame;
import java.awt.Color;
import javax.swing.ImageIcon;


public class Select extends javax.swing.JFrame {

    public Select() {
        initComponents();
        setIconImage(new ImageIcon(getClass().getResource("images/logo.png")).getImage());
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setTitle("Selector");
        buscador.setForeground(Color.LIGHT_GRAY);
        new AbrirFrame().instancia(biblia, new Bible(), this);
        new AbrirFrame().instancia(audio, new BibleMp3(), this);
        new AbrirFrame().instancia(buscador, new Search(), this);
        panel.setBackground(Color.decode("#C4A484"));
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel = new javax.swing.JPanel();
        audio = new javax.swing.JButton();
        biblia = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        buscador = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        audio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/images/audiobibl.png"))); // NOI18N
        audio.setBorderPainted(false);
        audio.setContentAreaFilled(false);
        audio.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        panel.add(audio, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 70, 170, 150));

        biblia.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/images/creativos/boton1.png"))); // NOI18N
        biblia.setBorderPainted(false);
        biblia.setContentAreaFilled(false);
        biblia.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        panel.add(biblia, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 160, 150));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Biblia en texto");
        panel.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 230, -1, 20));

        buscador.setBackground(new java.awt.Color(204, 204, 204));
        buscador.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        buscador.setForeground(new java.awt.Color(255, 255, 255));
        buscador.setText("Buscador de citas biblicas");
        buscador.setBorderPainted(false);
        buscador.setContentAreaFilled(false);
        buscador.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        buscador.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                buscadorMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                buscadorMouseExited(evt);
            }
        });
        panel.add(buscador, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 270, 260, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Biblia en audio");
        panel.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 230, -1, 20));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel, javax.swing.GroupLayout.DEFAULT_SIZE, 412, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel, javax.swing.GroupLayout.DEFAULT_SIZE, 334, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buscadorMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buscadorMouseEntered
        buscador.setForeground(Color.WHITE);
    }//GEN-LAST:event_buscadorMouseEntered

    private void buscadorMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buscadorMouseExited
        buscador.setForeground(Color.LIGHT_GRAY);
    }//GEN-LAST:event_buscadorMouseExited

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
            java.util.logging.Logger.getLogger(Select.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Select.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Select.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Select.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Select().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton audio;
    private javax.swing.JButton biblia;
    private javax.swing.JButton buscador;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel panel;
    // End of variables declaration//GEN-END:variables
}
