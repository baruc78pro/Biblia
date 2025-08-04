package Recursos;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.ImageIcon;
import javax.swing.Timer;
import Estilos.Icono;
import Instancia.AbrirFrame;
import javax.swing.JOptionPane;

public class Load extends javax.swing.JFrame {

    private static final String CONFIG_FILE = "config.txt";
    private static final Menu inicio = new Menu();
    private static final Updates actualizacion = new Updates();
    
    public Load() {
        setUndecorated(true);
        initComponents();
        setIconImage(new ImageIcon(getClass().getResource("images/logo.png")).getImage());
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        String tema = leerTemaDesdeConfig();
        if (tema != null) {
            aplicarEstilo(tema);
        }
        
        iniciarProgressBar();
    }
    
    private void iniciarProgressBar() {
        Timer timer = new Timer(15, (ActionEvent e) -> {
            pbCarga.setValue(pbCarga.getValue() + 1);
            pbCarga.setBackground(Color.decode("#ee9078"));
            pbCarga.setForeground(Color.decode("#ffbf6a"));
            
            if (pbCarga.getValue() >= pbCarga.getMaximum()) {
                ((Timer) e.getSource()).stop();
                mostrarPantallaInicio();
            }
        });
        timer.start();
    }
    
    private void mostrarPantallaInicio() {
        new AbrirFrame().instancia(inicio, this);
        new AbrirFrame().instancia(actualizacion, this);
        this.dispose();
    }
    
    private void aplicarEstilo(String estilo) {
        Icono icono = new Icono();
        switch (estilo) {
            case "creativos":
            case "normales":
                icono.aplicarIconos(inicio, estilo);
                break;
            default:
                JOptionPane.showMessageDialog(null, "Error, iconos no encontrados", 
                        "ERROR", JOptionPane.ERROR_MESSAGE);
                break;
        }
    }
    
    private String leerTemaDesdeConfig() {
        File configFile = new File(CONFIG_FILE);
        if (!configFile.exists()) {
            System.out.println("Archivo de configuración no encontrado.");
            return null;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(configFile))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.contains("<theme>")) {
                    return line.replace("<theme>", "").replace("</theme>", "").trim();
                }
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return null;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        pbCarga = new progressbar.ProgressBarCustom();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(51, 51, 51));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pbCarga.setBackground(new java.awt.Color(0, 0, 102));
        pbCarga.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(pbCarga, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 430, 740, 10));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/images/intro/intro.png"))); // NOI18N
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 740, 440));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 441, Short.MAX_VALUE)
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
            java.util.logging.Logger.getLogger(Load.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Load.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Load.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Load.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Load().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    public javax.swing.JProgressBar pbCarga;
    // End of variables declaration//GEN-END:variables
}