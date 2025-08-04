package Recursos;

import Instancia.AbrirFrame;
import java.awt.Color;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextPane;


public class Maps extends javax.swing.JFrame {

    Map map = new Map();
    AbrirFrame frame = new AbrirFrame();
    String[] mapaRutas = {
        "images/mapas/mapa1.jpg",
        "images/mapas/mapa2.jpg",
        "images/mapas/mapa3.jpg",
        "images/mapas/mapa4.jpg",
        "images/mapas/mapa5.jpg",
        "images/mapas/mapa6.jpg",
        "images/mapas/mapa7.jpg",
        "images/mapas/mapa8.jpg",
        "images/mapas/mapa9.jpg",
        "images/mapas/mapa10.jpg",
        "images/mapas/mapa11.jpg",
        "images/mapas/mapa12.jpg"
    };
    
    private static final String DB_NAME = "Biblia.db";
    private static final String DB_URL = "jdbc:sqlite::resource:Recursos/Base_de_datos/" + DB_NAME;
    
    public Maps() {
        initComponents();
        this.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setIconImage(new ImageIcon(getClass().getResource("images/logo_pequeño(2).jpg")).getImage());
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setTitle("Selector de mapas");
        botones();
        panel.setBackground(Color.decode("#B2EBF2"));
    }

    public void botones() {
        JButton[] botonesMapa = {
            mapa1, mapa2, mapa3, mapa4, mapa5, mapa6,
            mapa7, mapa8, mapa9, mapa10, mapa11, mapa12
        };

        for (int i = 0; i < botonesMapa.length; i++) {
            int mapaIndex = i;
            botonesMapa[i].addActionListener(e -> {
                ImageIcon icon = new ImageIcon(getClass().getResource(mapaRutas[mapaIndex]));
                map.mapa.setIcon(icon);
                frame.instancia(botonesMapa[mapaIndex], map, this);
                mostrarMapa(mapaIndex + 1, map.mapa, map.text1, "images/mapas/mapa" + (mapaIndex + 1) + ".jpg");
                map.text1.setCaretPosition(0);
            });
        }
    }

    public void mostrarMapa(int idMapa, JLabel mapaLabel, JTextPane descripcionTextArea, String rutaImagen) {
    try {
        // Asegúrate de cargar el driver primero
        Class.forName("org.sqlite.JDBC");
        
            try (Connection con = DriverManager.getConnection(DB_URL);
                PreparedStatement pst = con.prepareStatement("SELECT descripcion FROM mapas WHERE id = ?")) {
            
                pst.setInt(1, idMapa);
            
                try (ResultSet rs = pst.executeQuery()) {
                    if (rs.next()) {
                       descripcionTextArea.setText(rs.getString("descripcion"));
                    } else {
                       descripcionTextArea.setText("Descripción no disponible.");
                    }
                }
            }
        } catch (ClassNotFoundException e) {
            JOptionPane.showMessageDialog(this, 
                "Error: Driver SQLite no encontrado..",
                "Error", JOptionPane.ERROR_MESSAGE);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, 
                "Error al acceder a la base de datos: " + e.getMessage() + 
                "\nRuta: " + DB_URL,
                "Error", JOptionPane.ERROR_MESSAGE);
        }
    
        ImageIcon icon = new ImageIcon(getClass().getResource(rutaImagen));
        mapaLabel.setIcon(icon);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        panel = new javax.swing.JPanel();
        mapa1 = new javax.swing.JButton();
        mapa2 = new javax.swing.JButton();
        mapa4 = new javax.swing.JButton();
        mapa3 = new javax.swing.JButton();
        mapa10 = new javax.swing.JButton();
        mapa9 = new javax.swing.JButton();
        mapa8 = new javax.swing.JButton();
        mapa7 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        mapa11 = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        mapa5 = new javax.swing.JButton();
        mapa6 = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        mapa12 = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panel.setPreferredSize(new java.awt.Dimension(1050, 290));
        panel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        mapa1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/images/boton_mostrar_mapa_2_copia.png"))); // NOI18N
        mapa1.setBorderPainted(false);
        mapa1.setContentAreaFilled(false);
        mapa1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        panel.add(mapa1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        mapa2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/images/boton_mostrar_mapa_2_copia.png"))); // NOI18N
        mapa2.setBorderPainted(false);
        mapa2.setContentAreaFilled(false);
        mapa2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        panel.add(mapa2, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 20, -1, -1));

