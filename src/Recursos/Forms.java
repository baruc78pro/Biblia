package Recursos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.DriverManager;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import javax.swing.ImageIcon;

public class Forms extends javax.swing.JFrame {
    
    private String url= "jdbc:sqlite:C:\\Users\\Cooler Master\\Documents\\NetBeansProjects\\Biblia\\src\\Recursos\\Base_de_datos\\Biblia.db";
    
    public Forms() {
        initComponents();
        setIconImage(new ImageIcon(getClass().getResource("images/logo.png")).getImage());
        save.addActionListener(e -> Conexion());
    }
    
    private void Conexion() {
    try {
        Connection cn = DriverManager.getConnection(url);
        PreparedStatement pst = cn.prepareStatement("insert into versiculos (nombre, capitulo, link) values(?, ?, ?)");

        pst.setString(1, nombre.getText().trim());
        pst.setString(2, capitulo.getText().trim());
        pst.setString(3, liga.getText().trim());

        pst.executeUpdate();

        nombre.setText("");
        capitulo.setText("");
        liga.setText("");
        
        pst = cn.prepareStatement("SELECT * FROM versiculos");
        ResultSet rs = pst.executeQuery();
        
        while(rs.next()){
            new Comparer().selector.addItem(rs.getString("nombre"));
        }
        
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Error al conectar a la base de datos.\n" + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        e.printStackTrace();
    }
}
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        liga = new javax.swing.JTextField();
        nombre = new javax.swing.JTextField();
        capitulo = new javax.swing.JTextField();
        save = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(30, 30, 30));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Eras Light ITC", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 165, 0));
        jLabel1.setText("liga");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 190, -1, -1));

        jLabel2.setFont(new java.awt.Font("Eras Light ITC", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 165, 0));
        jLabel2.setText("Nombre del libro");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, -1, -1));

        jLabel3.setFont(new java.awt.Font("Eras Light ITC", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 165, 0));
        jLabel3.setText("capitulo");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, -1, -1));

        liga.setBackground(new java.awt.Color(30, 30, 30));
        liga.setFont(new java.awt.Font("Eras Light ITC", 0, 12)); // NOI18N
        liga.setForeground(new java.awt.Color(255, 255, 255));
        liga.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jPanel1.add(liga, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 220, 230, 20));

        nombre.setBackground(new java.awt.Color(30, 30, 30));
        nombre.setFont(new java.awt.Font("Eras Light ITC", 0, 12)); // NOI18N
        nombre.setForeground(new java.awt.Color(255, 255, 255));
        nombre.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jPanel1.add(nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, 230, 20));

        capitulo.setBackground(new java.awt.Color(30, 30, 30));
        capitulo.setFont(new java.awt.Font("Eras Light ITC", 0, 12)); // NOI18N
        capitulo.setForeground(new java.awt.Color(255, 255, 255));
        capitulo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jPanel1.add(capitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, 230, 20));

        save.setBackground(new java.awt.Color(30, 30, 30));
        save.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        save.setForeground(new java.awt.Color(255, 255, 255));
        save.setText("Guardar");
        save.setContentAreaFilled(false);
        jPanel1.add(save, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 140, 100, 40));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 386, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 330, Short.MAX_VALUE)
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
            java.util.logging.Logger.getLogger(Forms.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Forms.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Forms.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Forms.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Forms().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField capitulo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField liga;
    private javax.swing.JTextField nombre;
    private javax.swing.JButton save;
    // End of variables declaration//GEN-END:variables
}