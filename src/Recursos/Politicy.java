package Recursos;

import java.awt.Graphics;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JScrollBar;
import javax.swing.text.DefaultCaret;
import scrollbar.ScrollBarGreen;

public class Politicy extends javax.swing.JFrame {

    private static final ScrollBarGreen hr = new ScrollBarGreen();
    
    public Politicy() {
        initComponents();
        this.setResizable(false);
        setIconImage(new ImageIcon(getClass().getResource("images/logo.png")).getImage());
        scrollPane.setBorder(BorderFactory.createEmptyBorder());
        scrollPane2.setBorder(BorderFactory.createEmptyBorder());
        scrollPane.setVerticalScrollBar(new ScrollBarGreen());
        scrollPane2.setVerticalScrollBar(new ScrollBarGreen());
        hr.setOrientation(JScrollBar.HORIZONTAL);
        scrollPane.setHorizontalScrollBar(hr);
        scrollPane2.setHorizontalScrollBar(hr);
        text.setBorder(null);
        text.getCaret().setBlinkRate(0);
        text.setCaret(new DefaultCaret() {
            @Override
            public void paint(Graphics g) {
            }
        });
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        scrollPane2 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        scrollPane = new javax.swing.JScrollPane();
        text = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setPreferredSize(new java.awt.Dimension(204, 750));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 102, 102));
        jLabel2.setText("Bienvenido a terminos y condiciones");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 20, -1, -1));

        text.setBackground(new java.awt.Color(189, 142, 106));
        text.setColumns(20);
        text.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        text.setForeground(new java.awt.Color(255, 255, 255));
        text.setRows(5);
        text.setText("\"Malware Inc no se hace responsable de las acciones tomadas por el usuario al usar este software, \n tales como el acceso a páginas web externas o la manipulación de información personal.\"\n\nA. Uso Gratuito: El uso de este programa es completamente gratuito para el usuario final. No se \ncobrará ningún costo por su descarga ni uso.\n\nB. Distribución Libre: Puedes distribuir el programa libremente, siempre y cuando se mantengan \nintactos estos términos y condiciones. Queda prohibida la redistribución con fines comerciales o la \nmodificación del programa para integrarlo en otros productos de pago.\n\nC. Desarrollo Continuo: Este programa está en constante desarrollo. Si encuentras algún error o \ninconveniente, ten en cuenta que las versiones futuras corregirán estos problemas. Las nuevas \nactualizaciones estarán disponibles de forma periódica.\n\nD. Actualizaciones: Las actualizaciones del programa se publicarán en la página oficial de Malware Inc. \nPuedes acceder a ellas a través del siguiente enlace: \nhttps://www.facebook.com/Malware-Inc-103940839347349\n\nE. Apoyo y Contribuciones: Si deseas apoyar el proyecto de Héctor Villegas del AD CENTRO CRISTIANO \nMISIONERO, puedes hacerlo visitando su perfil de Facebook aquí: \nhttps://www.facebook.com/profile.php?id=100070849676473\n\nF. Errores y Correcciones: Si encuentras errores, ya sea ortográficos o técnicos, por favor notifícalos a \ntravés del sitio oficial. Estos serán corregidos en futuras versiones para mejorar la experiencia del \nusuario.\n\nG. Uso de Materiales: Todos los materiales incluidos en el programa, como códigos, gráficos, textos, \netc., deben ser utilizados de manera responsable y respetando las leyes de propiedad intelectual \naplicables. Este software no está destinado para su distribución o modificación sin la debida autorización.\n\nH. Prohibición de Venta: Queda estrictamente prohibida la venta, comercialización o redistribución del \nprograma o cualquier material asociado con fines comerciales. Esto incluye, pero no se limita a, la \nventa directa, la distribución a través de plataformas comerciales o su integración en productos o \nservicios pagos.\n\nI. Licencia Privativa: Este software no es de código abierto (open source) y su uso está restringido \npor los términos de esta licencia. No se permite la modificación del código fuente sin permiso explícito \nde los desarrolladores.\n\nJ. Responsabilidad sobre Base de Datos: La información almacenada en la base de datos es \nresponsabilidad exclusiva del usuario. Malware Inc no tiene acceso, control ni capacidad de \nmanipulación sobre los datos ingresados, ya que estos se guardan de forma local y privada, salvo \nque el propio usuario decida compartirlos. La protección y correcto uso de dicha información recae \núnicamente sobre el usuario.\n\nK. Uso de Código Privado: Está estrictamente prohibido el uso, copia o distribución de cualquier \ncódigo privado del software sin autorización expresa. Malware Inc se reserva el derecho de tomar \nacciones legales ante cualquier uso indebido. Solo se permite el uso y distribución de códigos \nclasificados como open source publicados por Malware Inc en repositorios públicos como GitHub o \nSourceForge, accesibles mediante descarga directa.\n\nL. Disfruta del Programa: Agradecemos que utilices nuestro software. Esperamos que sea una \nherramienta útil y eficaz en tu estudio. ¡Disfruta del programa! :)");
        text.setCaretPosition(0);
        scrollPane.setViewportView(text);

        jPanel1.add(scrollPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 410, 620, 320));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/images/terminos.png"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-80, -10, -1, -1));

        scrollPane2.setViewportView(jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(scrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 657, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(scrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 495, Short.MAX_VALUE)
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
            java.util.logging.Logger.getLogger(Politicy.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Politicy.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Politicy.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Politicy.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Politicy().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane scrollPane;
    private javax.swing.JScrollPane scrollPane2;
    private javax.swing.JTextArea text;
    // End of variables declaration//GEN-END:variables
}
