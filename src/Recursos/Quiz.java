package Recursos;

import Juego.Game;
import javax.swing.ImageIcon;


public class Quiz extends javax.swing.JFrame {

    Game game = new Game();
    
    public Quiz() {
        initComponents();
        setLocationRelativeTo(null);
        setResizable(false);
        this.setIconImage(new ImageIcon(getClass().getResource("images/logo_pequeño(2).jpg")).getImage());
        Instancias();
    }
    
    private void Instancias(){
        //facil.addActionListener(e-> {new AbrirFrame().instancia(game.setVisible(true))});
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        facil = new javax.swing.JButton();
        medio = new javax.swing.JButton();
        dificil = new javax.swing.JButton();
        fondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        facil.setBackground(new java.awt.Color(102, 0, 0));
        facil.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/images/facil.png"))); // NOI18N
        facil.setBorderPainted(false);
        facil.setContentAreaFilled(false);
        facil.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel1.add(facil, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 160, 150, 140));

        medio.setBackground(new java.awt.Color(102, 0, 0));
        medio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/images/medio.png"))); // NOI18N
        medio.setBorderPainted(false);
        medio.setContentAreaFilled(false);
        medio.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel1.add(medio, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 160, 150, 140));

        dificil.setBackground(new java.awt.Color(102, 0, 0));
        dificil.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/images/dificil.png"))); // NOI18N
        dificil.setBorderPainted(false);
        dificil.setContentAreaFilled(false);
        dificil.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel1.add(dificil, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 160, 150, 140));

        fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/images/menu_quiz.png"))); // NOI18N
        jPanel1.add(fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(-20, -40, 810, 570));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 703, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 475, javax.swing.GroupLayout.PREFERRED_SIZE)
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
            java.util.logging.Logger.getLogger(Quiz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Quiz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Quiz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Quiz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Quiz().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton dificil;
    public javax.swing.JButton facil;
    private javax.swing.JLabel fondo;
    private javax.swing.JPanel jPanel1;
    public javax.swing.JButton medio;
    // End of variables declaration//GEN-END:variables
}