        mapa4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/images/boton_mostrar_mapa_2_copia.png"))); // NOI18N
        mapa4.setBorderPainted(false);
        mapa4.setContentAreaFilled(false);
        mapa4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        panel.add(mapa4, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 20, -1, -1));

        mapa3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/images/boton_mostrar_mapa_2_copia.png"))); // NOI18N
        mapa3.setBorderPainted(false);
        mapa3.setContentAreaFilled(false);
        mapa3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        panel.add(mapa3, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 20, -1, -1));

        mapa10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/images/boton_mostrar_mapa_2_copia.png"))); // NOI18N
        mapa10.setBorderPainted(false);
        mapa10.setContentAreaFilled(false);
        mapa10.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        panel.add(mapa10, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 190, -1, -1));

        mapa9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/images/boton_mostrar_mapa_2_copia.png"))); // NOI18N
        mapa9.setBorderPainted(false);
        mapa9.setContentAreaFilled(false);
        mapa9.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        panel.add(mapa9, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 190, -1, -1));

        mapa8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/images/boton_mostrar_mapa_2_copia.png"))); // NOI18N
        mapa8.setBorderPainted(false);
        mapa8.setContentAreaFilled(false);
        mapa8.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        panel.add(mapa8, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 190, -1, -1));

        mapa7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/images/boton_mostrar_mapa_2_copia.png"))); // NOI18N
        mapa7.setBorderPainted(false);
        mapa7.setContentAreaFilled(false);
        mapa7.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        panel.add(mapa7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 190, -1, -1));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Mapa 2");
        panel.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 150, -1, -1));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Mapa 1");
        panel.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 150, -1, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Mapa 7");
        panel.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 320, -1, -1));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Mapa 8");
        panel.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 320, -1, -1));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("Mapa 3");
        panel.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 150, -1, -1));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("Mapa 4");
        panel.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 150, -1, -1));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setText("Mapa 9");
        panel.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 320, -1, -1));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 0));
        jLabel8.setText("Mapa 10");
        panel.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 320, -1, -1));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 0, 0));
        jLabel9.setText("Mapa 11");
        panel.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 320, -1, -1));

        mapa11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/images/boton_mostrar_mapa_2_copia.png"))); // NOI18N
        mapa11.setBorderPainted(false);
        mapa11.setContentAreaFilled(false);
        mapa11.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        panel.add(mapa11, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 190, -1, -1));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 0, 0));
        jLabel10.setText("Mapa 5");
        panel.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 150, -1, -1));

        mapa5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/images/boton_mostrar_mapa_2_copia.png"))); // NOI18N
        mapa5.setBorderPainted(false);
        mapa5.setContentAreaFilled(false);
        mapa5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        panel.add(mapa5, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 20, -1, -1));

        mapa6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/images/boton_mostrar_mapa_2_copia.png"))); // NOI18N
        mapa6.setBorderPainted(false);
        mapa6.setContentAreaFilled(false);
        mapa6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        panel.add(mapa6, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 20, -1, -1));

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 0, 0));
        jLabel11.setText("Mapa 6");
        panel.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 150, -1, -1));

        mapa12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/images/boton_mostrar_mapa_2_copia.png"))); // NOI18N
        mapa12.setBorderPainted(false);
        mapa12.setContentAreaFilled(false);
        mapa12.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        panel.add(mapa12, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 190, -1, -1));

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(0, 0, 0));
        jLabel12.setText("Mapa 12");
        panel.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 320, -1, -1));

        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/images/maps_font.png"))); // NOI18N
        panel.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -4, 640, 420));

        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/images/maps_font.png"))); // NOI18N
        panel.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(633, -4, 430, 420));

        jScrollPane1.setViewportView(panel);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 508, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 419, Short.MAX_VALUE)
        );

        setSize(new java.awt.Dimension(524, 427));
        setLocationRelativeTo(null);
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
            java.util.logging.Logger.getLogger(Maps.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Maps.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Maps.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Maps.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Maps().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton mapa1;
    private javax.swing.JButton mapa10;
    private javax.swing.JButton mapa11;
    private javax.swing.JButton mapa12;
    private javax.swing.JButton mapa2;
    private javax.swing.JButton mapa3;
    private javax.swing.JButton mapa4;
    private javax.swing.JButton mapa5;
    private javax.swing.JButton mapa6;
    private javax.swing.JButton mapa7;
    private javax.swing.JButton mapa8;
    private javax.swing.JButton mapa9;
    private javax.swing.JPanel panel;
    // End of variables declaration//GEN-END:variables
}