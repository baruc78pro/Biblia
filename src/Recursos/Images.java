package Recursos;

import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class Images extends javax.swing.JFrame {

    public Images() {
        initComponents();
        setLocationRelativeTo(null);
        setResizable(false);
        setIconImage(new ImageIcon(getClass().getResource("images/logo.png")).getImage());
        setTitle("Visor de imagenes");
        panel1.setBackground(Color.decode("#C5CAE9"));
        panel2.setBackground(Color.decode("#3F51B5"));
        prev.setBackground(Color.decode("#303F9F"));
        next.setBackground(Color.decode("#303F9F"));
        out.setBackground(Color.decode("#303F9F"));
        desc.setBackground(Color.decode("#303F9F"));
        out.addActionListener(e->new Tools());
        desc.addActionListener(e->JOptionPane.showMessageDialog(null, "Funciín en desarrollo"));
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel1 = new javax.swing.JPanel();
        panel2 = new javax.swing.JPanel();
        out = new javax.swing.JButton();
        prev = new javax.swing.JButton();
        next = new javax.swing.JButton();
        desc = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        panel1.setBackground(new java.awt.Color(204, 204, 204));
        panel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        panel1.add(panel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 20, 550, 360));

        out.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        out.setForeground(new java.awt.Color(255, 255, 255));
        out.setText("Regresar a herramientas");
        out.setBorderPainted(false);
        panel1.add(out, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 390, 210, 40));

        prev.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        prev.setForeground(new java.awt.Color(255, 255, 255));
        prev.setText("<");
        prev.setBorderPainted(false);
        panel1.add(prev, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 50, 360));

        next.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        next.setForeground(new java.awt.Color(255, 255, 255));
        next.setText(">");
        next.setBorderPainted(false);
        panel1.add(next, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 20, 50, 360));

        desc.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        desc.setForeground(new java.awt.Color(255, 255, 255));
        desc.setText("ver descripción de imagen");
        desc.setBorderPainted(false);
        panel1.add(desc, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 390, 210, 40));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel1, javax.swing.GroupLayout.DEFAULT_SIZE, 449, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
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
            java.util.logging.Logger.getLogger(Images.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Images.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Images.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Images.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Images().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton desc;
    private javax.swing.JButton next;
    private javax.swing.JButton out;
    private javax.swing.JPanel panel1;
    private javax.swing.JPanel panel2;
    private javax.swing.JButton prev;
    // End of variables declaration//GEN-END:variables
}