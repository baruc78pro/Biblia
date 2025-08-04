package Chimpy;

import Instancia.AbrirFrame;
import Rastreo.Logger;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.text.DefaultCaret;

public class Panel extends javax.swing.JFrame {

    
    public Panel() {
        initComponents();
        setLocationRelativeTo(null);
        setResizable(false);
        setIconImage(new ImageIcon(getClass().getResource("/Recursos/images/logo.png")).getImage());
        panel.setBackground(Color.decode("#FFEBEE"));
        add.setBackground(Color.decode("#EF5350"));
        edit.setBackground(Color.decode("#EF5350"));
        web.setBackground(Color.decode("#EF5350"));
        lb1.setForeground(Color.decode("#880E4F"));
        lb2.setForeground(Color.decode("#880E4F"));
        text.setBackground(Color.decode("#FFEBEE"));
        text.setForeground(Color.decode("#4A148C"));
        scrollPane.setBorder(BorderFactory.createEmptyBorder());
        text.setBorder(null);
        text.getCaret().setBlinkRate(0);
        text.setCaret(new DefaultCaret() {
            @Override
            public void paint(Graphics g) {
            }
        });
        txt.setBackground(Color.decode("#FFEBEE"));
        txt.setForeground(Color.decode("#4A148C"));
        txt.setBorder(null);
        txt.getCaret().setBlinkRate(0);
        txt.setCaret(new DefaultCaret() {
            @Override
            public void paint(Graphics g) {
            }
        });
        scrollPane1.setBorder(BorderFactory.createEmptyBorder());
        add.addActionListener(e->JOptionPane.showMessageDialog(null, "Proximamente Chimpy"));
        edit.addActionListener(e->new AbrirFrame().instancia(new Hoja(), this));
        web.addActionListener(e->addMenuUrl(web, "https://sourceforge.net/projects/chimpy.biblia-java.p/"));
    }
    
    private void addMenuUrl(JButton button, String url) {
        button.addActionListener(e -> {
            Logger.logEvent("Chimpy", "Enlace abierto: " + url);
            requestFocusInWindow();
        });
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        panel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        edit = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        lb1 = new javax.swing.JLabel();
        add = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        scrollPane = new javax.swing.JScrollPane();
        text = new javax.swing.JTextPane();
        lb2 = new javax.swing.JLabel();
        scrollPane1 = new javax.swing.JScrollPane();
        txt = new javax.swing.JTextArea();
        web = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        panel.setBackground(new java.awt.Color(255, 255, 255));
        panel.setPreferredSize(new java.awt.Dimension(48, 755));
        panel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("SansSerif", 0, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/images/chimpy/log1.png"))); // NOI18N
        panel.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 50, -1, -1));

        edit.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        edit.setForeground(new java.awt.Color(255, 255, 255));
        edit.setText("</>");
        edit.setBorder(null);
        panel.add(edit, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 150, 78, 74));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText(" sitio web");
        panel.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 230, 80, -1));

        lb1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        lb1.setText("Más de Chimpy");
        panel.add(lb1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 280, 180, -1));

        add.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        add.setForeground(new java.awt.Color(255, 255, 255));
        add.setText("+");
        add.setBorder(null);
        panel.add(add, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 150, 78, 74));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("nuevo archivo");
        panel.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 230, -1, -1));

        text.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        text.setText("Chimpy es una herramienta para personalización con este proyecto,  una capa extra por el usuario otorgando una forma oficial y segura.  Además de ser operable 100% con Java para la extensión de funciones del propio software sin la necesidad de interactuar con el código base de los modulos.");
        scrollPane.setViewportView(text);

        panel.add(scrollPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 320, 390, 200));

        lb2.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        lb2.setText("Edición de Chimpy");
        panel.add(lb2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 530, 220, -1));

        txt.setColumns(20);
        txt.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txt.setRows(5);
        txt.setText("Versión Bible Java preview 0.1\nQueda prohibida la venta de esta edición, la \nedición independiente es solo código abierto.\n\n© 2025 Malware Inc. Todos los derechos \nreservados.\n\n");
        scrollPane1.setViewportView(txt);

        panel.add(scrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(28, 570, 400, 220));

        web.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        web.setForeground(new java.awt.Color(255, 255, 255));
        web.setText("...");
        web.setBorder(null);
        panel.add(web, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 150, 78, 74));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("editar");
        panel.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 230, -1, -1));

        jScrollPane1.setViewportView(panel);

        jMenu1.setText("Seleccionar tema");

        jMenuItem1.setText("Tema rosa");
        jMenu1.add(jMenuItem1);

        jMenuItem2.setText("Tema Amarillo");
        jMenu1.add(jMenuItem2);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 475, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 346, Short.MAX_VALUE)
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
            java.util.logging.Logger.getLogger(Panel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Panel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Panel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Panel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Panel().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton add;
    private javax.swing.JButton edit;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lb1;
    private javax.swing.JLabel lb2;
    private javax.swing.JPanel panel;
    private javax.swing.JScrollPane scrollPane;
    private javax.swing.JScrollPane scrollPane1;
    private javax.swing.JTextPane text;
    private javax.swing.JTextArea txt;
    private javax.swing.JButton web;
    // End of variables declaration//GEN-END:variables
}
