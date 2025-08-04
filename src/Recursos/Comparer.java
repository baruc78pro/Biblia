package Recursos;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;


public class Comparer extends javax.swing.JFrame {

    
    private String url= "jdbc:sqlite:C:\\Users\\Cooler Master\\Documents\\NetBeansProjects\\Biblia\\src\\Recursos\\Base_de_datos\\Biblia.db";
    
    public Comparer() {
        initComponents();
        setIconImage(new ImageIcon(getClass().getResource("images/logo.png")).getImage());
        Rellenar();
        Buscar();
    }
    public void Rellenar(){
        try{
            Connection cn = DriverManager.getConnection(url);
            PreparedStatement pst = cn.prepareStatement("SELECT * FROM versiculos");
            ResultSet rs = pst.executeQuery();
            
        while(rs.next()){
            selector.addItem(rs.getString("nombre"));
        }
        
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Error al conectar a la base de datos.\n" + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        e.printStackTrace();
    }
    }
    
    public void Buscar(){
    try {
        String nombre = (String) selector.getSelectedItem().toString();
        
        Connection cn = DriverManager.getConnection(url);
        
        PreparedStatement pst = cn.prepareStatement("SELECT link FROM versiculos WHERE nombre = ?");
        pst.setString(1, nombre);
        
        ResultSet rs = pst.executeQuery();
        if (rs.next()) {
            String link = rs.getString("link");
            BusquedaWeb(link);
        } else {
            text.setText("No se encontró el link para este versículo.");
        }

    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Error al conectar a la base de datos.\n" + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        e.printStackTrace();
    }
}
    
    public void BusquedaWeb(String liga){
        try {
                Document doc = Jsoup.connect(liga).get();
                Element textoBiblico = doc.selectFirst(".passage-text"); // Selector de la clase que contiene el texto
                if (textoBiblico != null) {
                    String textoPlano = textoBiblico.text(); // Extraer solo el texto plano
                    text.setText(textoPlano);
                } else {
                    text.setText("Error: No se pudo encontrar el texto bíblico.");
                }
            } catch (IOException e) {
                text.setText("Error al obtener el texto: " + e.getMessage());
            }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        selector = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        text = new javax.swing.JTextPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(40, 40, 40));
        jPanel1.setForeground(new java.awt.Color(40, 40, 40));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.add(selector, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 20, 256, -1));

        text.setForeground(new java.awt.Color(250, 250, 250));
        jScrollPane1.setViewportView(text);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 64, 360, 400));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 415, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
            java.util.logging.Logger.getLogger(Comparer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Comparer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Comparer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Comparer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Comparer().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JComboBox<String> selector;
    private javax.swing.JTextPane text;
    // End of variables declaration//GEN-END:variables
}