
package Recursos;

import Instancia.AbrirFrame;
import Instancia.AbrirInstancia;
import com.formdev.flatlaf.FlatDarkLaf;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.ImageIcon;
import javax.swing.UIManager;

/**
 *
 * @author Malware Inc.
 */
public class Welcome extends javax.swing.JFrame {

    private static final String CONFIG_FILE_PATH = "config.txt";
    private static final String CONFIG_CONTENT = """
        <?xml version="1.0" encoding="UTF-8"?>
        <config>
            <general>
                <version>1.0.0</version>
                <app_name>Biblia App</app_name>
            </general>
            <configuration>
                <theme>creativos</theme>
                <language>es</language>
                <boolean>false</boolean>
            </configuracion>
        </config>
        """;
    private static final String CONFIG_TRUE = """
        <?xml version="1.0" encoding="UTF-8"?>
        <config>
            <general>
                <version>1.0.0</version>
                <app_name>Biblia App</app_name>
            </general>
            <configuration>
                <theme>creativos</theme>
                <language>es</language>
                <boolean>true</boolean>
            </configuracion>
        </config>
        """;
    
    private static void handleException(Exception e) {
        e.printStackTrace();
    }

    private static void crearArchivoConfigFalso() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(CONFIG_FILE_PATH))) {
            bw.write(CONFIG_CONTENT);
        } catch (IOException e) {
            handleException(e);
        }
    }
    private static void reescribir() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(CONFIG_FILE_PATH))) {
            bw.write(CONFIG_TRUE);
            System.out.println("Contenido escrito en config.txt: " + CONFIG_TRUE);
        } catch (IOException e) {
            handleException(e);
        }
    }
    
    public static void abrirPantalla() {
        new AbrirInstancia().instancia(new Load());
    }
    
    public Welcome() {
        initComponents();
        this.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(new ImageIcon(getClass().getResource("images/logo_pequeño(2).jpg")).getImage());
        setLocationRelativeTo(null);
        setResizable(false);
        setTitle("Terminos y condiciones");
        acepto.setEnabled(false);
        acepto.addActionListener(e -> { new AbrirFrame().instancia(acepto, new Load(), this);
            this.setVisible(false);
            reescribir();
        });
        negado.addActionListener(e->{System.exit(0);});
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();
        negado = new javax.swing.JButton();
        acepto = new javax.swing.JButton();
        check = new javax.swing.JCheckBox();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTextArea1.setColumns(20);
        jTextArea1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTextArea1.setRows(5);
        jTextArea1.setText("    Malware Inc no se hace responsable de las acciones tomadas por el usuario al usar este software, \n          tales como el acceso a páginas web externas o la manipulación de información personal.\n\nA. Uso Gratuito: El uso de este programa es completamente gratuito para el usuario final. No se \ncobrará ningún costo por su descarga ni uso.\n\nB. Distribución Libre: Puedes distribuir el programa libremente, siempre y cuando se mantengan \nintactos estos términos y condiciones. Queda prohibida la redistribución con fines comerciales o la \nmodificación del programa para integrarlo en otros productos de pago.\n\nC. Desarrollo Continuo: Este programa está en constante desarrollo. Si encuentras algún error o \ninconveniente, ten en cuenta que las versiones futuras corregirán estos problemas. Las nuevas \nactualizaciones estarán disponibles de forma periódica.\n\nD. Actualizaciones: Las actualizaciones del programa se publicarán en la página oficial de Malware Inc. \nPuedes acceder a ellas a través del siguiente enlace: \nhttps://www.facebook.com/Malware-Inc-103940839347349\n\nE. Apoyo y Contribuciones: Si deseas apoyar el proyecto de Héctor Villegas del AD CENTRO CRISTIANO \nMISIONERO, puedes hacerlo visitando su perfil de Facebook aquí: \nhttps://www.facebook.com/profile.php?id=100070849676473\n\nF. Errores y Correcciones: Si encuentras errores, ya sea ortográficos o técnicos, por favor notifícalos a \ntravés del sitio oficial. Estos serán corregidos en futuras versiones para mejorar la experiencia del \nusuario.\n\nG. Uso de Materiales: Todos los materiales incluidos en el programa, como códigos, gráficos, textos, \netc., deben ser utilizados de manera responsable y respetando las leyes de propiedad intelectual \naplicables. Este software no está destinado para su distribución o modificación sin la debida autorización.\n\nH. Prohibición de Venta: Queda estrictamente prohibida la venta, comercialización o redistribución del \nprograma o cualquier material asociado con fines comerciales. Esto incluye, pero no se limita a, la \nventa directa, la distribución a través de plataformas comerciales o su integración en productos o \nservicios pagos.\n\nI. Licencia Privativa: Este software no es de código abierto (open source) y su uso está restringido \npor los términos de esta licencia. No se permite la modificación del código fuente sin permiso explícito \nde los desarrolladores.\n\nJ. Responsabilidad sobre Base de Datos: La información almacenada en la base de datos es \nresponsabilidad exclusiva del usuario. Malware Inc no tiene acceso, control ni capacidad de \nmanipulación sobre los datos ingresados, ya que estos se guardan de forma local y privada, salvo \nque el propio usuario decida compartirlos. La protección y correcto uso de dicha información recae \núnicamente sobre el usuario.\n\nK. Uso de Código Privado: Está estrictamente prohibido el uso, copia o distribución de cualquier \ncódigo privado del software sin autorización expresa. Malware Inc se reserva el derecho de tomar \nacciones legales ante cualquier uso indebido. Solo se permite el uso y distribución de códigos \nclasificados como open source publicados por Malware Inc en repositorios públicos como GitHub o \nSourceForge, accesibles mediante descarga directa.\n\nL. Disfruta del Programa: Agradecemos que utilices nuestro software. Esperamos que sea una \nherramienta útil y eficaz en tu estudio. ¡Disfruta del programa! :)       \n");
        jTextArea1.setCaretPosition(0);
        jScrollPane1.setViewportView(jTextArea1);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, 690, 320));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Terminos y condiciones");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 10, -1, -1));

        negado.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        negado.setForeground(new java.awt.Color(0, 0, 0));
        negado.setText("No acepto");
        negado.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        negado.setContentAreaFilled(false);
        jPanel1.add(negado, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 410, 130, 40));

        acepto.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        acepto.setForeground(new java.awt.Color(0, 0, 0));
        acepto.setText("Aceptar");
        acepto.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        acepto.setContentAreaFilled(false);
        jPanel1.add(acepto, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 410, 130, 40));

        check.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        check.setForeground(new java.awt.Color(0, 0, 0));
        check.setText("Acepto los terminos y condiciones");
        check.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkActionPerformed(evt);
            }
        });
        jPanel1.add(check, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 370, -1, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/images/fondo_experimental6.jpeg"))); // NOI18N
        jLabel1.setText("jLabel1");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 750, 550));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 476, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void checkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkActionPerformed
        boolean isSelected = check.isSelected();
        acepto.setEnabled(isSelected);
        negado.setEnabled(!isSelected);
    }//GEN-LAST:event_checkActionPerformed

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
            java.util.logging.Logger.getLogger(Welcome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Welcome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Welcome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Welcome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        try{
            UIManager.setLookAndFeel(new FlatDarkLaf());
            UIManager.put("Component.arc", 50);
            UIManager.put("Button.arc", 20);
            UIManager.put("TextComponent.arc", 15);
            UIManager.put("ProgressBar.arc", 20);
            UIManager.put("Component.arc", 20);
            UIManager.put("TabbedPane.tabArc", 15);
        }catch(Exception e){ 
            e.printStackTrace();
        }
        File configFile = new File(CONFIG_FILE_PATH);
        if (!configFile.exists()) {
            System.out.println("Archivo de configuración no encontrado, creándolo...");
            crearArchivoConfigFalso();
        }

        try (BufferedReader br = new BufferedReader(new FileReader(configFile))) {
            boolean aceptado = br.lines().anyMatch(line -> line.contains("true"));
            if (aceptado) {
                abrirPantalla();
                return;
            }
        } catch (IOException e) {
            handleException(e);
        }
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Welcome().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton acepto;
    private javax.swing.JCheckBox check;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JButton negado;
    // End of variables declaration//GEN-END:variables
}
